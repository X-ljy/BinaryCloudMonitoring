package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetIoSWTimeInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetIoSWTimeInfoController {

    @PostMapping(value = "/getIoSWTimeInfo")
    public ArrayList[] getIoSWTimeInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.diskIoInfo);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetIoSWTimeInfoService service = new GetIoSWTimeInfoService();
        return service.getIoSWTime(infoBean);
    }
    @PostMapping(value = "/getDayIoSWTimeInfo")
    public ArrayList[] getDayIoSWTimeInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(1000);
        infoBean.setQueryUrl(SearchUrlList.diskIoInfo);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetIoSWTimeInfoService service = new GetIoSWTimeInfoService();
        return service.getIoSWTime(infoBean);
    }
    @PostMapping(value = "/getWeekIoSWTimeInfo")
    public ArrayList[] getWeekIoSWTimeInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(5000);
        infoBean.setQueryUrl(SearchUrlList.diskIoInfo);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetIoSWTimeInfoService service = new GetIoSWTimeInfoService();
        return service.getIoSWTime(infoBean);
    }
}
