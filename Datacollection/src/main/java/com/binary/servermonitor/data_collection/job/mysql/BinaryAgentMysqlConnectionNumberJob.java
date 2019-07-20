package com.binary.servermonitor.data_collection.job.mysql;

import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.job.BinaryAgentCpuUseInfoProducerJob;
import com.binary.servermonitor.data_collection.kafkaproducer.BinaryAgentCpuUseInfoProducer;
import com.binary.servermonitor.data_collection.kafkaproducer.mysql.BinaryAgentMysqlConnectionNumberProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/7/2
 */
public class BinaryAgentMysqlConnectionNumberJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentMysqlConnectionNumberJob.class);
    private static UserInfoBean userInfoBean;
    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }
    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentMysqlConnectionNumberJob.userInfoBean = userInfoBean;
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentMysqlConnectionNumberProducer.runBinaryAgentMysqlConnectionNumberProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentMysqlConnectionNumberJob : " + e.getMessage());
        }
    }
}
