package com.binary.servermonitor.clusterinfo;

import com.alibaba.fastjson.JSON;
import com.binary.servermonitor.configuration.SSHEsConfigBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 夕
 * @date 2019/5/17
 */

@Service
public class EsInfo {

    @Autowired
    SSHEsConfigBean sshEsConfigBean;

    public String getEsInfo() {

        List<String> ipList = sshEsConfigBean.getIp();
        Iterator<String> iterable =  ipList.iterator();
        JSONObject resJson = new JSONObject();
        while (iterable.hasNext()) {

            EsUtils.setHostIp(iterable.next());
            try {
                String isHealth   = EsUtils.getEsHealth();
                String indexlist   = EsUtils.getEsIndexList();
                String esVersion  = EsUtils.getEsVersion();
                com.alibaba.fastjson.JSONObject esVersionJson = JSON.parseObject(esVersion);
                com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) esVersionJson.get("version");

                resJson.put("esversion",json.getString("number"));

                JSONArray jsonArray = new JSONArray();
                String[] indexInfo = indexlist.split("\n");
                for (int i = 1;i<indexInfo.length;i++){
                    JSONObject jsonObject = new JSONObject();
                    String[] temp = indexInfo[i].split(" ");
                    List<String> str = new ArrayList<>();
                    for (String strs : temp) {
                        if (!strs.equals("")){
                            str.add(strs);
                        }
                    }
                    jsonObject.put("health", str.get(0));
                    jsonObject.put("status", str.get(1));
                    jsonObject.put("docscount", str.get(6));
                    jsonObject.put("shardnum", str.get(4));
                    jsonObject.put("indexname",str.get(2));
                    jsonArray.put(jsonObject);

                }
                resJson.put("indexinfo",jsonArray);


                String[] temp = isHealth.split("\n");
                String temp1 = temp[1];
                String[] temp2 = temp1.split(" ");
                String clusterName=  temp2[3];
                String status = temp2[4];
                String  nodetotal = temp2[15];
                String shardsHealth = temp2[temp2.length-1];

                resJson.put("clusterName",clusterName);
                resJson.put("status",status);
                resJson.put("nodetotal",nodetotal);
                resJson.put("shardsHeaith",shardsHealth);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resJson.toString();
    }


}
