package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.CpuDataBean;
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
public class QueryCpuDataSevercice {
    @Autowired
    CpuDataBean cpuDataBean;

    public String getOneHourCpuData(String id){
        String res = null;

        cpuDataBean.setId(id);
        cpuDataBean.setStartTime(DateTool.getOneHourStartTime());
        cpuDataBean.setEndTime(DateTool.getNowTime());
        cpuDataBean.setQueryUrl(SearchUrlList.cpuDataUrl);
        cpuDataBean.setSize(50);
        try {
            res =  EsUtils.queryDataFromES(cpuDataBean.getQueryUrl(),cpuDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getOneDayCpuData(String id){
        String res = null;

        cpuDataBean.setId(id);
        cpuDataBean.setStartTime(DateTool.getOneDayStartTime());
        cpuDataBean.setEndTime(DateTool.getNowTime());
        cpuDataBean.setQueryUrl(SearchUrlList.cpuDataUrl);
        cpuDataBean.setSize(1000);
        try {
            res =  EsUtils.queryDataFromES(cpuDataBean.getQueryUrl(),cpuDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
