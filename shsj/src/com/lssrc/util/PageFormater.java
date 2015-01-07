/**
 * PageFormater.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public class PageFormater {
	
	public static String FIRST_PAGE_NO = "firstPageNo"; //首页
	public static String PRE_PAGE_NO = "prePageNo"; //上一页
	public static String NOW_PAGE_NO = "nowPageNo"; //当前页
	public static String NEXT_PAGE_NO = "nextPageNo"; //下一页
	public static String LAST_PAGE_NO = "lastPageNo"; //末页
	public static String COUNT = "count"; //数据量
	public static String PAGE_SIZE = "pageSize"; //每页显示数据量
	public static String PAGE_COUNT = "pageCount"; //页码总数
	
	/**
	 * 分页导航格式化
	 * @param nowPageNo 当前页码
	 * @param count 数据总量
	 * @param pageSize 每页显示数量
	 * @return Map<String, Integer> Key列表：<br />
	 * 			firstPageNo：首页<br />
	 * 			prePageNo：上一页<br />
	 *			nowPageNo：当前页<br />
	 * 			nextPageNo：下一页<br />
	 * 			lastPageNo：末页<br />
	 * 			pageCount：页面数量<br />
	 * 			count：数据量<br />
	 * 			pageSize：页面数量<br />
	 * @exception IllegalArgumentException 每页显示数量不合法
	 * @author Carl Li
	 * @since 1.0
	 */
	public static Map<String, Integer> getFormatPageNav(int nowPageNo, int count, int pageSize) {
		if (pageSize <= 0 ) {
			throw new IllegalArgumentException("每页显示数量不合法");
		}
		
		int pageCount = 1;
		int prePageNo = 1;
		int nextPageNo = 1;
		
		if (count <= pageSize) {
			pageCount = 1;
		} else {
			pageCount = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
		}
		
		if (nowPageNo < 1) {
			nowPageNo = 1;
		} else if(nowPageNo > pageCount) {
			nowPageNo = pageCount;
		}
		
		prePageNo = (nowPageNo - 1) < 1 ? 1 : (nowPageNo - 1);
		nextPageNo = (nowPageNo + 1) > pageCount ? pageCount : (nowPageNo + 1);
		
		Map<String, Integer> navigator = new HashMap<String, Integer>();
		
		navigator.put(FIRST_PAGE_NO, 1);
		navigator.put(PRE_PAGE_NO, prePageNo);
		navigator.put(NOW_PAGE_NO, nowPageNo);
		navigator.put(NEXT_PAGE_NO, nextPageNo);
		navigator.put(LAST_PAGE_NO, pageCount);
		
		navigator.put(COUNT, count);
		navigator.put(PAGE_SIZE, pageSize);
		navigator.put(PAGE_COUNT, pageCount);
		
		return navigator;
	}
	
}
