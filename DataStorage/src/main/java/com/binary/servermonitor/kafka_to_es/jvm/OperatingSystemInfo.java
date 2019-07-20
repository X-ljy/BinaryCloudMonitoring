package com.binary.servermonitor.kafka_to_es.jvm;

import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.ClassLoadingInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.OperatingSystemInfoBean;
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
import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 夕
 * @date 2019/5/30
 */
@Component
public class OperatingSystemInfo implements Job {


    @Autowired
    private JVMConfigBean jvmConfigBeanInfo;

    private static JVMConfigBean jvmConfigBean;

    @PostConstruct
    public void init(){
        jvmConfigBean = jvmConfigBeanInfo;
    }


    private static OperatingSystemInfoBean operatingSystemInfoBean = new OperatingSystemInfoBean();

    static final long MB = 1024 * 1024;

    private void sendToES() throws IOException {

        List<String> list = jvmConfigBean.getList();

        for(String str : list){
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+str+"/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection mbs = conn.getMBeanServerConnection();
            com.sun.management.OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy
                    (mbs,ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,com.sun.management.OperatingSystemMXBean.class);

            operatingSystemInfoBean.setHost(str);
            operatingSystemInfoBean.setDate(DateFormat.getNowTime());
            operatingSystemInfoBean.setOsName(operatingSystemMXBean.getName());
            operatingSystemInfoBean.setOsVersion(operatingSystemMXBean.getVersion());
            operatingSystemInfoBean.setOsArch(operatingSystemMXBean.getArch());
            operatingSystemInfoBean.setOsAvailableProcessors(operatingSystemMXBean.getAvailableProcessors());

            operatingSystemInfoBean.setTotalPhysicalMemory(operatingSystemMXBean.getTotalPhysicalMemorySize()/MB);
            operatingSystemInfoBean.setFreePhysicalMemory(operatingSystemMXBean.getFreePhysicalMemorySize()/MB);
            operatingSystemInfoBean.setTotalSwapSpaceSize(operatingSystemMXBean.getTotalSwapSpaceSize()/MB);
            operatingSystemInfoBean.setFreeSwapSpaceSize(operatingSystemMXBean.getFreeSwapSpaceSize()/MB);

            operatingSystemInfoBean.setUsedPhysicalMemorySize((operatingSystemMXBean.getTotalPhysicalMemorySize() - operatingSystemMXBean.getFreePhysicalMemorySize())/MB);
            operatingSystemInfoBean.setUsedSwapSpaceSize((operatingSystemMXBean.getTotalSwapSpaceSize() - operatingSystemMXBean.getFreeSwapSpaceSize())/MB);


            Long start = System.currentTimeMillis();
            long startT = operatingSystemMXBean.getProcessCpuTime();
            /**    Collect data every 60 seconds      */
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                System.out.println("OperatingSystemInfo job :  " + e.getMessage());
            }
            Long end = System.currentTimeMillis();
            long endT = operatingSystemMXBean.getProcessCpuTime();

            double ratio = (endT-startT)/100000.0/(end-start)/operatingSystemMXBean.getAvailableProcessors();

            operatingSystemInfoBean.setCpuUseRate(ratio);

            EsUtils.sendDataToIndex(IndexList.operatingSystemInfoIndex,operatingSystemInfoBean.toJsonString());
            conn.close();
        }
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            sendToES();
        } catch (IOException e) {
            System.out.println("OperatingSystemInfo  Job  :  " + e.getMessage());
        }
    }

}