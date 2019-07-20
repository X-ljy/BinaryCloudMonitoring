package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostSnapEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class HostSnapEditController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/snap/edit")
    public String snapEdit(HttpSession session, @RequestParam String snapId,@RequestParam String name,@RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostSnapEditService service = new HostSnapEditService();
        String json = service.snapEdit(userInfo,snapId,name,description);
        return json;
    }
}
