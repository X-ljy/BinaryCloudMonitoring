package com.binary.servermonitor.rulemonitor.service;

import com.binary.servermonitor.entity.*;
import com.binary.servermonitor.rulemonitor.monitorservice.GetUtilService;
import com.binary.servermonitor.rulemonitor.util.SendMailUtil;
import com.binary.servermonitor.rulemonitor.util.SendQQMailUtil;
import com.binary.servermonitor.util.DateTool;
import com.binary.servermonitor.util.RepositoryUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TwentyMinuteMonitorService implements Job {

    private ArrayList<Strategy> list = new ArrayList<>();

    private void getStrategy(String json){
        ArrayList<Strategy> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray array = jsonObject.getJSONArray("strategySet");
        for (int i = 0;i <array.length(); i++){
            JSONObject jsonObject1 = array.getJSONObject(i);
            Strategy strategy = new Strategy();
            strategy.setTypeName(jsonObject1.getString("typeName"));
            strategy.setTypeMethod(jsonObject1.getString("typeMethod"));
            strategy.setTypeValue(jsonObject1.getString("typeValue"));
            strategy.setOption(jsonObject1.getString("option"));
            list.add(strategy);
        }
        this.list = list;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TwentyMonitorStart");
        List<WarnRule> warnRules = RepositoryUtil.getTwWarnRuleList();
        GetUtilService service = new GetUtilService();
        for (int i =0;i <warnRules.size();i ++){
            WarnRule warnRule = warnRules.get(i);
            RuleCycle ruleCycle = RepositoryUtil.getRuleCycle(warnRule.getId());
            HostIp hostIp = RepositoryUtil.getHostIp(warnRule.getHostId());
            WarnEmail warnEmail = RepositoryUtil.getWarnEmailList(warnRule.getId());
            getStrategy(warnRule.getStrategy());
            String term = warnRule.getTerm();
            if ("and".equals(term)){
                Integer outNum = 0;
                StringBuilder reason = new StringBuilder();
                for (int j = 0;j <this.list.size();j ++){
                    Strategy strategy = this.list.get(j);
                    if ("cpuUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getCpuUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("CPU使用率超过阈值，");
                        }
                    }
                    else if ("memoryUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getMemUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("内存使用率超过阈值，");
                        }
                    }
                    else if ("diskUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getDiskUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("磁盘使用率超过阈值，");
                        }
                    }
                    else if ("readIoUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getReadIoUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("磁盘读取IO超过阈值，");
                        }
                    }
                    else if ("writeIoUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getWriteIoUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("磁盘读取IO超过阈值，");
                        }
                    }
                    else if ("readIopsUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getReadIopsUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("磁盘读取IOPS超过阈值，");
                        }
                    }
                    else if ("writeIopsUsed".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getWriteIopsUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("磁盘写入IOPS超过阈值，");
                        }
                    }
                    else if ("inflow".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getIpInflowUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("公网IP流入流量超过阈值，");
                        }
                    }
                    else if ("outflow".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getIpOutflowUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("公网IP流出流量超过阈值，");
                        }
                    }
                    else if ("averageLoad".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getAverageLoadUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("主机平均负载超过阈值，");
                        }
                    }
                    else if ("mysqlQps".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getMysqlQpsUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("MySql数据库QPS超过阈值，");
                        }
                    }
                    else if ("mysqlTps".equals(strategy.getOption())){
                        Integer temp = outNum;
                        ArrayList[] lists = service.getMysqlTpsUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = outNum + judge(strategy,lists);
                        if (outNum > temp){
                            reason.append("MySql数据库TPS超过阈值，");
                        }
                    }
                }
                if (outNum >= this.list.size()){
                    if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                        if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                            ruleCycle.setHits(0);
                            ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                            RepositoryUtil.saveRuleCycle(ruleCycle);
                            //告警
                            String title = "主机异常提醒";
                            StringBuilder messages = new StringBuilder();
                            messages.append("您的主机：");
                            messages.append(warnRule.getHostId());
                            messages.append("触发了您设置的规则：");
                            messages.append(warnRule.getRuleName());
                            messages.append(",");
                            messages.append(reason);
                            messages.append("请及时查看并处理。");
                            WarnRecord warnRecord = new WarnRecord();
                            warnRecord.setRuleName(warnRule.getRuleName());
                            warnRecord.setUsername(warnRule.getUsername());
                            warnRecord.setWarnReason(messages.toString());
                            warnRecord.setWarnTime(DateTool.getNowTime());
                            warnRecord.setRuleId(warnRule.getId());
                            RepositoryUtil.saveWarnRecord(warnRecord);
                            sentMail(warnEmail,title,messages.toString());

                        }
                    }
                    else {
                        ruleCycle.setHits(ruleCycle.getHits()+1);
                        RepositoryUtil.saveRuleCycle(ruleCycle);
                    }
                }
            }
            else if ("or".equals(term)){
                Integer outNum = 0;
                for (int j = 0;j <this.list.size();j ++){
                    Strategy strategy = this.list.get(j);
                    if ("cpuUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getCpuUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("CPU使用率超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("memoryUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getMemUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("内存使用率超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("diskUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getDiskUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("磁盘使用率超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("readIoUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getReadIoUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("磁盘读取IO超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("writeIoUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getWriteIoUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("磁盘写入IO超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("readIopsUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getReadIopsUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("磁盘读取IOPS超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("writeIopsUsed".equals(strategy.getOption())){
                        ArrayList[] lists = service.getWriteIopsUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("磁盘写入IOPS超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("inflow".equals(strategy.getOption())){
                        ArrayList[] lists = service.getIpInflowUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("公网IP流入速率超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("outflow".equals(strategy.getOption())){
                        ArrayList[] lists = service.getIpOutflowUtil(hostIp.getHostid(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("公网IP流出速率超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("averageLoad".equals(strategy.getOption())){
                        ArrayList[] lists = service.getAverageLoadUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("系统平均负载超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("mysqlQps".equals(strategy.getOption())){
                        ArrayList[] lists = service.getMysqlQpsUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("MySql数据库QPS超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                    else if ("mysqlTps".equals(strategy.getOption())){
                        ArrayList[] lists = service.getMysqlTpsUtil(hostIp.getHostip(),50,DateTool.getTwStartTime(),DateTool.getEndTime());
                        outNum = judge(strategy,lists);
                        if (outNum ==1){
                            if (ruleCycle.getHits() >= Integer.valueOf(warnRule.getHitCounts())){
                                if (ruleCycle.getNoticeTime()<=Integer.valueOf(warnRule.getAlarmTimes())){
                                    ruleCycle.setHits(0);
                                    ruleCycle.setNoticeTime(ruleCycle.getNoticeTime()+1);
                                    RepositoryUtil.saveRuleCycle(ruleCycle);
                                    outNum = 0;
                                    //告警
                                    String title = "主机异常提醒";
                                    StringBuilder messages = new StringBuilder();
                                    messages.append("您的主机：");
                                    messages.append(warnRule.getHostId());
                                    messages.append("触发了您设置的规则：");
                                    messages.append(warnRule.getRuleName());
                                    messages.append(",");
                                    messages.append("MySql数据库TPS超过阈值，");
                                    messages.append("请及时查看并处理。");
                                    WarnRecord warnRecord = new WarnRecord();
                                    warnRecord.setRuleName(warnRule.getRuleName());
                                    warnRecord.setUsername(warnRule.getUsername());
                                    warnRecord.setWarnReason(messages.toString());
                                    warnRecord.setWarnTime(DateTool.getNowTime());
                                    warnRecord.setRuleId(warnRule.getId());
                                    RepositoryUtil.saveWarnRecord(warnRecord);
                                    sentMail(warnEmail,title,messages.toString());
                                }
                            }
                            else {
                                ruleCycle.setHits(ruleCycle.getHits()+1);
                                RepositoryUtil.saveRuleCycle(ruleCycle);
                            }
                        }
                    }
                }
            }
        }
    }

    public Integer judge(Strategy strategy, ArrayList[] lists){
        ArrayList list = lists[0];
        ArrayList list1 = lists[1];

        if ("average".equals(strategy.getTypeName())){
            float sum = 0;
            for (int i = 0;i <list.size();i ++){
                float value = (float) list1.get(i);
                sum = sum + value;
            }
            float average = sum/list.size();
            if ("geq".equals(strategy.getTypeMethod())){
                if (average >= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if ("leq".equals(strategy.getTypeMethod())){
                if (average <= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if ("eq".equals(strategy.getTypeMethod())){
                if (average == Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }

        else if ("max".equals(strategy.getTypeName())) {
            float value = (float) list1.get(0);
            for (int i = 0; i < list1.size() - 1; i++) {
                if ((Float) list1.get(i + 1) > value) {
                    value = (Float) list1.get(i + 1);
                }
            }
            if ("geq".equals(strategy.getTypeMethod())) {
                if (value >= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
            else if ("leq".equals(strategy.getTypeMethod())) {
                if (value <= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
            else if ("eq".equals(strategy.getTypeMethod())) {
                if (value == Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
        }
        else if ("min".equals(strategy.getTypeName())) {
            float value = (float) list1.get(0);
            for (int i = 0; i < list1.size() - 1; i++) {
                if ((Float) list1.get(i + 1) < value) {
                    value = (Float) list1.get(i + 1);
                }
            }
            if ("geq".equals(strategy.getTypeMethod())) {
                if (value >= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
            else if ("leq".equals(strategy.getTypeMethod())) {
                if (value <= Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
            else if ("eq".equals(strategy.getTypeMethod())) {
                if (value == Float.valueOf(strategy.getTypeValue())){
                    //超过阈值
                    return 1;
                }
            }
        }
        return 0;
    }

    private void sentMail(WarnEmail warnEmail,String title,String messages){
        Integer temp1 = warnEmail.getEmail1().length();
        if (warnEmail.getEmail1() != null && temp1 != 0){
            String[] email = warnEmail.getEmail1().split("@");
            if ("binary.com".equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail1(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail1(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }

        }
        Integer temp2 = warnEmail.getEmail2().length();
        if (null != warnEmail.getEmail2() && temp2 != 0){
            String[] email = warnEmail.getEmail2().split("@");
            if ("binary.com".equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail2(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail2(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }

        }
        Integer leng = warnEmail.getEmail3().length();
        if (null != warnEmail.getEmail3() && leng != 0){
            System.out.println("Email" + warnEmail.getEmail3());
            System.out.println("length="+ warnEmail.getEmail3().length());
            String[] email = new String[2];
            email = warnEmail.getEmail3().split("@");
            String binary = "binary.com";
            if (binary.equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail3(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail3(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }

        }
        Integer temp4 = warnEmail.getEmail4().length();
        if (warnEmail.getEmail4() != null && temp4 != 0){
            String[] email = warnEmail.getEmail4().split("@");
            if ("binary.com".equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail4(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail4(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
        }
        Integer temp5 = warnEmail.getEmail5().length();
        if (null != warnEmail.getEmail5() && temp5 != 0){
            String[] email = warnEmail.getEmail5().split("@");
            System.out.println(email[1]);
            if ("binary.com".equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail5(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail5(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }

        }
        Integer temp6 = warnEmail.getEmail6().length();
        if (null != warnEmail.getEmail6() && temp6 != 0){
            String[] email = warnEmail.getEmail6().split("@");
            if ("binary.com".equals(email[1])){
                try {
                    try {
                        SendMailUtil.sendMail(warnEmail.getEmail6(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }
            else {
                try {
                    try {
                        SendQQMailUtil.sendMail(warnEmail.getEmail6(),title,messages);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("发送失败");
                    }
                } catch (MessagingException e) {
                    System.out.println("发送失败");
                }
            }

        }
        String[] email = warnEmail.getUsername().split("@");
        if ("binary.com".equals(email[1])){
            try {
                try {
                    SendMailUtil.sendMail(warnEmail.getUsername(),title,messages);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    System.out.println("发送失败");
                }
            } catch (MessagingException e) {
                System.out.println("发送失败");
            }
        }
        else {
            try {
                try {
                    SendQQMailUtil.sendMail(warnEmail.getUsername(),title,messages);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    System.out.println("发送失败");
                }
            } catch (MessagingException e) {
                System.out.println("发送失败");
            }
        }
    }


}
