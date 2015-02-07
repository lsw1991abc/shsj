/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年2月5日
 */
package com.lssrc.shsj.dto;

/**
 * @author Carl_Li
 *
 */
public class FileInfoDto {

	private String result;
	private String path;

	
	/**
	 * 
	 */
	public FileInfoDto() {
		super();
	}
	
	/**
	 * @param result
	 * @param path
	 */
	public FileInfoDto(String result, String path) {
		super();
		this.result = result;
		this.path = path;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
