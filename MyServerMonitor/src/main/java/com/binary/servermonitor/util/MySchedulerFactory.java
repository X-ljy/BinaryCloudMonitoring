package com.binary.servermonitor.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 夕
 * @date 2019/5/22
 */
public class MySchedulerFactory {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    /**
     * 新增job任务
     *
     * @param jobName          job名称
     * @param jobGroupName     job分组名称
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器分组名称
     * @param jobClass         需要执行的job.class
     * @param cron             cron 表达式
     * @throws SchedulerException
     */
    public static Boolean addJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName,
                                 Class jobClass, String cron) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(cronScheduleBuilder).startNow().build();

            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 删除job
     *
     * @param triggerName  触发器名称
     * @param triggerGroup 触发器分组
     * @param jobName      任务名称
     * @param jobGroup     任务分组
     * @throws SchedulerException
     */
    public void deleteJob(String triggerName, String triggerGroup, String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            scheduler.deleteJob(jobKey);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 修改定时任务
     * @param oldTriggerKey 需要修改的TriggerKey 也就是唯一标识
     * @param cron          新的cron表达式
     */
    public void updateJob(TriggerKey oldTriggerKey, String cron) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(oldTriggerKey).withSchedule(scheduleBuilder).build();
            try {
                scheduler.rescheduleJob(oldTriggerKey, cronTrigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
