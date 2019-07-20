package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.RuleCycle;
import com.binary.servermonitor.repository.RulesCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei Peng
 */
@RestController
public class WarnRuleRestartController {

    @Autowired
    RulesCycleRepository rulesCycleRepository;

    @PostMapping(value = "/warn/rule/restart")
    public String ruleRestart(@RequestParam Integer id){
        try {
            RuleCycle ruleCycle = rulesCycleRepository.findByRulesId(id);
            ruleCycle.setNoticeTime(0);
            ruleCycle.setHits(0);
            rulesCycleRepository.save(ruleCycle);
            return "规则重置成功";
        }
        catch (Exception e){
            return "规则重置失败";
        }
    }
}
