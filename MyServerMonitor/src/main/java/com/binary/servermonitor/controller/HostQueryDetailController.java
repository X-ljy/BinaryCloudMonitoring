package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.HostInfoDetail;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.HostQueryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class HostQueryDetailController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/query/detail")
    public HostInfoDetail queryDetail(HttpSession session, @RequestParam String hostid){
        String username = String.valueOf(session.getAttribute("username"));
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        HostQueryDetailService service = new HostQueryDetailService();
        HostInfoDetail hostInfoDetail;
        hostInfoDetail = service.queryDetail(userInfo,hostid);

        return hostInfoDetail;
    }
}
