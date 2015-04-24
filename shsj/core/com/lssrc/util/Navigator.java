/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.util;

/**
 * @author Carl_Li
 *
 */
public class Navigator {

	private Integer firstPage; // 首页
	private Integer prePage; // 上一页
	private Integer nowPage; // 当前页
	private Integer nextPage; // 下一页
	private Integer lastPage; // 末页
	private Integer count; // 数据量
	private Integer pageSize; // 每页显示数据量
	private Integer pageCount; // 页码总数

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
	public static Navigator formatPageNavigator(int nowPageNo, int count, int pageSize) {
		if (pageSize <= 0 ) {
			throw new IllegalArgumentException("每页显示数量不合法");
		}
		
		int pageCount = 1;
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
		
		int firstPage = 1;
		int prePage = (nowPageNo - 1) < 1 ? 1 : (nowPageNo - 1);
		int nextPage = (nowPageNo + 1) > pageCount ? pageCount : (nowPageNo + 1);
		int lastPage = pageCount;
		
		return new Navigator(firstPage, prePage, nowPageNo, nextPage, lastPage, count, pageSize, pageCount);
	}

	/**
	 * @param firstPage
	 * @param prePage
	 * @param nowPage
	 * @param nextPage
	 * @param lastPage
	 * @param count
	 * @param pageSize
	 * @param pageCount
	 */
	public Navigator(Integer firstPage, Integer prePage, Integer nowPage,
			Integer nextPage, Integer lastPage, Integer count,
			Integer pageSize, Integer pageCount) {
		super();
		this.firstPage = firstPage;
		this.prePage = prePage;
		this.nowPage = nowPage;
		this.nextPage = nextPage;
		this.lastPage = lastPage;
		this.count = count;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
	}

	/**
	 * @return the firstPage
	 */
	public Integer getFirstPage() {
		return firstPage;
	}

	/**
	 * @param firstPage
	 *            the firstPage to set
	 */
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	/**
	 * @return the prePage
	 */
	public Integer getPrePage() {
		return prePage;
	}

	/**
	 * @param prePage
	 *            the prePage to set
	 */
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	/**
	 * @return the nowPage
	 */
	public Integer getNowPage() {
		return nowPage;
	}

	/**
	 * @param nowPage
	 *            the nowPage to set
	 */
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	/**
	 * @return the nextPage
	 */
	public Integer getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage
	 *            the nextPage to set
	 */
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * @return the lastPage
	 */
	public Integer getLastPage() {
		return lastPage;
	}

	/**
	 * @param lastPage
	 *            the lastPage to set
	 */
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

}
