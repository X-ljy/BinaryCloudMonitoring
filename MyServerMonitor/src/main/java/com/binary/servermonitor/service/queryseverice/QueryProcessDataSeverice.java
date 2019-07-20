package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.ProcessDataBean;
import com.binary.servermonitor.util.DateTool;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/5/19
 */

@Service
public class QueryProcessDataSeverice {

    @Autowired
    ProcessDataBean processDataBean;

    public String getProcessData(String id){
        String res = null;
        processDataBean.setQueryUrl(SearchUrlList.processDataUrl);
        processDataBean.setStartTime(DateTool.getStartTime());
        processDataBean.setEndTime(DateTool.getEndTime());
        processDataBean.setSize(1000);
        processDataBean.setId(id);
        try {
            res =  EsUtils.queryDataFromES(processDataBean.getQueryUrl(),processDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneProcessData(String id , String pid){
        String res = null;

        processDataBean.setQueryUrl(SearchUrlList.processDataUrl);
        processDataBean.setId(id);
        processDataBean.setPid(pid);
        processDataBean.setSize(5000);
        processDataBean.setStartTime(DateTool.getOneDayStartTime());
        processDataBean.setEndTime(DateTool.getNowTime());

        System.out.println(processDataBean.toOneProcJsonString());
        try {
            res =  EsUtils.queryDataFromES(processDataBean.getQueryUrl(),processDataBean.toOneProcJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }

}
