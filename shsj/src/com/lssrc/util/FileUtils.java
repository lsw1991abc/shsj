/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年2月4日
 */
package com.lssrc.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Carl_Li
 *
 */
public class FileUtils {

	/**
	 * 
	 * @param request
	 * @param file
	 * @param path
	 * @return
	 * 
	 * @author Carl_Li
	 */
	public static boolean save(HttpServletRequest request, MultipartFile file, String path) {
		return save(file, request.getServletContext().getRealPath("/") + path, file.getOriginalFilename()) ? true : false;
	}
	
	/**
	 * 
	 * @param request
	 * @param file
	 * @param path
	 * @param fileName
	 * @return
	 * 
	 * @author Carl_Li
	 */
	public static boolean save(HttpServletRequest request, MultipartFile file, String path, String fileName) {
		fileName = fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		return save(file, request.getServletContext().getRealPath("/") + path, fileName) ? true : false;
	}
	
	/**
	 * 
	 * @param file
	 * @param path
	 * @param fileName
	 * @return
	 * 
	 * @author Carl_Li
	 */
	private static boolean save(MultipartFile file, String path, String fileName) {
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
