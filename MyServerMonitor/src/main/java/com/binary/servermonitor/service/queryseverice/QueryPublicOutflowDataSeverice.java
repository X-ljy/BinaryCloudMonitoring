package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.PublicIpOutflowDataBean;
import com.binary.servermonitor.util.DateTool;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/5/21
 */

@Service
public class QueryPublicOutflowDataSeverice {
    
    @Autowired
    PublicIpOutflowDataBean publicIpOutflowDataBean;

    public String getOneHourInflowData(String id){
        String res = null;

        publicIpOutflowDataBean.setId(id);
        publicIpOutflowDataBean.setStartTime(DateTool.getOneHourStartTime());
        publicIpOutflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpOutflowDataBean.setQueryUrl(SearchUrlList.publicipoutflowDataUrl);
        publicIpOutflowDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(publicIpOutflowDataBean.getQueryUrl(),publicIpOutflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayInflowData(String id){
        String res = null;

        publicIpOutflowDataBean.setId(id);
        publicIpOutflowDataBean.setStartTime(DateTool.getOneDayStartTime());
        publicIpOutflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpOutflowDataBean.setQueryUrl(SearchUrlList.publicipoutflowDataUrl);
        publicIpOutflowDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(publicIpOutflowDataBean.getQueryUrl(),publicIpOutflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekInflowData(String id){
        String res = null;

        publicIpOutflowDataBean.setId(id);
        publicIpOutflowDataBean.setStartTime(DateTool.getOneWeekStartTime());
        publicIpOutflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpOutflowDataBean.setQueryUrl(SearchUrlList.publicipoutflowDataUrl);
        publicIpOutflowDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(publicIpOutflowDataBean.getQueryUrl(),publicIpOutflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
