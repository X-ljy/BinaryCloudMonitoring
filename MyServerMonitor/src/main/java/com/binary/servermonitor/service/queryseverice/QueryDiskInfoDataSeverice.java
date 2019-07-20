package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.DiskInfoDataBean;
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
public class QueryDiskInfoDataSeverice {
    @Autowired
    DiskInfoDataBean diskInfoDataBean;

    public String getDiskInfoData(String id){
        String res = null;
        diskInfoDataBean.setId(id);
        diskInfoDataBean.setQueryUrl(SearchUrlList.diskinfoDataUrl);
        diskInfoDataBean.setStartTime(DateTool.getStartTime());
        diskInfoDataBean.setEndTime(DateTool.getEndTime());
        diskInfoDataBean.setSize(10);
        try {
            res =  EsUtils.queryDataFromES(diskInfoDataBean.getQueryUrl(),diskInfoDataBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
