package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetAverageLoadService;
import com.binary.servermonitor.service.queryseverice.GetCpuUseInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetAverageLoadInfoController {

    @PostMapping(value = "/getAverageLoadInfo")
    public ArrayList[] getAverageLoadInfo(String hostip){

        InfoBean infoBean = new InfoBean();
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        infoBean.setQueryUrl(SearchUrlList.averageLoad);
        infoBean.setId(hostip);
        infoBean.setSize(50);
        GetAverageLoadService service = new GetAverageLoadService();
        return service.getAverageLoad(infoBean);
    }
    @PostMapping(value = "/getDayAverageLoadInfo")
    public ArrayList[] getDayAverageLoadInfo(String hostip){

        InfoBean infoBean = new InfoBean();
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        infoBean.setQueryUrl(SearchUrlList.averageLoad);
        infoBean.setId(hostip);
        infoBean.setSize(1000);
        GetAverageLoadService service = new GetAverageLoadService();
        return service.getAverageLoad(infoBean);
    }
    @PostMapping(value = "/getWeekAverageLoadInfo")
    public ArrayList[] getWeekAverageLoadInfo(String hostip){

        InfoBean infoBean = new InfoBean();
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        infoBean.setQueryUrl(SearchUrlList.averageLoad);
        infoBean.setId(hostip);
        infoBean.setSize(5000);
        GetAverageLoadService service = new GetAverageLoadService();
        return service.getAverageLoad(infoBean);
    }
}
