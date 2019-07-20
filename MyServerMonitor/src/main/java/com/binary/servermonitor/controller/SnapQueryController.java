package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.HostSnap;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostSnapQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class SnapQueryController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/snap/query")
    public ArrayList<HostSnap> hostSnapQuery(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostSnapQueryService service = new HostSnapQueryService();
        ArrayList<HostSnap> list;
        list = service.hostSnapQueryService(userInfo);
        return list;
    }
}
