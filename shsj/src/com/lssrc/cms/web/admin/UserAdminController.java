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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dao.UserDao;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.MD5;

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
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/save"})
	public String save(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return  "redirect:" + Constants.ADMIN_PATH + "/user/";
	}
	
	/**
	 * 个人资料
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/ziliao"})
	public String profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("myself", userService.getById(myself.get("userId").toString()));
		return "user/myself";
	}
	
	/**
	 * 个人资料更新
	 * @param request
	 * @param response
	 * @param model
	 * @param nickname
	 * @param qq
	 * @param phoneno
	 * @param email
	 * @param userDesc
	 * @return
	 */
	@RequestMapping(value = {"/ziliao/update"}, method = RequestMethod.POST)
	public String updateProfile(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "nickname", required = false, defaultValue = "")String nickname,
			@RequestParam(value = "qq", required = false, defaultValue = "")String qq,
			@RequestParam(value = "phoneno", required = false, defaultValue = "")String phoneno,
			@RequestParam(value = "email", required = false, defaultValue = "")String email,
			@RequestParam(value = "userDesc", required = false, defaultValue = "")String userDesc) {
		
		Map<String, Object> user = userService.getById(myself.get("userId").toString());
		if (user != null) {
				if (StringUtils.isEmpty(nickname)) {
					nickname = myself.get("nickname").toString();
				}
				user.put("nickname", nickname);
				user.put("qq", qq);
				user.put("phoneno", phoneno);
				user.put("email", email);
				user.put("userDesc", userDesc);
				int count = userService.update(user);
				if (count == 1) {
					model.addAttribute("msg", "success");
					model.addAttribute("myself", user);
				} else {
					model.addAttribute("msg", "error");
				}
		} else {
			model.addAttribute("msg", "error");
		}
		return "user/myself";
	}
	
	/**
	 * 密码修改页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/xgmm"})
	public String password(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "user/password";
	}
	
	/**
	 * 密码修改
	 * @param request
	 * @param response
	 * @param model
	 * @param oldPasswd
	 * @param newPasswd1
	 * @param newPasswd2
	 * @return
	 */
	@RequestMapping(value = {"/passwd"}, method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "oldPasswd", required = false, defaultValue = "")String oldPasswd,
			@RequestParam(value = "newPasswd1", required = false, defaultValue = "")String newPasswd1,
			@RequestParam(value = "newPasswd2", required = false, defaultValue = "")String newPasswd2) {
		if (StringUtils.isNotEmpty(oldPasswd) && StringUtils.isNotEmpty(newPasswd1) && StringUtils.isNotEmpty(newPasswd2) && newPasswd1.equals(newPasswd2)) {
			Map<String, Object> user = userService.getById(myself.get("userId") + "");
			if (user != null && user.get("passwd").equals(MD5.getMD5Code(oldPasswd))) {
				user.put("passwd", MD5.getMD5Code(newPasswd1));
				if (userService.changePasswd(user) == 1) {
					model.addAttribute("msg", "success");
				} else {
					model.addAttribute("msg", "error");
				}
			} else {
				model.addAttribute("msg", "error");
			}
		} else {
			model.addAttribute("msg", "error");
		}
		return "user/password";
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
