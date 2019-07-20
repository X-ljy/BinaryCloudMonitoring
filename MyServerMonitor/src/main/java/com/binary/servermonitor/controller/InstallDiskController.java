package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.InstallDiskService;
import com.binary.servermonitor.service.UninstallDiskService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class InstallDiskController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/volume/install")
    public String volumeUninstall(HttpSession session, @RequestParam String volumeId,@RequestParam String hostId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        InstallDiskService service = new InstallDiskService();
        String json = service.uninstallDisk(userInfo,volumeId,hostId);
        JSONObject jsonObject = new JSONObject(json);
        if ("Success".equals(jsonObject.getString("Code"))){
            return "挂载成功";
        }
        else if ("error".equals(jsonObject.getString("Code"))){
            return jsonObject.getString("ErrorMsg");
        }
        else {
            return "error";
        }
    }
}
