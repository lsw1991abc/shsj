/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月8日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.entity.Link;

/**
 * @author Carl_Li
 *
 */
public interface LinkService {
	
	public static Integer TYPE_FRIEND = 1;
	public static Integer TYPE_COPYRIGHT = 2;
	public static Integer TYPE_SITE = 3;
	
	public List<Link> getByPage(int type);

}
