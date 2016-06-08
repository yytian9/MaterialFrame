package com.ytsky.materialframe.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yytian on 2015/9/8.
 */
public class DateUtils {
    private static SimpleDateFormat sf = null;

    /*获取系统时间 格式为："yyyy/MM/dd "*/
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /*时间戳转换成年月日字符串*/
    public static String getDateToString(long time) {
        Date d = new Date(time );
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /**
     * 时间戳转换成月日字符串
     *
     * @param time
     * @return
     */
    public static String getDateToMonthString(long time) {
        Date d = new Date(time);
        sf = new SimpleDateFormat("MM-dd");
        return sf.format(d);
    }

    /**
     * 时间戳转换成月日字符串
     *
     * @param time
     * @return
     */
    public static String getDateToMonthStrings(long time) {
        Date d = new Date(time );
        sf = new SimpleDateFormat("MM-dd");
        return sf.format(d);
    }

    /*时间戳转换成年月日字符串*/
    public static String getDateToYearMonthString(long time) {
        Date d = new Date(time );
        sf = new SimpleDateFormat("yyyy-MM-dd");
        int currentYear = getCurrentYear();
        int year = getYear(time);
        if (currentYear == year) {
            return new SimpleDateFormat("MM-dd").format(d);
        } else {
            return new SimpleDateFormat("yyyy-MM-dd").format(d);
        }
    }

    /*将字符串转为时间戳*/
    public static long getStringToDate(String time) {
        sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    /* 将时间戳转为字符串 */
    public static String getTimeToString(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }

    /* 将时间戳转为字符串 */
    public static String getTimeToStringWithNoSecond(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time );
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sf.format(d);
    }

    /* 提取月份字符串 */
    public static String getDateYearString(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy");
        return sf.format(d);
    }

    /* 提取月份字符串 */
    public static String getDateMonthString(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("MM");
        return sf.format(d);
    }

    /* 提取月份字符串 */
    public static String getDateString(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("dd");
        return sf.format(d);
    }

    /**
     * 转换学员时间戳成年月日字符串
     *
     * @param time
     * @return
     */
    public static String getDateStudentDetail(long time) {
        Date date = new Date(time);
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        String s1 = sf.format(date);
        String s2 = getCurrentDate();
        if (getMonth(time) == getCurrentMonth()) {
            return "本月";
        }
        if (s1.substring(0, s1.indexOf("年")).equals(s2.substring(0, s2.indexOf("-")))) {
            return s1.substring(s1.indexOf("年") + 1, s1.indexOf("月") + 1);
        }
        return s1.substring(0, s1.indexOf("月") + 1);

    }

    /**
     * 转换学员时间戳成年月字符串
     *
     * @param time
     * @return
     */
    public static String getDateYearMonth(long time) {
        Date date = new Date(time);
        sf = new SimpleDateFormat("yyyy年MM月");
        String s1 = sf.format(date);
        String s2 = getCurrentDate();
        if (s1.substring(0, s1.indexOf("年")).equals(s2.substring(0, s2.indexOf("-"))))
            return s1.substring(s1.indexOf("年") + 1, s1.indexOf("月") + 1);
        return s1.substring(0, s1.indexOf("月") + 1);
    }

    /**
     * 转换学员时间戳成年字符串
     *
     * @param time
     * @return
     */
    public static String getDateYear(long time) {
        Date date = new Date(time);
        sf = new SimpleDateFormat("yyyy年");
        return sf.format(date);
    }

    /**
     * 转换学员时间戳成月字符串
     *
     * @param time
     * @return
     */
    public static String getDateMonth(long time) {
        Date date = new Date(time);
        sf = new SimpleDateFormat("MM月");
        return sf.format(date);
    }

    /**
     * 获取年份int型数据
     *
     * @return
     */
    public static int getYear(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份int型数据
     *
     * @return
     */
    public static int getMonth(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期int型数据
     *
     * @return
     */
    public static int getDay(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当日日期int型数据
     *
     * @return
     */
    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当月月份int型数据
     *
     * @return
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当年年份int型数据
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 在现有时间戳上加一个月
     *
     * @param dateL
     * @return
     */
    public static String plusOneMonth(long dateL) {
        int monthInt = Integer.parseInt(DateUtils.getDateMonthString(dateL)) + 1;
        String month;
        if (monthInt > 12) {
            month = "01";
        } else if (monthInt > 0 && monthInt < 10) {
            month = "0" + monthInt;
        } else {
            month = monthInt + "";
        }
        return DateUtils.getDateYearString(dateL) + "-" + month + "-" + DateUtils.getDateString(dateL);
    }

    /* 将时间戳转为字符串 */
    public static String getTime(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("HH:mm");
        return sf.format(d);
    }

    /* 将时间戳转为字符串 */
    public static String getDate(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time );
        sf = new SimpleDateFormat("yyyy/MM/dd");
        return sf.format(d);
    }

    /* 将时间戳转为字符串 获取系统的时间*/
    public static String getSystemTime(long time) {
        //yyyy-MM-dd HH:mm:ss
        Date d = new Date(time);
        sf = new SimpleDateFormat("HH:mm");
        return sf.format(d);
    }

    public static int calculateDayInterval(long now, long future) {
        return (int) ((future - now) / 3600 / 24);
    }
}
