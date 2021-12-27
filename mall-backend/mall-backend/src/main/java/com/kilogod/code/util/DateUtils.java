package com.kilogod.code.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author anding
 * @describe  时间工具类
 */
public class DateUtils {
    public static DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter formatymd = DateTimeFormat.forPattern("yyyy-MM-dd");
    public static DateTimeFormatter formatymdnounline = DateTimeFormat.forPattern("yyyyMMdd");
    public static DateTimeFormatter formatymdhms = DateTimeFormat.forPattern("yyyyMMddHHmmss");
    public static DateTimeFormatter formatymdhmss = DateTimeFormat.forPattern("yyyyMMddHHmmssSSS");
    public static final String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将字符串转换为Date类型
     *
     * @param strDate
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate, String pattern) throws ValidationException {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        if (StringUtils.isBlank(pattern)){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            throw new ValidationException(e);
        }
    }

    /**
     * string转date
     * @param datetime
     * @return
     */
    public static Date StringToDate(String datetime,String pattern){
        final SimpleDateFormat sdFormat=new SimpleDateFormat(pattern);
        Date date = new Date(datetime);
        try {
            date = sdFormat.parse(datetime);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *判断时间是否为空
     */
    public static boolean isNotNull(Date date) {
        if ("null".equals(date) || date == null) {
            return false;
        }
        return true;
    }

    /**
     * 获取两时间之差
     */
    public static long differ(Date endtime, Date starttime) throws Exception {
        if (DateUtils.isNotNull(endtime) && DateUtils.isNotNull(starttime)) {
            return (endtime.getTime() - starttime.getTime()) / (24 * 60 * 60 * 1000);
        }else {
            throw new Exception("时间不能为空！");
        }
    }

    /**
     * 获取两时间相差多少分钟
     */
    public static long differSecond(Date endtime, Date starttime){
        if (DateUtils.isNotNull(endtime) && DateUtils.isNotNull(starttime)) {
            return (endtime.getTime() - starttime.getTime()) / 1000;
        }
        return 0;
    }

    /**
     *时间加天数
     */
    public static Date addDays(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, num);
        Date time = ca.getTime();
        return time;
    }

    /**
     * 获取时间戳
     */
    public static Long getTime(){
        return new Date().getTime();
    }
    /**
     * 将日期转化为string格式
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author Jerry[周昭泽]
     * @param date
     * @param pattern
     * @return
     * @throws ValidationException
     */
    public static String convertDateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isBlank(pattern)){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}