package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.service.queryseverice.GetMysqlInnodbBufferService;
import com.binary.servermonitor.service.queryseverice.GetMysqlThreadCacheService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMysqlThreadCacheController {

    @PostMapping(value = "/getMysqlThreadCache")
    public ArrayList[] getMysqlThreadCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlThreadCache);
        infoBean.setStartTime(DateTool.getOneHourStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlThreadCacheService service = new GetMysqlThreadCacheService();
        return service.getMyqlThreadCache(infoBean);
    }

    @PostMapping(value = "/getDayMysqlThreadCache")
    public ArrayList[] getDayMysqlThreadCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlThreadCache);
        infoBean.setStartTime(DateTool.getOneDayStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlThreadCacheService service = new GetMysqlThreadCacheService();
        return service.getMyqlThreadCache(infoBean);
    }

    @PostMapping(value = "/getWeekMysqlThreadCache")
    public ArrayList[] getWeekMysqlThreadCache(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlThreadCache);
        infoBean.setStartTime(DateTool.getOneWeekStartTime());
        infoBean.setEndTime(DateTool.getNowTime());
        GetMysqlThreadCacheService service = new GetMysqlThreadCacheService();
        return service.getMyqlThreadCache(infoBean);
    }
}
