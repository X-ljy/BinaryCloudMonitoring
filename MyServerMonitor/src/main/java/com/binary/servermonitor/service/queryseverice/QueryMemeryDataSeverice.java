package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.MemeryDataBean;
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
public class QueryMemeryDataSeverice {

    @Autowired
    MemeryDataBean memeryDataBean;

    public String getMemData(String id){
        String res = null;
        memeryDataBean.setId(id);
        memeryDataBean.setQueryUrl(SearchUrlList.memoryDataUrl);
        memeryDataBean.setStartTime(DateTool.getStartTime());
        memeryDataBean.setEndTime(DateTool.getEndTime());
        memeryDataBean.setSize(10);

        try {
            res =  EsUtils.queryDataFromES(memeryDataBean.getQueryUrl(),memeryDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }

}
