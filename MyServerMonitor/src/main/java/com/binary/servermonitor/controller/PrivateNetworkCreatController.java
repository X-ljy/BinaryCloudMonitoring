package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.PrivateNetworkCreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class PrivateNetworkCreatController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @PostMapping(value = "/private/network/creat")
    public String privateNetworkCreat(HttpSession session, @RequestParam String cidrStart,@RequestParam String cidrValue,@RequestParam String cidrEnd,@RequestParam String dhcp,@RequestParam String name,@RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        PrivateNetworkCreatService service = new PrivateNetworkCreatService();
        String cidr = cidrStart + cidrValue + cidrEnd;
        String s = cidr.replaceAll("/", "%2F");
        System.out.println(s);
        String json = service.pprivateNetworkCreat(userInfo,s,dhcp,name,description);
        return json;
    }
}
