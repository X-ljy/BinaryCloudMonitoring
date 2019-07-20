package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.PublicIp;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PublicIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 * 公网信息
 */
@RestController
public class PublicIpController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/publicIp/query")
    public ArrayList<PublicIp> publicIpQuery(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PublicIpService service = new PublicIpService();
        return service.pubIpQuery(userInfo);
    }
}
