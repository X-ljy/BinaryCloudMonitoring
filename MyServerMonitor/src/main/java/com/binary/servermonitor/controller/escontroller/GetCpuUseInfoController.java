package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.CpuUseInfoBean;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetCpuUseInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetCpuUseInfoController {

    @PostMapping(value = "/getCpuUseInfo")
    public ArrayList[] getOneHour(String hostip){

        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneHourStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(50);
        GetCpuUseInfoService service = new GetCpuUseInfoService();
        ArrayList[] lists = new ArrayList[9];
        lists = service.getCpuUseService(cpuUseInfoBean);
        return lists;
    }

    @PostMapping(value = "/getDayCpuUseInfo")
    public ArrayList[] getDayCpuUseInfo(String hostip){

        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneDayStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(50);
        GetCpuUseInfoService service = new GetCpuUseInfoService();
        ArrayList[] lists = new ArrayList[9];
        lists = service.getCpuUseService(cpuUseInfoBean);
        return lists;
    }
    @PostMapping(value = "/getWeekCpuUseInfo")
    public ArrayList[] getWeekCpuUseInfo(String hostip){

        InfoBean cpuUseInfoBean = new InfoBean();
        cpuUseInfoBean.setStartTime(DateTool.getOneWeekStartTime());
        cpuUseInfoBean.setEndTime(DateTool.getNowTime());
        cpuUseInfoBean.setQueryUrl(SearchUrlList.cpuUseUrl);
        cpuUseInfoBean.setId(hostip);
        cpuUseInfoBean.setSize(50);
        GetCpuUseInfoService service = new GetCpuUseInfoService();
        ArrayList[] lists = new ArrayList[9];
        lists = service.getCpuUseService(cpuUseInfoBean);
        return lists;
    }

}
