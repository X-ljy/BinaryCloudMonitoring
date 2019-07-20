package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.data_api.bottle.ServerInfo;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentCpuUseInfoProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/6/29
 */
public class BinaryAgentCpuUseInfoProducerJob implements Job {

    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentCpuUseInfoProducerJob.class);

    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentCpuUseInfoProducerJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentCpuUseInfoProducer.runBinaryAgentCpuUseInfoProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentCpuUseInfoProducerJob" + e.getMessage());
        }
    }
}
