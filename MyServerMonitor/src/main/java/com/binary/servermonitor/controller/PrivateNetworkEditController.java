package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PrivateNetworkEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class PrivateNetworkEditController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/private/network/edit")
    public String privateNetworkEdit(HttpSession session, @RequestParam String id, @RequestParam String name, @RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PrivateNetworkEditService service = new PrivateNetworkEditService();
        String json = service.privateNetworkEdit(userInfo,id,name,description);
        return json;
    }
}
