package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetMysqlKeyBufferService;
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
public class GetMysqlKeyBufferController {

    @PostMapping(value = "/getMysqlKeyBuffer")
    public ArrayList[] getMysqlQps(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlKeyBuffer);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlKeyBufferService service = new GetMysqlKeyBufferService();
        return service.getKeyBuffer(infoBean);
    }

    @PostMapping(value = "/getDayMysqlKeyBuffer")
    public ArrayList[] getDayMysqlQps(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlKeyBuffer);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlKeyBufferService service = new GetMysqlKeyBufferService();
        return service.getKeyBuffer(infoBean);
    }

    @PostMapping(value = "/getWeekMysqlKeyBuffer")
    public ArrayList[] getWeekMysqlQps(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlKeyBuffer);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlKeyBufferService service = new GetMysqlKeyBufferService();
        return service.getKeyBuffer(infoBean);
    }
}
