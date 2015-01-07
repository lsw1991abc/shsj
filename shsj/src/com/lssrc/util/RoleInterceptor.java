/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月15日
 */
package com.lssrc.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Carl_Li
 *
 */
public class RoleInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		Map<String, Object> user = null;
		user = (Map<String, Object>) request.getSession().getAttribute("myself");
		if (null != user && (user.get("issys") + "").equals("1")) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath()+ "/error/403");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView model) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}
	
}
