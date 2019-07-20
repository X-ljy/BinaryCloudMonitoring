package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.WarnNotice;
import com.binary.servermonitor.entity.WarnRecord;
import com.binary.servermonitor.repository.WarnRecordRepository;
import com.binary.servermonitor.util.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Wei Peng
 */
@RestController
public class WarnNoticeController {

    @Autowired
    WarnRecordRepository warnRecordRepository;

    @PostMapping(value = "/warn/notice")
    public WarnNotice warnNotice(HttpSession session){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = df.format(new Date());
        System.out.println();
        String username = String.valueOf(session.getAttribute("username"));
        try {
            ArrayList<WarnRecord> list = warnRecordRepository.findByUsernameAndWarnTimeAfter(username,DateTool.getStartTime());
            WarnRecord warnRecord = list.get(0);
            WarnNotice notice = new WarnNotice();
            notice.setStatus("warn");
            notice.setReason(warnRecord.getWarnReason());
            return notice;
        }catch (Exception e){
            WarnNotice notice = new WarnNotice();
            notice.setStatus("normal");
            return notice;
        }
    }
}
