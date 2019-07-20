package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostSnapRestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HostSnapRestoreController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/snap/restore")
    public String hostSnapRestore(HttpSession session,@RequestParam String snapId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostSnapRestoreService service = new HostSnapRestoreService();
        String json = service.restoreService(userInfo,snapId);
        return json;
    }
}
