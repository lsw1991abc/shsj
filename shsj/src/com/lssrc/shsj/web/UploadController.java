/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年2月4日
 */
package com.lssrc.shsj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lssrc.util.FileUtils;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping(value = { "/", "" })
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "test";
	}
	
	@RequestMapping(value = "/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		if (FileUtils.save(request, file, "/data/upload")) {
			return "result";
		} else {
			return "error";
		}
		
	}
	
	
}
