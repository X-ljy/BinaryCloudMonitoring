package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetMysqlInnodbBufferService;
import com.binary.servermonitor.service.queryseverice.GetMysqlQpsService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMysqlInnodbBuffrtController {

    @PostMapping(value = "/getMysqlInnodbBuffer")
    public ArrayList[] getMysqlInnodbBuffer(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqLinnodbBuffer);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlInnodbBufferService service = new GetMysqlInnodbBufferService();
        return service.getMyqlInnodbBuffer(infoBean);
    }

    @PostMapping(value = "/getDayMysqlInnodbBuffer")
    public ArrayList[] getDayMysqlInnodbBuffer(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqLinnodbBuffer);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlInnodbBufferService service = new GetMysqlInnodbBufferService();
        return service.getMyqlInnodbBuffer(infoBean);
    }

    @PostMapping(value = "/getWeekMysqlInnodbBuffer")
    public ArrayList[] getWeekMysqlInnodbBuffer(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqLinnodbBuffer);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlInnodbBufferService service = new GetMysqlInnodbBufferService();
        return service.getMyqlInnodbBuffer(infoBean);
    }
}
