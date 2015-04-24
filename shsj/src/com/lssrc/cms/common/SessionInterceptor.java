/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月15日
 */
package com.lssrc.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lssrc.cms.entity.User;

/**
 * @author Carl_Li
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		User user = null;
		user = (User) request.getSession().getAttribute("myself");
		if (null == user) {
			response.sendRedirect(request.getContextPath()+ "/error/403");
			return false;
		}
		return true;
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
