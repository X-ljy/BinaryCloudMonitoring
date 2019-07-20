package com.binary.servermonitor.data_collection.job;

import com.binary.servermonitor.data_collection.common.KafkaInfo;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.kafkaproducer.ReadIopsData;
import com.binary.servermonitor.data_collection.kafkaproducer.WriteIoData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author 夕
 * @date 2019/5/8
 */
public class WriteIoDataJob implements Job {
    private static UserInfoBean userInfoBean;

    public static UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public static void setUserInfoBean(UserInfoBean userInfoBean) {
        WriteIoDataJob.userInfoBean = userInfoBean;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            WriteIoData.getWriteIoData(getUserInfoBean());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
