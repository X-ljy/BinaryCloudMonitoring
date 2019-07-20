package com.binary.servermonitor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author 夕
 * @date 2019/5/28
 */
@Component()
public class JvmServerConn {
    

    static final long MB = 1024 * 1024;

    private static void printOperatingSystemInfo() throws IOException {

        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"10.10.44.128:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();

        com.sun.management.OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, com.sun.management.OperatingSystemMXBean.class);


        //相当于System.getProperty("os.name").
        System.out.println("系统名称:"+operatingSystemMXBean.getName());
        //相当于System.getProperty("os.version").
        System.out.println("系统版本:"+operatingSystemMXBean.getVersion());
        //相当于System.getProperty("os.arch").
        System.out.println("操作系统的架构:"+operatingSystemMXBean.getArch());
        //相当于 Runtime.availableProcessors()
        System.out.println("可用的内核数:"+operatingSystemMXBean.getAvailableProcessors());


        long totalPhysicalMemory = operatingSystemMXBean.getTotalPhysicalMemorySize();
        long freePhysicalMemory = operatingSystemMXBean.getFreePhysicalMemorySize();
        long usedPhysicalMemorySize =totalPhysicalMemory - freePhysicalMemory;

        System.out.println("总物理内存(M):"+totalPhysicalMemory/MB);
        System.out.println("已用物理内存(M):"+usedPhysicalMemorySize/MB);
        System.out.println("剩余物理内存(M):"+freePhysicalMemory/MB);

        long  totalSwapSpaceSize = operatingSystemMXBean.getTotalSwapSpaceSize();
        long freeSwapSpaceSize = operatingSystemMXBean.getFreeSwapSpaceSize();
        long usedSwapSpaceSize = totalSwapSpaceSize - freeSwapSpaceSize;

        System.out.println("总交换空间(M):"+totalSwapSpaceSize/MB);
        System.out.println("已用交换空间(M):"+usedSwapSpaceSize/MB);
        System.out.println("剩余交换空间(M):"+freeSwapSpaceSize/MB);


        Long start = System.currentTimeMillis();
        long startT = operatingSystemMXBean.getProcessCpuTime();
        /**    Collect data every 5 seconds      */
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        Long end = System.currentTimeMillis();
        long endT = operatingSystemMXBean.getProcessCpuTime();

        double ratio = (endT-startT)/10000.0/(end-start)/operatingSystemMXBean.getAvailableProcessors();
        System.out.println("CPU使用率：" + ratio);

    }

    
    private static void printCompilationInfo() throws IOException {
        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"10.10.44.128:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();

        CompilationMXBean compilationMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.COMPILATION_MXBEAN_NAME, CompilationMXBean.class);
        
        System.out.println("JIT编译器名称："+compilationMXBean.getName());
        //判断jvm是否支持编译时间的监控
        System.out.println("总编译时间："+compilationMXBean.getTotalCompilationTime()+"秒");
    }


    private static void printClassLoadingInfo() throws IOException {

        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"10.10.44.128:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.CLASS_LOADING_MXBEAN_NAME, ClassLoadingMXBean.class);

        System.out.println("已加载类总数："+classLoadingMXBean.getTotalLoadedClassCount());
        System.out.println("已加载当前类："+classLoadingMXBean.getLoadedClassCount());
        System.out.println("已卸载类总数："+classLoadingMXBean.getUnloadedClassCount());
    }

    private static void printRuntimeInfo() throws IOException {

        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"49.82.41.170:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();

        RuntimeMXBean runtimeMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.RUNTIME_MXBEAN_NAME, RuntimeMXBean.class);
        
//        System.out.println("进程PID="+runtimeMXBean.getName().split("@")[0]);
//        System.out.println("jvm规范名称:"+runtimeMXBean.getSpecName());
//        System.out.println("jvm规范运营商:"+runtimeMXBean.getSpecVendor());
        System.out.println("jvm规范版本:"+runtimeMXBean.getSpecVersion());
        //返回虚拟机在毫秒内的开始时间。该方法返回了虚拟机启动时的近似时间
//        System.out.println("jvm启动时间（毫秒）:"+runtimeMXBean.getStartTime());
        //相当于System.getProperties
