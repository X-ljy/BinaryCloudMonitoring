package com.binary.servermonitor.kafka_to_es.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author 夕
 * @date 2019/5/15
 */
public class DateFormat {

    public static String getNowTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }


    public static String DateFormatToString(String date){

        date = date.replace("Z", ".000 UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date1 = null;
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date1.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd = format3.format(date2);
        return dd;
    }



}
