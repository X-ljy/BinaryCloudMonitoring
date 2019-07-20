package com.binary.servermonitor.kafka_to_es.jvm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.RuntimeInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.jvmbean.ThreadInfoBean;
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
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Component
public class ThreadInfo implements Job {


    @Autowired
    private JVMConfigBean jvmConfigBeanInfo;

    private static JVMConfigBean jvmConfigBean;

    @PostConstruct
    public void init(){
        jvmConfigBean = jvmConfigBeanInfo;
    }


    private static ThreadInfoBean threadInfoBean = new ThreadInfoBean();

    static final long MB = 1024 * 1024;

    private void sendToES() throws IOException {

        List<String> list = jvmConfigBean.getList();

        for(String str : list){
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+str+"/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
            MBeanServerConnection mbs = conn.getMBeanServerConnection();
            ThreadMXBean threadMXBean = ManagementFactory.newPlatformMXBeanProxy
                    (mbs,ManagementFactory.THREAD_MXBEAN_NAME,ThreadMXBean.class);

            threadInfoBean.setHost(str);
            threadInfoBean.setDate(DateFormat.getNowTime());
            threadInfoBean.setAliveThreadCount(threadMXBean.getThreadCount());
            threadInfoBean.setPeakThreadCount(threadMXBean.getPeakThreadCount());
            threadInfoBean.setTotalStartedThreadCount(threadMXBean.getTotalStartedThreadCount());
            threadInfoBean.setDaemonThreadCount(threadMXBean.getDaemonThreadCount());

            //所有线程信息
            JSONArray resjsonArray = new JSONArray();
            long[] threadIds = threadMXBean.getAllThreadIds();
            if(threadIds != null && threadIds.length > 0){
                java.lang.management.ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
                for(java.lang.management.ThreadInfo threadInfo : threadInfos){
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(0,String.valueOf(threadInfo.getThreadId()));
                    jsonArray.add(1,threadInfo.getThreadName());
                    jsonArray.add(2,threadInfo.getThreadState());
                    resjsonArray.add(jsonArray);
                }
            }


            threadInfoBean.setAllThreadInfo(resjsonArray.toString());

            //死锁信息
            long[] deadlockedIds =  threadMXBean.findDeadlockedThreads();
            JSONObject jsonObjectLock = new JSONObject();
            if(deadlockedIds != null && deadlockedIds.length > 0){
                java.lang.management.ThreadInfo[] deadlockInfos = threadMXBean.getThreadInfo(deadlockedIds);
                for(java.lang.management.ThreadInfo deadlockInfo : deadlockInfos){
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(0,deadlockInfo.getBlockedTime());
                    jsonArray.add(1,deadlockInfo.getWaitedTime());
                    jsonArray.add(2,deadlockInfo.getStackTrace());
                    jsonArray.add(3,deadlockInfo.getThreadState());
                    jsonObjectLock.put(deadlockInfo.getThreadName(),jsonArray);
                }
                threadInfoBean.setDeadlockedThreadInfo(jsonObjectLock.toString());
            }else {
                threadInfoBean.setDeadlockedThreadInfo("");
            }
            EsUtils.sendDataToIndex(IndexList.threadInfoIndex,threadInfoBean.toJsonString());
            conn.close();
        }
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            sendToES();
        } catch (IOException e) {
            System.out.println("ThreadInfo  Job  :  " + e.getMessage());
        }
    }

}
