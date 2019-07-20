package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.OperatingSystemInfoBean;
import com.binary.servermonitor.entity.jvmbean.RuntimeInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Service
public class RuntimeInfoSeverice {

    @Autowired
    RuntimeInfoBean runtimeInfoBean;

    public String getRuntimeInfo(String host,String startTime,String endTime,int size){

        String res = null;

        runtimeInfoBean.setHost(host);
        runtimeInfoBean.setStartTime(startTime);
        runtimeInfoBean.setEndTime(endTime);
        runtimeInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.jvmRuntimeInfoIndex,runtimeInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
