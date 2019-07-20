package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.WarnRecord;
import com.binary.servermonitor.repository.WarnRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
@RestController
public class WarnRecordController {
    @Autowired
    WarnRecordRepository warnRecordRepository;
    @PostMapping(value = "/warn/record/query")
    public ArrayList<WarnRecord> warnRecordQuery(HttpSession session,@RequestParam Integer curr){
        System.out.println("curr:"+curr);
        Integer pageStart = (curr - 1) *10;
        ArrayList<WarnRecord> pagelist = new ArrayList<WarnRecord>();
        ArrayList<WarnRecord> list = warnRecordRepository.findAllByUsername(String.valueOf(session.getAttribute("username")));
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
    @PostMapping(value = "/warn/record/count")
    public int warnRecordCount(HttpSession session){
        ArrayList<WarnRecord> list = warnRecordRepository.findAllByUsername(String.valueOf(session.getAttribute("username")));
        System.out.println(list.size());
        return list.size();
    }
    @PostMapping(value = "/warn/record/delete")
    public String warnRecordDelete(@RequestParam Integer id){
        try {
            warnRecordRepository.deleteById(id);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }
}
