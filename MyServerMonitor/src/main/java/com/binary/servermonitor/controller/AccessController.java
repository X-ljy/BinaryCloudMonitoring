package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class AccessController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/getAccess")
    public UserInfo getaccess(HttpSession session){
        UserInfo userInfo = null;
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        userInfo = userInfoRepository.findByUsername(username);
        return userInfo;

    }
}