package com.binary.servermonitor.kafka_to_es.jvm;

import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.OperatingSystemInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.RuntimeInfoBean;
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
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 夕
 * @date 2019/5/31
 */
@Component
public class RuntimeInfo implements Job {


    @Autowired
    private JVMConfigBean jvmConfigBeanInfo;

    private static JVMConfigBean jvmConfigBean;

    @PostConstruct
    public void init(){
        jvmConfigBean = jvmConfigBeanInfo;
    }


    private static RuntimeInfoBean runtimeInfoBean = new RuntimeInfoBean();

    static final long MB = 1024 * 1024;

    private void sendToES() throws IOException {

        List<String> list = jvmConfigBean.getList();

        for(String str : list){
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+str+"/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection mbs = conn.getMBeanServerConnection();
            RuntimeMXBean runtimeMXBean = ManagementFactory.newPlatformMXBeanProxy
                    (mbs,ManagementFactory.RUNTIME_MXBEAN_NAME,RuntimeMXBean.class);

            runtimeInfoBean.setHost(str);
            runtimeInfoBean.setDate(DateFormat.getNowTime());
            runtimeInfoBean.setJvmVersion(runtimeMXBean.getVmName());
            runtimeInfoBean.setJvmRunTime(runtimeMXBean.getUptime());
            runtimeInfoBean.setBootClassPath(runtimeMXBean.getBootClassPath());
            runtimeInfoBean.setClassPath(runtimeMXBean.getClassPath());
            runtimeInfoBean.setLibraryPath(runtimeMXBean.getLibraryPath());
            runtimeInfoBean.setJvmArguments(runtimeMXBean.getInputArguments());

            EsUtils.sendDataToIndex(IndexList.jvmRuntimeInfoIndex,runtimeInfoBean.toJsonString());
            conn.close();
        }
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            sendToES();
        } catch (IOException e) {
            System.out.println("RuntimeInfo  Job  :  " + e.getMessage());
        }
    }

}
