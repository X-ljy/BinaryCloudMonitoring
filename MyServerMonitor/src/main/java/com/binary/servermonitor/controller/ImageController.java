package com.binary.servermonitor.controller;

import com.binary.servermonitor.data_api.image.ImageDeleteApi;
import com.binary.servermonitor.entity.ImageInfo;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.*;
import org.apache.catalina.User;
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
public class ImageController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/image/query")
    public ImageInfo[] imageQuery(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        ImageQueryService imageQueryService = new ImageQueryService();
        ImageInfo[] imageInfos = imageQueryService.imageQueryService(userInfo);
        System.out.println("test");
        return imageInfos;
    }

    @PostMapping(value = "/image/creat/hostid")
    public ArrayList imageCreatByid(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        HostIdService service = new HostIdService();
        ArrayList list = service.hostid(userInfo);
        System.out.println(list);
        return list;
    }

    @PostMapping(value = "/image/creat")
    public String imageCreat(HttpSession session, @RequestParam String hostId,@RequestParam String description,@RequestParam String name,@RequestParam String volumeType){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        ImageCreatService service = new ImageCreatService();
        String json = service.imageCreat(userInfo,hostId,description,name,volumeType);
        return json;
    }

    @PostMapping(value = "/image/delete")
    public String imageDelete(HttpSession session,@RequestParam String imageId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        ImageDeleteService service = new ImageDeleteService();
        String json = service.imageDeleteService(userInfo,imageId);
        return json;
    }
    @PostMapping(value = "/image/edit")
    public String imageEdit(HttpSession session,@RequestParam String imageId,@RequestParam String name,@RequestParam String description){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        ImageEditService service = new ImageEditService();
        String json = service.imageEditService(userInfo,imageId,name,description);
        System.out.println(json);
        return json;
    }
}
