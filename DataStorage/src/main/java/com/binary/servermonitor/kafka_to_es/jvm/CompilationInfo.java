package com.binary.servermonitor.kafka_to_es.jvm;

import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.ClassLoadingInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.CompilationInfoBean;
import com.binary.servermonitor.kafka_to_es.util.DateFormat;
import com.binary.servermonitor.kafka_to_es.util.EsUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/30
 */
@Component
public class CompilationInfo implements Job {

    @Autowired
    private JVMConfigBean jvmConfigBeanInfo;

    private static JVMConfigBean jvmConfigBean;

    @PostConstruct
    public void init(){
        jvmConfigBean = jvmConfigBeanInfo;
    }

    private static CompilationInfoBean compilationInfoBean = new CompilationInfoBean();

    private void sendToES() throws IOException {

        List<String> list = jvmConfigBean.getList();

        for(String str : list){
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+str+"/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection mbs = conn.getMBeanServerConnection();
            CompilationMXBean compilationMXBean = ManagementFactory.newPlatformMXBeanProxy
                    (mbs,ManagementFactory.COMPILATION_MXBEAN_NAME, CompilationMXBean.class);

            compilationInfoBean.setHost(str);
            compilationInfoBean.setDate(DateFormat.getNowTime());
            compilationInfoBean.setCompilationName(compilationMXBean.getName());
            compilationInfoBean.setCompilationTotalTime(compilationMXBean.getTotalCompilationTime());

            EsUtils.sendDataToIndex(IndexList.compilationInfoIndex,compilationInfoBean.toJsonString());
            conn.close();
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            sendToES();
        } catch (IOException e) {
            System.out.println("CompilationInfo Job  :  " + e.getMessage());
        }
    }
}
