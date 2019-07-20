package com.binary.servermonitor.jvm;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.jvmbean.RuntimeInfoBean;
import com.binary.servermonitor.entity.jvmbean.ThreadInfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 夕
 * @date 2019/6/1
 */
@Service
public class ThreadInfoSeverice {
    @Autowired
    ThreadInfoBean threadInfoBean;

    public String getThreadInfo(String host,String startTime,String endTime,int size){

        String res = null;

        threadInfoBean.setHost(host);
        threadInfoBean.setStartTime(startTime);
        threadInfoBean.setEndTime(endTime);
        threadInfoBean.setSize(size);

        try {
            res =  EsUtils.queryDataFromES(SearchUrlList.threadInfoIndex,threadInfoBean.toQueryString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
