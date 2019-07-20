package com.binary.servermonitor.kafka_to_es.jvm;

import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.ClassLoadingInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.MemoryInfoBean;
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
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/30
 */
@Component
public class MemoryInfo implements Job {
    @Autowired
    private JVMConfigBean jvmConfigBeanInfo;

    private static JVMConfigBean jvmConfigBean;

    @PostConstruct
    public void init(){
        jvmConfigBean = jvmConfigBeanInfo;
    }

    private static MemoryInfoBean memoryInfoBean = new MemoryInfoBean();

    private void sendToES() throws IOException {

        List<String> list = jvmConfigBean.getList();

        for(String str : list){
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+str+"/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection mbs = conn.getMBeanServerConnection();
            MemoryMXBean memoryMXBean = ManagementFactory.newPlatformMXBeanProxy
                    (mbs,ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);

            memoryInfoBean.setHost(str);
            memoryInfoBean.setDate(DateFormat.getNowTime());

            //heap
            MemoryUsage headMemory = memoryMXBean.getHeapMemoryUsage();
            memoryInfoBean.setHeapInit(headMemory.getInit());
            memoryInfoBean.setHeapMax(headMemory.getMax());
            memoryInfoBean.setHeapUsed(headMemory.getUsed());
            memoryInfoBean.setHeapCommitted(headMemory.getCommitted());
            memoryInfoBean.setHeapUseRate((int) (headMemory.getUsed()*100/headMemory.getCommitted()));

            //noHeap
            MemoryUsage nonheadMemory = memoryMXBean.getNonHeapMemoryUsage();
            memoryInfoBean.setNoHeapInit(nonheadMemory.getInit());
            memoryInfoBean.setNoHeapMax(nonheadMemory.getMax());
            memoryInfoBean.setNoHeapUsed(nonheadMemory.getUsed());
            memoryInfoBean.setNoHeapCommitted(nonheadMemory.getCommitted());
            memoryInfoBean.setNoHeapUseRate((int) (nonheadMemory.getUsed()*100/nonheadMemory.getCommitted()));


            EsUtils.sendDataToIndex(IndexList.jvmMemoryInfoIndex,memoryInfoBean.toJsonString());
            conn.close();
        }
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            sendToES();
        } catch (IOException e) {
            System.out.println("ClassLoadingInfo  Job  :  " + e.getMessage());
        }
    }

}
