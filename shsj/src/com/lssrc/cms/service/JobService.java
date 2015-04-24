/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.service;

import java.util.List;

import com.lssrc.cms.dto.JobDto;
import com.lssrc.cms.entity.Job;
import com.lssrc.cms.entity.JobBelong;
import com.lssrc.cms.entity.JobType;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
public interface JobService {
	
	public static String TYPE_JOB = "1";
	public static String TYPE_PARTTIME = "2";

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Navigator getNavigator(int pageNo, int pageSize, String type);

	/**
	 * @param id
	 * @return
	 */
	public JobDto getById(String id);

	/**
	 * @param navigator
	 * @param type
	 * @return
	 */
	public List<JobDto> getByPage(Navigator navigator, String type);

	/**
	 * @param top
	 * @param type
	 * @return
	 */
	public List<JobDto> getByTop(int top, String type);

	/**
	 * @param job
	 * @return
	 */
	public int save(Job job);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * @return
	 */
	public List<JobBelong> getBelong();
	
	/**
	 * @return
	 */
	public List<JobType> getType();

	/**
	 * @param job
	 * @return
	 */
	public int update(Job job);

}
