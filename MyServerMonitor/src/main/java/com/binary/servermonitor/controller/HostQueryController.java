package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.HostInfo;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Wei Peng
 */

@RestController
public class HostQueryController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/query")
    public HostInfo[] query(HttpSession session){
        HostQueryService hostQueryService = new HostQueryService();
        HostInfo[] host;
        String username = String.valueOf(session.getAttribute("username"));
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        host = hostQueryService.hostquery(userInfo);
        return host;
    }
}
