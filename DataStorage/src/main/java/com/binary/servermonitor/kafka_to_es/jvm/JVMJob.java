package com.binary.servermonitor.kafka_to_es.jvm;

import com.binary.servermonitor.kafka_to_es.util.MySchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Component
@Order(value = 2)
public class JVMJob  implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("------------------------jvm job -----------------------");
        MySchedulerFactory.addJob("ClassLoadingInfoJob","ClassLoadingInfoGroup",
                "ClassLoadingInfoTrigger","ClassLoadingInfoTriggerGroup",
                ClassLoadingInfo.class,"0 0/2 * * * ? ");
        MySchedulerFactory.addJob("CompilationInfoJob","CompilationInfoGroup",
                "CompilationInfoTrigger","CompilationInfoTriggerGroup",
                CompilationInfo.class,"0 0/2 * * * ? ");
        MySchedulerFactory.addJob("MemoryInfoJob","MemoryInfoGroup",
                "MemoryInfoTrigger","MemoryInfoTriggerGroup",
                MemoryInfo.class,"0 0/2 * * * ? ");
        MySchedulerFactory.addJob("OperatingSystemInfoJob","OperatingSystemInfoGroup",
                "OperatingSystemInfoTrigger","OperatingSystemInfoTriggerGroup",
                OperatingSystemInfo.class,"0 0/3 * * * ? ");
        MySchedulerFactory.addJob("RuntimeInfoJob","RuntimeInfoGroup",
                "RuntimeInfoTrigger","RuntimeInfoTriggerGroup",
                RuntimeInfo.class,"0 0/2 * * * ? ");
        MySchedulerFactory.addJob("ThreadInfoJob","ThreadInfoGroup",
                "ThreadInfoTrigger","ThreadInfoTriggerGroup",
                ThreadInfo.class,"0 0/2 * * * ? ");

    }
}
