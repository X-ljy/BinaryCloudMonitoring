package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.WriteIoData;
import com.binary.servermonitor.data_collection.kafkaproducer.WriteIopsData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author 夕
 * @date 2019/5/8
 */
public class WriteIopsDataJob implements Job {

    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        WriteIopsDataJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            WriteIopsData.getWriteIopsData(getUserInfoBean());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
