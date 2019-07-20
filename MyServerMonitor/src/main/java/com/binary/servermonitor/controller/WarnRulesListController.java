package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.RuleCycle;
import com.binary.servermonitor.entity.RulesInfo;
import com.binary.servermonitor.entity.WarnRule;
import com.binary.servermonitor.repository.RulesCycleRepository;
import com.binary.servermonitor.repository.WarnRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class WarnRulesListController {

    @Autowired
    WarnRuleRepository warnRuleRepository;

    @Autowired
    RulesCycleRepository rulesCycleRepository;

    @PostMapping(value = "/warn/rules/query")
    public ArrayList<RulesInfo> ruleList(HttpSession session){
        ArrayList<WarnRule> list = warnRuleRepository.findAllByUsername(String.valueOf(session.getAttribute("username")));
        ArrayList<RulesInfo> list1 = new ArrayList<RulesInfo>();
        for (int i =0;i < list.size();i ++){
            WarnRule warnRule;
            warnRule = list.get(i);
            RuleCycle ruleCycle;
            ruleCycle = rulesCycleRepository.findByRulesId(warnRule.getId());
            RulesInfo info = new RulesInfo();
            info.setId(warnRule.getId());
            info.setRuleName(warnRule.getRuleName());
            if ("no".equals(warnRule.getNoticeType())){
                info.setNoticeType("不通知");
            }
            else if ("email".equals(warnRule.getNoticeType())){
                info.setNoticeType("邮件通知");
            }
            else {
                info.setNoticeType(warnRule.getNoticeType());
            }
            if ("urgent".equals(warnRule.getLevel())){
                info.setLevel("紧急");
            }
            else if ("remind".equals(warnRule.getLevel())){
                info.setLevel("提醒");
            }
            else if("important".equals(warnRule.getLevel())){
                info.setLevel("重要");
            }
            else {
                info.setLevel(warnRule.getLevel());
            }
            Integer alarmzTimes = Integer.valueOf(warnRule.getAlarmTimes());
            if (alarmzTimes <= ruleCycle.getNoticeTime()){
                info.setState("失效");
            }
            else {
                info.setState("监测中");
            }
            info.setCycle(warnRule.getCycle());
            info.setCreatIime(warnRule.getCreatTime());
            list1.add(info);
        }
        return list1;
    }
}
