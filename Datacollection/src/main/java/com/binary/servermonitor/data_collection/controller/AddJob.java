package com.binary.servermonitor.data_collection.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.data_collection.entity.UserBean;
import com.binary.servermonitor.data_collection.entity.UserInfoBean;
import com.binary.servermonitor.data_collection.services.CreateJobService;
import com.binary.servermonitor.data_collection.services.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夕
 * @date 2019/5/2
 */

@RestController
public class AddJob {

    @Autowired
    UserInfoService userInfoService;

    //用户创建人物时需要的信息
    @Autowired
    UserInfoBean userInfoBean;

    @Autowired
    CreateJobService createJobService;

    //任务是否成功创建的状态
    private  boolean status = false;

    @PostMapping("/addjob")
    public boolean addjob(String username){

        UserBean userBean = userInfoService.getUserInfo(username);

        System.out.println(userBean.toString());

        String region = userBean.getRegion();
        JSONObject json = JSONObject.parseObject(region);

        //解析用户在各个仓库中的主机id
        for(String obj : json.keySet()){

            JSONArray hostIDList = JSONObject.parseArray(json.getString(obj));
            userInfoBean.setUsername(userBean.getUsername());
            userInfoBean.setAccess_key_id(userBean.getAccess_key_id());
            userInfoBean.setAccess_key_secret(userBean.getAccess_key_secret());
            userInfoBean.setRegion(obj.toString());
            userInfoBean.setHostID(String.valueOf(hostIDList));

            //设置定时任务
            status = createJobService.getCreateStatus(userInfoBean);

            if(status){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

}
