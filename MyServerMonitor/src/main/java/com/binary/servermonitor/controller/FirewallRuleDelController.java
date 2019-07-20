package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FirewallRuleDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class FirewallRuleDelController {
    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping(value = "/firewall/rule/delete")
    public String ruleDel(HttpSession session,@RequestParam String id){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FirewallRuleDeleteService service = new FirewallRuleDeleteService();
        String json = service.ruleDelete(userInfo,id);
        return json;
    }

}