//        System.out.println("获取System.properties:"+runtimeMXBean.getSystemProperties());
        System.out.println("jvm正常运行时间（毫秒）:"+runtimeMXBean.getUptime());
        //相当于System.getProperty("java.vm.name").
        System.out.println("jvm名称:"+runtimeMXBean.getVmName());
        //相当于System.getProperty("java.vm.vendor").
        System.out.println("jvm运营商:"+runtimeMXBean.getVmVendor());
        //相当于System.getProperty("java.vm.version").
        System.out.println("jvm实现版本:"+runtimeMXBean.getVmVersion());
        List<String> args = runtimeMXBean.getInputArguments();
        if(args != null && !args.isEmpty()){
            System.out.println("vm参数:");
            for(String arg : args){
                System.out.println(arg);
            }
        }
        System.out.println("类路径:"+runtimeMXBean.getClassPath());
        System.out.println("引导类路径:"+runtimeMXBean.getBootClassPath());
        System.out.println("库路径:"+runtimeMXBean.getLibraryPath());
    }



    private static void printMemoryInfo() throws IOException {

        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"10.10.44.128:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();
        MemoryMXBean memoryMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
        
        MemoryUsage headMemory = memoryMXBean.getHeapMemoryUsage();
        System.out.println("head堆:");
        System.out.println("\t初始(M):"+headMemory.getInit()/MB);
        System.out.println("\t最大(上限)(M):"+headMemory.getMax()/MB);
        System.out.println("\t当前(已使用)(M):"+headMemory.getUsed()/MB);
        System.out.println("\t提交的内存(已申请)(M):"+headMemory.getCommitted()/MB);
        System.out.println("\t使用率:"+headMemory.getUsed()*100/headMemory.getCommitted()+"%");

        System.out.println("non-head非堆:");
        MemoryUsage nonheadMemory = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("\t初始(M):"+nonheadMemory.getInit()/MB);
        System.out.println("\t最大(上限)(M):"+nonheadMemory.getMax()/MB);
        System.out.println("\t当前(已使用)(M):"+nonheadMemory.getUsed()/MB);
        System.out.println("\t提交的内存(已申请)(M):"+nonheadMemory.getCommitted()/MB);
        System.out.println("\t使用率:"+nonheadMemory.getUsed()*100/nonheadMemory.getCommitted()+"%");

    }

    private static void printThreadInfo() throws IOException {
        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi://localhost:0/jndi/rmi://"+"10.10.44.128:1024"+"/jmxrmi");
        JMXConnector conn = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbs = conn.getMBeanServerConnection();

        ThreadMXBean threadMXBean = ManagementFactory.newPlatformMXBeanProxy
                (mbs,ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);

        System.out.println("ObjectName="+threadMXBean.getObjectName());
        System.out.println("仍活动的线程总数="+threadMXBean.getThreadCount());
        System.out.println("峰值="+threadMXBean.getPeakThreadCount());
        System.out.println("线程总数（被创建并执行过的线程总数）="+threadMXBean.getTotalStartedThreadCount());
        System.out.println("当初仍活动的守护线程（daemonThread）总数="+threadMXBean.getDaemonThreadCount());

        //检查是否有死锁的线程存在
        long[] deadlockedIds =  threadMXBean.findDeadlockedThreads();

        if(deadlockedIds != null && deadlockedIds.length > 0){
            ThreadInfo[] deadlockInfos = threadMXBean.getThreadInfo(deadlockedIds);
            System.out.println("死锁线程信息:");
            System.out.println("\t\t线程名称\t\t状态\t\t");
            for(ThreadInfo deadlockInfo : deadlockInfos){
                System.out.println("\t\t"+deadlockInfo.getThreadName()+"\t\t"+deadlockInfo.getThreadState()
                        +"\t\t"+deadlockInfo.getBlockedTime()+"\t\t"+deadlockInfo.getWaitedTime()
                        +"\t\t"+deadlockInfo.getStackTrace().toString());
            }
        }

        long[] threadIds = threadMXBean.getAllThreadIds();
        if(threadIds != null && threadIds.length > 0){
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
            System.out.println("所有线程信息:");
            System.out.println("\t\t线程名称\t\t\t\t\t状态\t\t\t\t\t线程id");
            for(ThreadInfo threadInfo : threadInfos){
                System.out.println("\t\t"+threadInfo.getThreadName()+"\t\t\t\t\t"+threadInfo.getThreadState()
                        +"\t\t\t\t\t"+threadInfo.getThreadId());
            }
        }

    }


//    public static void main(String[] args) throws IOException {
//        printOperatingSystemInfo();
////        printClassLoadingInfo();
////        printCompilationInfo();
////        printRuntimeInfo();
////        printMemoryInfo();
////        printThreadInfo();
//    }





}
