package com.binary.servermonitor.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 夕
 * @date 2019/5/19
 */
public class DateTool {

    public static String getMinuteStartTime(){

        Calendar calendar = Calendar.getInstance();//获取当前时间

        if(calendar.get(Calendar.MINUTE) % 2 != 0 ){
            calendar.add(Calendar.MINUTE,-1);
        }else {
            calendar.add(Calendar.MINUTE,-2);
        }

        calendar.set(Calendar.SECOND,0);//清零秒数


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());

    }
    public static String getMinuteEndTime(){

        Calendar calendar = Calendar.getInstance();//获取当前时间

        if(calendar.get(Calendar.MINUTE) % 2 != 0 ){
            calendar.add(Calendar.MINUTE,1);
        }

        calendar.set(Calendar.SECOND,0);//清零秒数

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());

    }


    public static String getLogStartTime(){

        Calendar calendar = Calendar.getInstance();//获取当前时间
        calendar.add(Calendar.DATE,-1);
        calendar.set(Calendar.HOUR_OF_DAY,0); //清零小时数
        calendar.set(Calendar.MINUTE,0);//清零分钟数
        calendar.set(Calendar.SECOND,0);//清零秒数


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());

    }
    public static String getLogEndTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        calendar.add(Calendar.DATE,-1);
        calendar.set(Calendar.HOUR_OF_DAY,23); //清零小时数
        calendar.set(Calendar.MINUTE,59);//清零分钟数
        calendar.set(Calendar.SECOND,59);//清零秒数


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }

    public static String getOneHourStartTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        calendar.add(Calendar.HOUR,-1); //减去一小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }

    public static String getOneDayStartTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        calendar.add(Calendar.HOUR,-24); //减去一小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }
    public static String getOneWeekStartTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        calendar.add(Calendar.HOUR,-168); //减去一小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }
    public static String getNowTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }

    public static String getStartTime(){

        Calendar calendar = Calendar.getInstance();//获取当前时间
        int minute = calendar.get(Calendar.MINUTE);// 得到分钟
        while(minute%5 != 0){
            minute--;
        }
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.MINUTE,-2); //整点减两分钟
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());

    }

    public static String getOneStartTime(){

        Calendar calendar = Calendar.getInstance();//获取当前时间
//        int minute = calendar.get(Calendar.MINUTE);// 得到分钟
//        while(minute%5 != 0){
//            minute--;
//        }
        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.MINUTE,-5); //整点减五分钟
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());

    }

    public static String getEndTime(){
        Calendar calendar = Calendar.getInstance();//获取当前时间
        int minute = calendar.get(Calendar.MINUTE);// 得到分钟
        while(minute%5 != 0){
            minute--;
        }
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.MINUTE,2); //整点加两分钟
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }

    public static String getTwStartTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-20);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getOneStartTime());
    }

}
