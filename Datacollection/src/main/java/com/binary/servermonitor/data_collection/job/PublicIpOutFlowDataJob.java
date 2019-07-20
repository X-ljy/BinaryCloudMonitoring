package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.PublicIpOutFlowData;
import com.binary.servermonitor.data_collection.kafkaproducer.ReadIoData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author 夕
 * @date 2019/5/8
 */
public class PublicIpOutFlowDataJob implements Job {
    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        PublicIpOutFlowDataJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            PublicIpOutFlowData.getPublicIpOutFlowData(getUserInfoBean());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
