package com.binary.servermonitor.controller.escontroller;

import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.ProcessInfo;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.entity.esbean.ProcessBean;
import com.binary.servermonitor.service.queryseverice.GetProcessInfoService;
import com.binary.servermonitor.util.DateTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class GetProcessInfoController {

    @PostMapping(value = "/getProcessInfo")
    public ArrayList<ProcessInfo> getProcessInfo(@RequestParam String hostip,@RequestParam Integer curr){
        ProcessBean processBean = new ProcessBean();
        processBean.setId(hostip);
        processBean.setSize(1000);
        processBean.setQueryUrl(SearchUrlList.processInfo);
        processBean.setStartTime(DateTool.getStartTime());
        processBean.setEndTime(DateTool.getEndTime());
        GetProcessInfoService service = new GetProcessInfoService();
        ArrayList<ProcessInfo> list = service.getProcessInfo(processBean);

        ArrayList<ProcessInfo> pagelist = new ArrayList<>();
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
    @PostMapping(value = "/getProcessCount")
    public Integer getProcessCount(@RequestParam String hostip){
        ProcessBean processBean = new ProcessBean();
        processBean.setId(hostip);
        processBean.setSize(1000);
        processBean.setQueryUrl(SearchUrlList.processInfo);
        processBean.setStartTime(DateTool.getStartTime());
        processBean.setEndTime(DateTool.getEndTime());
        GetProcessInfoService service = new GetProcessInfoService();
        return service.getProcessCount(processBean);
    }
}
