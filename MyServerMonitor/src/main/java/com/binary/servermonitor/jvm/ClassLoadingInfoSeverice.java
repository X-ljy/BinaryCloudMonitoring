package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.ClassLoadingInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */

@Service
public class ClassLoadingInfoSeverice {
    @Autowired
    ClassLoadingInfoBean classLoadingInfoBean;

    public String getClassLoadingInfo(String host,String startTime,String endTime,int size){

        String res = null;

        classLoadingInfoBean.setHost(host);
        classLoadingInfoBean.setStartTime(startTime);
        classLoadingInfoBean.setEndTime(endTime);
        classLoadingInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.classLoadingInfoIndex,classLoadingInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
