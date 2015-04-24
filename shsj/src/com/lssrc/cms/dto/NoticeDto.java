/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月22日
 */
package com.lssrc.cms.dto;

import com.lssrc.cms.entity.Notice;
import com.lssrc.cms.entity.User;

/**
 * @author Carl_Li
 *
 */
public class NoticeDto {
	
	private String nId;

	private Notice notice;
	
	private int noticeCount;
	
	private User user;

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
	public NoticeDto(Notice notice, int noticeCount) {
		super();
		this.notice = notice;
		this.noticeCount = noticeCount;
	}

	/**
	 * @return the nId
	 */
	public String getnId() {
		return nId;
	}

	/**
	 * @param nId the nId to set
	 */
	public void setnId(String nId) {
		this.nId = nId;
	}

	/**
	 * @return the notice
	 */
	public Notice getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(Notice notice) {
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
