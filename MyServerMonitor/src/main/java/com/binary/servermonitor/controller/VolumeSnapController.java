package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.VolumeSnap;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class VolumeSnapController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/volume/snap/creat")
    public String ceratVolumeSnap(HttpSession session, @RequestParam String volumeId,@RequestParam String name,@RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        VolumeSnapService snapService = new VolumeSnapService();
        String json = snapService.volumeSnapService(userInfo,volumeId,name,description);
        return json;
    }

    @PostMapping(value = "/volume/snap/query")
    public ArrayList<VolumeSnap> queryVolumeSnap(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        VolumeSnapQueryService service = new VolumeSnapQueryService();
        ArrayList<VolumeSnap> list = new ArrayList<VolumeSnap>();
        list = service.queryService(userInfo);
        return list;
    }

    @PostMapping(value = "/volume/snap/delete")
    public String snapDelete(HttpSession session,String snapId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        VolumeSnapDeleteService service = new VolumeSnapDeleteService();
        String json = service.deleteService(userInfo,snapId);
        return json;
    }

    @PostMapping(value = "/volume/snap/edit")
    public String snapEdit(HttpSession session, @RequestParam String snapId,@RequestParam String name,@RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        VolumeSnapEditService service = new VolumeSnapEditService();
        String json = service.snapEdit(userInfo,snapId,name,description);
        return json;
    }

    @PostMapping(value = "/volume/snap/restore")
    public String hostSnapRestore(HttpSession session,@RequestParam String snapId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        VolumeSnapRestoreService service = new VolumeSnapRestoreService();
        String json = service.restoreService(userInfo,snapId);
        return json;
    }
}
