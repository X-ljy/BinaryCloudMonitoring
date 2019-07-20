package com.binary.servermonitor.util;

import com.binary.servermonitor.entity.*;
import com.binary.servermonitor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei Peng
 */
@Component
public class RepositoryUtil {
    @Autowired
    private WarnRuleRepository ruleRepository;
    private static WarnRuleRepository warnRuleRepository;

    @Autowired
    private WarnEmailRepository emailRepository;
    private static WarnEmailRepository warnEmailRepository;

    @Autowired
    private RulesCycleRepository cycleRepository;
    private static RulesCycleRepository rulesCycleRepository;
    @Autowired
    private WarnRecordRepository recordRepository;
    private static  WarnRecordRepository warnRecordRepository;

    @Autowired
    private HostIpRepository ipRepository;
    private static HostIpRepository hostIpRepository;

    @PostConstruct
    public void init(){
        warnRuleRepository = ruleRepository;
        warnEmailRepository = emailRepository;
        rulesCycleRepository = cycleRepository;
        warnRecordRepository = recordRepository;
        hostIpRepository = ipRepository;
    }
    public static List<WarnRule> getOneWarnRuleList(){
        return warnRuleRepository.findAllByCycle("1");
    }
    public static List<WarnRule> getFiveWarnRuleList(){
        List<WarnRule> list = warnRuleRepository.findAllByCycle("5");
        return list;
    }
    public static List<WarnRule> getTwWarnRuleList(){
        List<WarnRule> list = warnRuleRepository.findAllByCycle("20");
        return list;
    }
    public static List<WarnRule> getOneHourWarnRuleList(){
        List<WarnRule> list = warnRuleRepository.findAllByCycle("60");
        return list;
    }

    public static WarnEmail getWarnEmailList(Integer id){
        WarnEmail email = warnEmailRepository.findByRuleId(id);
        return email;
    }
    public static RuleCycle getRuleCycle(Integer id){
        RuleCycle cycle = rulesCycleRepository.findByRulesId(id);
        return cycle;
    }
    public static HostIp getHostIp(String hostid){
        return hostIpRepository.findByHostid(hostid);
    }
    public static void saveRuleCycle(RuleCycle cycle){
        rulesCycleRepository.save(cycle);
    }
    public static void saveWarnRecord(WarnRecord warnRecord){
        warnRecordRepository.save(warnRecord);
    }

    public static void saveHostIp(HostIp hostIp){
        hostIpRepository.save(hostIp);
    }
}
