package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.MemoryInfoBean;
import com.binary.servermonitor.entity.jvmbean.OperatingSystemInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Service
public class OperatingSystemInfoSeverice {

    @Autowired
    OperatingSystemInfoBean operatingSystemInfoBean;

    public String getOperatingSystemInfo(String host,String startTime,String endTime,int size){

        String res = null;

        operatingSystemInfoBean.setHost(host);
        operatingSystemInfoBean.setStartTime(startTime);
        operatingSystemInfoBean.setEndTime(endTime);
        operatingSystemInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.operatingSystemInfoIndex,operatingSystemInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
