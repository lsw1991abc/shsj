/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月7日
 */
package com.lssrc.cms.dto;

import com.lssrc.cms.entity.NoticeComment;
import com.lssrc.cms.entity.User;

/**
 * @author Carl_Li
 *
 */
public class NoticeCommentDto {

	private String ncId;
	private NoticeComment noticeComment;
	private User user;
	/**
	 * @return the ncId
	 */
	public String getNcId() {
		return ncId;
	}
	/**
	 * @param ncId the ncId to set
	 */
	public void setNcId(String ncId) {
		this.ncId = ncId;
	}
	/**
	 * @return the noticeComment
	 */
	public NoticeComment getNoticeComment() {
		return noticeComment;
	}
	/**
	 * @param noticeComment the noticeComment to set
	 */
	public void setNoticeComment(NoticeComment noticeComment) {
		this.noticeComment = noticeComment;
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
