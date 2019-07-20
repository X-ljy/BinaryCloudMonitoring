package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.RuleCycle;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.WarnEmail;
import com.binary.servermonitor.entity.WarnRule;
import com.binary.servermonitor.repository.RulesCycleRepository;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.repository.WarnEmailRepository;
import com.binary.servermonitor.repository.WarnRuleRepository;
import com.binary.servermonitor.service.WarnEmailService;
import com.binary.servermonitor.service.WarnRuleCreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class WarnRuleController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    WarnRuleRepository warnRuleRepository;
    @Autowired
    WarnEmailRepository warnEmailRepository;
    @Autowired
    RulesCycleRepository rulesCycleRepository;

    @PostMapping(value = "/warn/rules/creat")
    public String test(HttpSession session, @RequestBody String json){
        System.out.println(json);
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        WarnRuleCreatService ruleCreatService = new WarnRuleCreatService();
        WarnEmailService emailService = new WarnEmailService();
        WarnRule warnRule = ruleCreatService.warnRuleCreat(userInfo,json);
        WarnEmail warnEmail = emailService.warnEmail(userInfo,json);
        warnRuleRepository.save(warnRule);
        WarnRule rule = warnRuleRepository.findByRuleNameAndUsername(warnRule.getRuleName(),warnRule.getUsername());
        warnEmail.setRuleId(rule.getId());
        warnEmailRepository.save(warnEmail);
        RuleCycle cycle = new RuleCycle();
        cycle.setHits(0);
        cycle.setRulesId(rule.getId());
        cycle.setNoticeTime(0);
        rulesCycleRepository.save(cycle);
        return "创建成功";
    }
}
