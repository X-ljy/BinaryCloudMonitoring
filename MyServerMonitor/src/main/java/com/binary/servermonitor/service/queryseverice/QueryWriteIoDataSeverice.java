package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.WriteIoDataBean;
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
public class QueryWriteIoDataSeverice {
    @Autowired
    WriteIoDataBean writeIoDataBean;


    public String getOneHourWriteIoData(String id){
        String res = null;

        writeIoDataBean.setId(id);
        writeIoDataBean.setStartTime(DateTool.getOneHourStartTime());
        writeIoDataBean.setEndTime(DateTool.getNowTime());
        writeIoDataBean.setQueryUrl(SearchUrlList.writeioDataUrl);
        writeIoDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(writeIoDataBean.getQueryUrl(),writeIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayWriteIoData(String id){
        String res = null;

        writeIoDataBean.setId(id);
        writeIoDataBean.setStartTime(DateTool.getOneDayStartTime());
        writeIoDataBean.setEndTime(DateTool.getNowTime());
        writeIoDataBean.setQueryUrl(SearchUrlList.writeioDataUrl);
        writeIoDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(writeIoDataBean.getQueryUrl(),writeIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneWeekWriteIoData(String id){
        String res = null;

        writeIoDataBean.setId(id);
        writeIoDataBean.setStartTime(DateTool.getOneWeekStartTime());
        writeIoDataBean.setEndTime(DateTool.getNowTime());
        writeIoDataBean.setQueryUrl(SearchUrlList.writeioDataUrl);
        writeIoDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(writeIoDataBean.getQueryUrl(),writeIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
