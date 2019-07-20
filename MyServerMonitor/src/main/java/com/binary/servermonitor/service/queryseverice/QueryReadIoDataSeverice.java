package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.data_api.disk.ReadIoApi;
import com.binary.servermonitor.entity.esbean.ReadIoDataBean;
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
public class QueryReadIoDataSeverice {

    @Autowired
    ReadIoDataBean readIoDataBean;

    public String getOneHourReadIoData(String id){
        String res = null;

        readIoDataBean.setId(id);
        readIoDataBean.setStartTime(DateTool.getOneHourStartTime());
        readIoDataBean.setEndTime(DateTool.getNowTime());
        readIoDataBean.setQueryUrl(SearchUrlList.readioDataUrl);
        readIoDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(readIoDataBean.getQueryUrl(),readIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayReadIoData(String id){
        String res = null;

        readIoDataBean.setId(id);
        readIoDataBean.setStartTime(DateTool.getOneDayStartTime());
        readIoDataBean.setEndTime(DateTool.getNowTime());
        readIoDataBean.setQueryUrl(SearchUrlList.readioDataUrl);
        readIoDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(readIoDataBean.getQueryUrl(),readIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    public String getOneWeekReadIoData(String id){
        String res = null;

        readIoDataBean.setId(id);
        readIoDataBean.setStartTime(DateTool.getOneWeekStartTime());
        readIoDataBean.setEndTime(DateTool.getNowTime());
        readIoDataBean.setQueryUrl(SearchUrlList.readioDataUrl);
        readIoDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(readIoDataBean.getQueryUrl(),readIoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
