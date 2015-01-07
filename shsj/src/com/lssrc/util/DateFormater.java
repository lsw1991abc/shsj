/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Carl_Li
 *
 */
public class DateFormater {
	
	/**
	 * 
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getTimestamp() {
		return String.valueOf(Calendar.getInstance().getTimeInMillis());
	}
	
}
