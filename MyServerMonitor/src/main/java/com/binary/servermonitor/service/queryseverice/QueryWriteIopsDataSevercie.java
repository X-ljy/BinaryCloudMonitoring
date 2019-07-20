package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.WriteIopsDataBean;
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
public class QueryWriteIopsDataSevercie {
    @Autowired
    WriteIopsDataBean writeIopsDataBean;


    public String getOneHourWriteIopsData(String id){
        String res = null;

        writeIopsDataBean.setId(id);
        writeIopsDataBean.setStartTime(DateTool.getOneHourStartTime());
        writeIopsDataBean.setEndTime(DateTool.getNowTime());
        writeIopsDataBean.setQueryUrl(SearchUrlList.writeiopsDataUrl);
        writeIopsDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(writeIopsDataBean.getQueryUrl(),writeIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayWriteIopsData(String id){
        String res = null;

        writeIopsDataBean.setId(id);
        writeIopsDataBean.setStartTime(DateTool.getOneDayStartTime());
        writeIopsDataBean.setEndTime(DateTool.getNowTime());
        writeIopsDataBean.setQueryUrl(SearchUrlList.writeiopsDataUrl);
        writeIopsDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(writeIopsDataBean.getQueryUrl(),writeIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekWriteIopsData(String id){
        String res = null;

        writeIopsDataBean.setId(id);
        writeIopsDataBean.setStartTime(DateTool.getOneWeekStartTime());
        writeIopsDataBean.setEndTime(DateTool.getNowTime());
        writeIopsDataBean.setQueryUrl(SearchUrlList.writeiopsDataUrl);
        writeIopsDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(writeIopsDataBean.getQueryUrl(),writeIopsDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    

}
