/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月17日
 */
package com.lssrc.cms.dto;

import com.lssrc.cms.entity.Job;
import com.lssrc.cms.entity.JobBelong;
import com.lssrc.cms.entity.JobType;

/**
 * @author Carl_Li
 *
 */
public class JobDto {
	
	private String jId;

	private Job job;
    
    private JobBelong jobBelong;
    
    private JobType jobType;
    
    public JobDto() {
		super();
	}

	/**
	 * @return the jId
	 */
	public String getjId() {
		return jId;
	}

	/**
	 * @param jId the jId to set
	 */
	public void setjId(String jId) {
		this.jId = jId;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the jobBelong
	 */
	public JobBelong getJobBelong() {
		return jobBelong;
	}

	/**
	 * @param jobBelong the jobBelong to set
	 */
	public void setJobBelong(JobBelong jobBelong) {
		this.jobBelong = jobBelong;
	}

	/**
	 * @return the jobType
	 */
	public JobType getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
    
}
