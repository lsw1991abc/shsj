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
	public static String save(HttpServletRequest request, MultipartFile file, String path) {
		String fileName = file.getOriginalFilename();
		fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		if (save(file, request.getServletContext().getRealPath("/") + path, fileName)) {
			return path + "/" + fileName;
		}else {
			return null;
		}
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
