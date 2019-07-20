package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentNetworkCardInfoProducer;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentOnlineUsersProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/6/29
 */
public class BinaryAgentOnlineUsersProducerJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentOnlineUsersProducerJob.class);

    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentOnlineUsersProducerJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentOnlineUsersProducer.runBinaryAgentOnlineUsersProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentOnlineUsersProducerJob" + e.getMessage());
        }
    }
}
