package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.GetFireWallIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetFirewallIdController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/getFirewallId")
    public ArrayList<String> getFirewallId(HttpSession session){
        UserInfo userInfo =userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        GetFireWallIdService service = new GetFireWallIdService();
        ArrayList<String> list = service.getFirewallId(userInfo);
        return list;
    }
}
