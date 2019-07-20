package com.binary.servermonitor.controller;

import com.binary.servermonitor.repository.RulesCycleRepository;
import com.binary.servermonitor.repository.WarnEmailRepository;
import com.binary.servermonitor.repository.WarnRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei Peng
 */
@RestController
public class WarnRuleDelController {
    @Autowired
    WarnRuleRepository warnRuleRepository;
    @Autowired
    WarnEmailRepository warnEmailRepository;
    @Autowired
    RulesCycleRepository rulesCycleRepository;

    @PostMapping(value = "/warn/rule/delete")
    public String ruleDel(@RequestParam Integer id){
        try {
            rulesCycleRepository.deleteByRulesId(id);
            warnEmailRepository.deleteByRuleId(id);
            warnRuleRepository.deleteById(id);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }
}
