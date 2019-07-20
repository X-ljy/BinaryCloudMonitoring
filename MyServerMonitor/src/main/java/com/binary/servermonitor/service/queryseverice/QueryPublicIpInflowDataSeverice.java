package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.data_api.network.PublicIpinflow;
import com.binary.servermonitor.entity.esbean.PublicIpInflowDataBean;
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
public class QueryPublicIpInflowDataSeverice {

    @Autowired
    PublicIpInflowDataBean publicIpInflowDataBean;

    public String getOneHourInflowData(String id){
        String res = null;

        publicIpInflowDataBean.setId(id);
        publicIpInflowDataBean.setStartTime(DateTool.getOneHourStartTime());
        publicIpInflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpInflowDataBean.setQueryUrl(SearchUrlList.publicipinflowDataUrl);
        publicIpInflowDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(publicIpInflowDataBean.getQueryUrl(),publicIpInflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayInflowData(String id){
        String res = null;

        publicIpInflowDataBean.setId(id);
        publicIpInflowDataBean.setStartTime(DateTool.getOneDayStartTime());
        publicIpInflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpInflowDataBean.setQueryUrl(SearchUrlList.publicipinflowDataUrl);
        publicIpInflowDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(publicIpInflowDataBean.getQueryUrl(),publicIpInflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekInflowData(String id){
        String res = null;

        publicIpInflowDataBean.setId(id);
        publicIpInflowDataBean.setStartTime(DateTool.getOneWeekStartTime());
        publicIpInflowDataBean.setEndTime(DateTool.getNowTime());
        publicIpInflowDataBean.setQueryUrl(SearchUrlList.publicipinflowDataUrl);
        publicIpInflowDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(publicIpInflowDataBean.getQueryUrl(),publicIpInflowDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }



}
