package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetSwapUseInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetSwapUseInfoController {

    @PostMapping(value = "/getSwapUseInfo")
    public ArrayList[] getSwapUseInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.memUseInfo);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetSwapUseInfoService service = new GetSwapUseInfoService();
        ArrayList[] lists = service.getSwapUseService(infoBean);
        return lists;
    }

    @PostMapping(value = "/getDaySwapUseInfo")
    public ArrayList[] getDaySwapUseInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(1000);
        infoBean.setQueryUrl(SearchUrlList.memUseInfo);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetSwapUseInfoService service = new GetSwapUseInfoService();
        ArrayList[] lists = service.getSwapUseService(infoBean);
        return lists;
    }

    @PostMapping(value = "/getWeekSwapUseInfo")
    public ArrayList[] getWeekSwapUseInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(5000);
        infoBean.setQueryUrl(SearchUrlList.memUseInfo);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetSwapUseInfoService service = new GetSwapUseInfoService();
        ArrayList[] lists = service.getSwapUseService(infoBean);
        return lists;
    }
}
