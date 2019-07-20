package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FirewallRuleCreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class FirewallRuleCreatController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping(value = "/firewall/rule/creat")
    public String ruleCreat(HttpSession session,String firewallId,String name,String direction,String portStart,String portEnd,
                            String portocol,String priority){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FirewallRuleCreatService service = new FirewallRuleCreatService();
        String json = service.ruleCreat(userInfo,firewallId,name,direction,portStart,portEnd,portocol,priority);
        return json;
    }
}
