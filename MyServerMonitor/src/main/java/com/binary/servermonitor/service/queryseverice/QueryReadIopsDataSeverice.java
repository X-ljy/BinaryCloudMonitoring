package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.ReadIopsDataBean;
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
public class QueryReadIopsDataSeverice {
    
    @Autowired
    ReadIopsDataBean readIopsDataBean;


    public String getOneHourReadIopsData(String id){
        String res = null;

        readIopsDataBean.setId(id);
        readIopsDataBean.setStartTime(DateTool.getOneHourStartTime());
        readIopsDataBean.setEndTime(DateTool.getNowTime());
        readIopsDataBean.setQueryUrl(SearchUrlList.readiopsDataUrl);
        readIopsDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(readIopsDataBean.getQueryUrl(),readIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayReadIopsData(String id){
        String res = null;

        readIopsDataBean.setId(id);
        readIopsDataBean.setStartTime(DateTool.getOneDayStartTime());
        readIopsDataBean.setEndTime(DateTool.getNowTime());
        readIopsDataBean.setQueryUrl(SearchUrlList.readiopsDataUrl);
        readIopsDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(readIopsDataBean.getQueryUrl(),readIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekReadIopsData(String id){
        String res = null;

        readIopsDataBean.setId(id);
        readIopsDataBean.setStartTime(DateTool.getOneWeekStartTime());
        readIopsDataBean.setEndTime(DateTool.getNowTime());
        readIopsDataBean.setQueryUrl(SearchUrlList.readiopsDataUrl);
        readIopsDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(readIopsDataBean.getQueryUrl(),readIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
