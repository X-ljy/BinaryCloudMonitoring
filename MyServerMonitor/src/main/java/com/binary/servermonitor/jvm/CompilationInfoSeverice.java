package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.ClassLoadingInfoBean;
import com.binary.servermonitor.entity.jvmbean.CompilationInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Service
public class CompilationInfoSeverice {

    @Autowired
    CompilationInfoBean compilationInfoBean;

    public String getcompilationInfo(String host,String startTime,String endTime,int size){

        String res = null;

        compilationInfoBean.setHost(host);
        compilationInfoBean.setStartTime(startTime);
        compilationInfoBean.setEndTime(endTime);
        compilationInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.compilationInfoIndex,compilationInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
