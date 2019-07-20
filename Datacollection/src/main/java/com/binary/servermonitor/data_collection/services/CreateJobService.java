package com.binary.servermonitor.data_collection.services;

import com.binary.servermonitor.data_collection.common.JobList;
import com.binary.servermonitor.data_collection.common.TopicList;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.job.*;
import com.binary.servermonitor.data_collection.job.mysql.*;
import com.binary.servermonitor.data_collection.util.MySchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author 夕
 * @date 2019/5/8
 */

@Service
public class CreateJobService {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    public Boolean getCreateStatus(UserInfoBean userInfoBean) {

        WriteIopsDataJob.setUserInfoBean(userInfoBean);
        WriteIoDataJob.setUserInfoBean(userInfoBean);
        ReadIopsDataJob.setUserInfoBean(userInfoBean);
        ReadIoDataJob.setUserInfoBean(userInfoBean);
        PublicIpOutFlowDataJob.setUserInfoBean(userInfoBean);
        PublicIpInFlowDataJob.setUserInfoBean(userInfoBean);

        BinaryAgentNetworkCardInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentOnlineUsersProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentCpuUseInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentDiskBaseInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentDiskIoInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentMemBaseInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentProcInfoProducerJob.setUserInfoBean(userInfoBean);
        BinaryAgentLoadAverageProducerJob.setUserInfoBean(userInfoBean);

        BinaryAgentMysqlTableCacheJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlQueryCacheJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlThreadCacheJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlprocesslistJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlTPSJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlQpsjob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlKeyBufferJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlInnodbBufferJob.setUserInfoBean(userInfoBean);
        BinaryAgentMysqlConnectionNumberJob.setUserInfoBean(userInfoBean);

        for (int i = 0; i < JobList.joblist.size(); i++) {
            //设置定时任务信息
            String jobName = JobList.joblist.get(i) + "@" + userInfoBean.getUsername() + userInfoBean.getRegion();
            String jobGroupName = JobList.joblist.get(i) + "@" + userInfoBean.getUsername() + userInfoBean.getRegion();
            String triggerName = JobList.joblist.get(i) + "@" + userInfoBean.getUsername() + userInfoBean.getRegion();
            String triggerGroupName = JobList.joblist.get(i) + "@" + userInfoBean.getUsername() + userInfoBean.getRegion();
            try {
                Boolean res = MySchedulerFactory.addJob(jobName, jobGroupName,
                        triggerName, triggerGroupName,
                        JobList.joblist.get(i), "5 0,5,10,15,20,25,30,35,40,45,50,55 * * * ? *");
                if (res) {
                    logger.info(JobList.joblist.get(i) + "------------------create success---------------");
                    continue;
                } else {
                    return false;
                }
            } catch (Exception e) {
                logger.error("create error" + JobList.joblist.get(i) + e.getMessage());
                return false;
            }
        }
        return true;

    }

}
