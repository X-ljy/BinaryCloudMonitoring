package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FirewallCreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class FirewallCreatController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/firewall/creat")
    public String firewallCreat(HttpSession session, @RequestParam String name, @RequestParam String description,@RequestParam String region){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FirewallCreatService service = new FirewallCreatService();
        String json = service.firewallCreat(userInfo,name,description,region);
        return json;
    }
}
