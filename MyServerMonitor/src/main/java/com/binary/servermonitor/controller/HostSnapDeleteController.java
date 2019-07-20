package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostSnapDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class HostSnapDeleteController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/snap/delete")
    public String snapDelete(HttpSession session,String snapId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostSnapDeleteService service = new HostSnapDeleteService();
        String json = service.deleteService(userInfo,snapId);
        return json;
    }
}
