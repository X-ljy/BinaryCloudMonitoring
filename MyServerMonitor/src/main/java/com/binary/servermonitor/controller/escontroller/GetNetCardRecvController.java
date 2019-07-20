package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetNetCardRecvInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetNetCardRecvController {

    @PostMapping(value = "/getNetCardRecvInfo")
    public ArrayList[] getRecvInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardRecvInfoService service = new GetNetCardRecvInfoService();
        ArrayList[] lists = service.getNetCardRecvInfo(infoBean);
        return lists;
    }
    @PostMapping(value = "/getDayNetCardRecvInfo")
    public ArrayList[] getDayRecvInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(1000);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardRecvInfoService service = new GetNetCardRecvInfoService();
        ArrayList[] lists = service.getNetCardRecvInfo(infoBean);
        return lists;
    }
    @PostMapping(value = "/getWeekNetCardRecvInfo")
    public ArrayList[] getWeekRecvInfo(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(5000);
        infoBean.setQueryUrl(SearchUrlList.netCardInfo);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetNetCardRecvInfoService service = new GetNetCardRecvInfoService();
        ArrayList[] lists = service.getNetCardRecvInfo(infoBean);
        return lists;
    }
}
