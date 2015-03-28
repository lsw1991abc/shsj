/**
 * UserController.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.cms.web.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dao.UserDao;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.MD5;
import com.sun.org.glassfish.gmbal.ParameterNames;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/user")
public class UserAdminController {
	
	private HashMap<String, Object> myself;

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = {"", "/"})
	public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Map<String, Integer> navigator = userService.getNavigator(pageNo, pageSize, UserDao.IS_NOT_SYS);

		model.addAttribute("navigator", navigator);
		model.addAttribute("users", userService.getByPage(navigator, UserDao.IS_NOT_SYS));
		return Constants.ADMIN_PATH + "/user/list";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/admin"})
	public String adminList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Map<String, Integer> navigator = userService.getNavigator(pageNo, pageSize, UserDao.IS_SYS);

		model.addAttribute("navigator", navigator);
		model.addAttribute("users", userService.getByPage(navigator, UserDao.IS_SYS));
		return Constants.ADMIN_PATH + "/user/admins";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/group"})
	public String groupList(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Map<String, Integer> navigator = userService.getNavigator(pageNo, pageSize, UserDao.IS_SYS);

		model.addAttribute("navigator", navigator);
		model.addAttribute("users", userService.getByPage(navigator, UserDao.IS_SYS));
		return Constants.ADMIN_PATH + "/user/groups";
	}
	
	@RequestMapping(value = {"/edit/{issys}/{id}"})
	public String changeRole(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable("issys") int issys,
			@PathVariable("id") String id) {
		int count = userService.changeRole(id, issys);
		if (issys == 1) {
			return  "redirect:" + Constants.ADMIN_PATH + "/user/";
		} else {
			return  "redirect:" + Constants.ADMIN_PATH + "/user/admin";
		}
	}
	
	
	/**
	 * 获取当前session
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute(value  = "myself")
	public void name(HttpSession session ) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
