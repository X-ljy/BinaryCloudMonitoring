package com.binary.servermonitor.data_collection.job.mysql;

import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.mysql.BinaryAgentMysqlKeyBufferProducer;
import com.binary.servermonitor.data_collection.kafkaproducer.mysql.BinaryAgentMysqlprocesslistProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 * @author 夕
 * @date 2019/7/2
 */
public class BinaryAgentMysqlprocesslistJob implements Job {
    private static  org.slf4j.Logger logger = LoggerFactory.getLogger(BinaryAgentMysqlprocesslistJob.class);
    private static UserInfoBean userInfoBean;
    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }
    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        BinaryAgentMysqlprocesslistJob.userInfoBean = userInfoBean;
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            BinaryAgentMysqlprocesslistProducer.runBinaryAgentMysqlprocesslistProducer(getUserInfoBean());
        }catch (Exception e){
            logger.error("BinaryAgentMysqlprocesslistJob : " + e.getMessage());
        }
    }
}
