package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.CompilationInfoBean;
import com.binary.servermonitor.entity.jvmbean.MemoryInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Service
public class MemoryInfoSeverice {
    @Autowired
    MemoryInfoBean memoryInfoBean;

    public String getMemoryInfo(String host,String startTime,String endTime,int size){

        String res = null;

        memoryInfoBean.setHost(host);
        memoryInfoBean.setStartTime(startTime);
        memoryInfoBean.setEndTime(endTime);
        memoryInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.jvmMemoryInfoIndex,memoryInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
