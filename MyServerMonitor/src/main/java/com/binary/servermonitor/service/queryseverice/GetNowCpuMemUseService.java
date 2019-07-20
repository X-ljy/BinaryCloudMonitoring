package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author Wei Peng
 */
public class GetNowCpuMemUseService {

    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    public float getNowCpuInfo(InfoBean cpuUseInfoBean){
        String res = getData(cpuUseInfoBean);

        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        JSONObject jsonObject2 = array.getJSONObject(0);
        JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
        float use = 100 - Float.parseFloat(jsonObject3.getString("id"));
        return use;
    }

    public float getNowMemInfo(InfoBean memInfoBean){
        String res = getData(memInfoBean);

        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        JSONObject jsonObject2 = array.getJSONObject(0);
        JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
        float memUse = (Float.parseFloat(jsonObject3.getString("memTotal")) - Float.parseFloat(jsonObject3.getString("memFree")))/Float.parseFloat(jsonObject3.getString("memTotal"));
        float data = memUse*100;
        DecimalFormat df = new DecimalFormat(".00");
        return Float.parseFloat(df.format(data));
    }
}
