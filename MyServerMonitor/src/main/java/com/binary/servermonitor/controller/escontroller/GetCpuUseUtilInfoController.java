package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetCpuUseInfoService;
import com.binary.servermonitor.service.queryseverice.GetCpuUseUtilService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetCpuUseUtilInfoController {

    @PostMapping(value = "/getCpuUseUtilInfo")
    public ArrayList[] getOneHour(String hostip){
        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneHourStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(50);
        GetCpuUseUtilService service = new GetCpuUseUtilService();
        return service.getCpuUseService(cpuUseInfoBean);
    }

    @PostMapping(value = "/getDayCpuUseUtilInfo")
    public ArrayList[] getDayCPuUtil(String hostip){
        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneDayStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(1000);
        GetCpuUseUtilService service = new GetCpuUseUtilService();
        return service.getCpuUseService(cpuUseInfoBean);
    }

    @PostMapping(value = "/getWeekCpuUseUtilInfo")
    public ArrayList[] getWeekCPuUtil(String hostip){
        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneWeekStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(5000);
        GetCpuUseUtilService service = new GetCpuUseUtilService();
        return service.getCpuUseService(cpuUseInfoBean);
    }
}
