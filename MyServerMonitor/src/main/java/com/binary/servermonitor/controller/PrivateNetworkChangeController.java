package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PrivateNetworkChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class PrivateNetworkChangeController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping(value = "/private/network/change")
    public String privateNetworkChange(HttpSession session, @RequestParam String hostId,@RequestParam String oldNetworkId,@RequestParam String newNetworkId,@RequestParam String networkIpAddress){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PrivateNetworkChangeService service = new PrivateNetworkChangeService();
        String json = service.privateNetworkChange(userInfo,hostId,oldNetworkId,newNetworkId,networkIpAddress);
        return json;
    }

}
