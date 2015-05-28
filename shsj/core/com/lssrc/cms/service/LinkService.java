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
	
	public static int TYPE_ALL = 0;
	public static int TYPE_FRIEND = 1;
	public static int TYPE_COPYRIGHT = 2;
	public static int TYPE_SITE = 3;
	
	public List<Link> getByType(int type);

	public List<Link> getAll();

	public Link getById(String id);

	public int save(Link link);
	
	public int update(Link link);

}
