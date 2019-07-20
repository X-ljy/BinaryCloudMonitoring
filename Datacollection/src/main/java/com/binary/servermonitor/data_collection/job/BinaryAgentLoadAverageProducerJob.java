package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentDiskIoInfoProducer;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentLoadAverageProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/6/29
 */
public class BinaryAgentLoadAverageProducerJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentLoadAverageProducerJob.class);

    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentLoadAverageProducerJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentLoadAverageProducer.runBinaryAgentLoadAverageProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentLoadAverageProducerJob" + e.getMessage());
        }
    }
}
