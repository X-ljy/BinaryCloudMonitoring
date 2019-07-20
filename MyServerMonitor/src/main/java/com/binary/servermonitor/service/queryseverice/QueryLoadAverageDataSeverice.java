package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.RuntimeAndAverageDataBean;
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
public class QueryLoadAverageDataSeverice {

    @Autowired
    RuntimeAndAverageDataBean runtimeAndAverageDataBean;


    public String getOneHourAverageData(String id){
        String res = null;

        runtimeAndAverageDataBean.setId(id);
        runtimeAndAverageDataBean.setStartTime(DateTool.getOneHourStartTime());
        runtimeAndAverageDataBean.setEndTime(DateTool.getNowTime());
        runtimeAndAverageDataBean.setQueryUrl(SearchUrlList.runtimeAndAverageDataUrl);
        runtimeAndAverageDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(runtimeAndAverageDataBean.getQueryUrl(),runtimeAndAverageDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayAverageData(String id){
        String res = null;

        runtimeAndAverageDataBean.setId(id);
        runtimeAndAverageDataBean.setStartTime(DateTool.getOneDayStartTime());
        runtimeAndAverageDataBean.setEndTime(DateTool.getNowTime());
        runtimeAndAverageDataBean.setQueryUrl(SearchUrlList.runtimeAndAverageDataUrl);
        runtimeAndAverageDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(runtimeAndAverageDataBean.getQueryUrl(),runtimeAndAverageDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekAverageData(String id){
        String res = null;

        runtimeAndAverageDataBean.setId(id);
        runtimeAndAverageDataBean.setStartTime(DateTool.getOneWeekStartTime());
        runtimeAndAverageDataBean.setEndTime(DateTool.getNowTime());
        runtimeAndAverageDataBean.setQueryUrl(SearchUrlList.runtimeAndAverageDataUrl);
        runtimeAndAverageDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(runtimeAndAverageDataBean.getQueryUrl(),runtimeAndAverageDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
