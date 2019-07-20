package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetCpuUseUtilService;
import com.binary.servermonitor.service.queryseverice.GetMemUseInfoService;
import com.binary.servermonitor.service.queryseverice.GetMemUseUtilInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMemUseUtilInfoController {

    @PostMapping(value = "/getMemUseUtilInfo")
    public ArrayList[] getMemUseUtilInfo(String hostip){
        InfoBean memUseInfoBean = new InfoBean();
        memUseInfoBean.setId(hostip);
        memUseInfoBean.setSize(50);
        memUseInfoBean.setQueryUrl(SearchUrlList.memUseInfo);
        memUseInfoBean.setStartTime(DateTool.getOneHourStartTime());
        memUseInfoBean.setEndTime(DateTool.getNowTime());
        GetMemUseUtilInfoService service = new GetMemUseUtilInfoService();
        return service.getMemUseUtilService(memUseInfoBean);
    }
    @PostMapping(value = "/getDayMemUseUtilInfo")
    public ArrayList[] getDayMemUseUtilInfo(String hostip){
        InfoBean memUseInfoBean = new InfoBean();
        memUseInfoBean.setId(hostip);
        memUseInfoBean.setSize(1000);
        memUseInfoBean.setQueryUrl(SearchUrlList.memUseInfo);
        memUseInfoBean.setStartTime(DateTool.getOneDayStartTime());
        memUseInfoBean.setEndTime(DateTool.getNowTime());
        GetMemUseUtilInfoService service = new GetMemUseUtilInfoService();
        return service.getMemUseUtilService(memUseInfoBean);
    }

    @PostMapping(value = "/getWeekMemUseUtilInfo")
    public ArrayList[] getWeekMemUseUtilInfo(String hostip){
        InfoBean memUseInfoBean = new InfoBean();
        memUseInfoBean.setId(hostip);
        memUseInfoBean.setSize(5000);
        memUseInfoBean.setQueryUrl(SearchUrlList.memUseInfo);
        memUseInfoBean.setStartTime(DateTool.getOneWeekStartTime());
        memUseInfoBean.setEndTime(DateTool.getNowTime());
        GetMemUseUtilInfoService service = new GetMemUseUtilInfoService();
        return service.getMemUseUtilService(memUseInfoBean);
    }
}
