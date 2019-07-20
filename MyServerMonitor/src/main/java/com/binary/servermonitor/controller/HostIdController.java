package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class HostIdController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping(value = "/getHostId")
    public ArrayList<String> getHostId(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostIdService service = new HostIdService();
        ArrayList<String> list = service.hostid(userInfo);
        return list;
    }
}
