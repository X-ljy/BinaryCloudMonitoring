package com.binary.servermonitor.data_collection.job.mysql;

import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.mysql.BinaryAgentMysqlQpsProducer;
import com.binary.servermonitor.data_collection.kafkaproducer.mysql.BinaryAgentMysqlQueryCacheProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/7/2
 */
public class BinaryAgentMysqlQueryCacheJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentMysqlQueryCacheJob.class);
    private static UserInfoBean userInfoBean;
    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }
    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentMysqlQueryCacheJob.userInfoBean = userInfoBean;
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentMysqlQueryCacheProducer.runBinaryAgentMysqlQueryCacheProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentMysqlQueryCacheJob : " + e.getMessage());
        }
    }
}