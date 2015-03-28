/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月15日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

	/**
	 * 
	 * @param request
	 * @param response
	 * @param errorCode
	 * @return
	 */
	@RequestMapping("/{errorCode}")
	public String error403(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("errorCode")String errorCode) {
		return "error/" + errorCode;
	}
	
}
