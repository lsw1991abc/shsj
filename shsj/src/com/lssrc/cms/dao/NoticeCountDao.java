/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月22日
 */
package com.lssrc.cms.dao;

/**
 * @author Carl_Li
 *
 */
public interface NoticeCountDao {
	
	int queryCount(String id);

	int save(String id);
	
}
