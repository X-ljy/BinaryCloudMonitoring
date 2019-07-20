package com.binary.servermonitor.controller.mysql;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.entity.mysql.ConnNumber;

import com.binary.servermonitor.service.queryseverice.GetMysqlConnNumService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetMysqlConnNumController {
    @PostMapping(value = "/getMysqlConnNum")
    public ArrayList<ConnNumber> getConnNum(@RequestParam String hostip,@RequestParam Integer curr){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlConnectionNumber);
        infoBean.setStartTime(DateTool.getStartTime());
        infoBean.setEndTime(DateTool.getEndTime());
        GetMysqlConnNumService service = new GetMysqlConnNumService();
        ArrayList<ConnNumber> list = service.getMyqlConnNum(infoBean);
        ArrayList<ConnNumber> pagelist = new ArrayList<>();

        System.out.println("curr:"+curr);
        Integer pageStart = (curr - 1) *10;
        for (Integer i = pageStart;i<pageStart+10;i++){
            if (i>=list.size()){
                break;
            }
            else {
                pagelist.add(list.get(i));
            }
        }
        return pagelist;
    }
    @PostMapping(value = "/getMysqlConnNumCount")
    public Integer getNumCount(@RequestParam String hostip){
        InfoBean infoBean = new InfoBean();
        infoBean.setId(hostip);
        infoBean.setSize(50);
        infoBean.setQueryUrl(SearchUrlList.mysqlConnectionNumber);
        infoBean.setStartTime(DateTool.getStartTime());
        infoBean.setEndTime(DateTool.getEndTime());
        GetMysqlConnNumService service = new GetMysqlConnNumService();
        ArrayList<ConnNumber> list = service.getMyqlConnNum(infoBean);
        return list.size();
    }
}
