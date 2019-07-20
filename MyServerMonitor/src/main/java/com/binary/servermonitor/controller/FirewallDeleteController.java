package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.FirewallDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class FirewallDeleteController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/firewall/delete")
    public String firewallDelete(HttpSession session,@RequestParam String id){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        FirewallDeleteService service = new FirewallDeleteService();
        String json = service.firewallDelete(userInfo,id);
        return json;
    }
}
