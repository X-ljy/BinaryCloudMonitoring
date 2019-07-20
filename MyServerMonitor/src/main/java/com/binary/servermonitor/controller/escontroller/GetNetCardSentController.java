package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetNetCardSentInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetNetCardSentController {

    @PostMapping(value = "/getNetCardSentInfo")
    public ArrayList[] getNetCardSent(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardSentInfoService service = new GetNetCardSentInfoService();
        ArrayList[] lists = service.getNetCardSend(infoBean);
        return lists;
    }
    @PostMapping(value = "/getDayNetCardSentInfo")
    public ArrayList[] getDayNetCardSent(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(1000);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardSentInfoService service = new GetNetCardSentInfoService();
        ArrayList[] lists = service.getNetCardSend(infoBean);
        return lists;
    }

    @PostMapping(value = "/getWeekNetCardSentInfo")
    public ArrayList[] getWeekNetCardSent(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(5000);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardSentInfoService service = new GetNetCardSentInfoService();
        ArrayList[] lists = service.getNetCardSend(infoBean);
        return lists;
    }
}
