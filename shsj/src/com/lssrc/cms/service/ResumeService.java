/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.entity.Resume;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
public interface ResumeService {

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Navigator getNavigator(int pageNo, int pageSize);

	/**
	 * @param id
	 * @return
	 */
	public Resume getById(String id);

	/**
	 * @param navigator
	 * @return
	 */
	public List<Resume> getByPage(Navigator navigator);

	/**
	 * @param string
	 * @return
	 */
	public Resume getByUserId(String userId);

	/**
	 * @param resume
	 * @return
	 */
	public int update(Resume resume);

	/**
	 * @param resume
	 * @return
	 */
	public int save(Resume resume);
	
}
