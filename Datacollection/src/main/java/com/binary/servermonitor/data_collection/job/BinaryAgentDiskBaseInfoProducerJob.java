package com.binary.servermonitor.data_collection.job;

import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentDiskBaseInfoProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;



/**
 * @author 夕
 * @date 2019/6/29
 */
public class BinaryAgentDiskBaseInfoProducerJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentDiskBaseInfoProducerJob.class);

    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentDiskBaseInfoProducerJob.userInfoBean = userInfoBean;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentDiskBaseInfoProducer.runBinaryAgentDiskBaseInfoProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentDiskBaseInfoProducerJob" + e.getMessage());
        }
    }

}
