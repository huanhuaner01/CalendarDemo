package com.example.calendarviewtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

/**
 * 用于日历显示的工具类
 * @author zhanghuan
 *
 */
public class CalendarUtil {
    public static int MAX_YEAR = 2100 ;
    public static int MIN_YEAR = 1970 ;
	public CalendarUtil() {
	}
	/**
	 * 获得要显示的所有的月数
	 * @return
	 */
	public static int getAllMonth(){
		int year = MAX_YEAR - MIN_YEAR +1 ;
		
		return year*12 ;
	}
    
	public static Date getData(int index){
		int year = MIN_YEAR+index/12;
		int month = index%12;
		Calendar date = new GregorianCalendar(year, month,1);
		Date d=date.getTime(); 
		return d;
	}
	/**
	 * 获得月份的天数
	 * @param index fragment所在月的下标
	 * @return
	 */
	public static int getDayNum(int index){
		
		int year = MIN_YEAR+index/12;
		int month = index%12;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = new GregorianCalendar(year, month,1);
		int daynum = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		SimpleDateFormat df1=new SimpleDateFormat("EEEE");
		Date d=date.getTime(); 
		Log.i("Main", df.format(d));
			 int day_of_week = date.get(Calendar.DAY_OF_WEEK); 
			 Date dt = date.getTime() ;
			 Log.i("Main",df.format(dt)+" "+df1.format(dt)+" DAY_OF_MONTH："+day_of_week+" date.getday:"+dt.getDay());
		return daynum ;
	}
	
	public static int getDayWeek(int index){
		int year = MIN_YEAR+index/12;
		int month = index%12;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = new GregorianCalendar(year, month,1);
		int dayweek = date.get(Calendar.DAY_OF_WEEK);
		return dayweek ;
		
	}
	
	/**
	 * 获取目前月份所在日历页面的下标
	 * @return
	 */
	public static int getCurrentMouth(){
		Calendar cal=Calendar.getInstance();
    	int year = cal.get(Calendar.YEAR) ;
    	int mouth = cal.get(Calendar.MONTH) ;
    	int day = cal.get(Calendar.DATE) ;
    	int currentIndex = (year - 1970)*12+mouth;
		return currentIndex ;
	} 
	
	/**
	 * 获得今天所在月份的第几天
	 * @return
	 */
	public static int getCurentDay(){
		Calendar cal=Calendar.getInstance();
		int day = cal.get(Calendar.DATE) ;
		return day ;
	}
	
}
