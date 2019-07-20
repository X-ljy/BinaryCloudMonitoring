package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PrivateNetworkDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class PrivateNetworkDeleteController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/private/network/delete")
    public String privateNetworkDelete(HttpSession session,@RequestParam String id){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PrivateNetworkDeleteService service = new PrivateNetworkDeleteService();
        String json = service.privateNetworkDelete(userInfo,id);
        return json;
    }
}
