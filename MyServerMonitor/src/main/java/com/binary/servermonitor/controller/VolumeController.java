package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.Volume;
import com.binary.servermonitor.repository.UserInfoRepository;
import com.binary.servermonitor.service.VolumeQueryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 * 磁盘管理页面数据
 */
@RestController
public class VolumeController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/volume/query")
    public ArrayList<Volume> volumeQuery(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        ArrayList<Volume> list;
        VolumeQueryService service = new VolumeQueryService();
        list = service.volumeQuery(userInfo);
        return list;
    }

    @PostMapping(value = "/volume/hostId")
    public ArrayList<String> volumeHostId(HttpSession session){
        ArrayList<String> list = new ArrayList<String>();
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i < region.length;i ++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j < array.length();j ++){
                list.add(array.getString(j));
            }
        }
        return list;
    }
}
