/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月22日
 */
package com.lssrc.cms.dto;

import java.util.Map;

/**
 * @author Carl_Li
 *
 */
public class NoticeDto {

	private Map<String, Object> notice;
	
	private int noticeCount;

	/**
	 * 
	 */
	public NoticeDto() {
		super();
	}

	/**
	 * @param notice
	 * @param noticeCount
	 */
	public NoticeDto(Map<String, Object> notice, int noticeCount) {
		super();
		this.notice = notice;
		this.noticeCount = noticeCount;
	}

	/**
	 * @return the notice
	 */
	public Map<String, Object> getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(Map<String, Object> notice) {
		this.notice = notice;
	}

	/**
	 * @return the noticeCount
	 */
	public int getNoticeCount() {
		return noticeCount;
	}

	/**
	 * @param noticeCount the noticeCount to set
	 */
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	
}
