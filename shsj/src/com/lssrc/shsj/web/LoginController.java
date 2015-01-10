/**
 * UserController.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.shsj.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lssrc.shsj.service.UserService;
import com.lssrc.util.MD5;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/login")
@SessionAttributes(types = {HashMap.class}, value = {"myself"})
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 默认
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "")
	public String index() {
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		HashMap<String, Object> user = (HashMap<String, Object>) userService.getByUsername(username);
		if (user != null) {
			String pwd = user.get("passwd").toString();
			if (pwd.equals(MD5.getMD5Code(password))) {
				model.addAttribute("myself", user);
				return "redirect:/user/";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}
	
	/**
	 * 注册页面跳转
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "register")
	public String register() {
		return "register";
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "reg")
	public String reg(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "username", required = true)String username,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "password2", required = true)String password2,
			@RequestParam(value = "qq", required = false, defaultValue = "")String qq,
			@RequestParam(value = "phoneno", required = false, defaultValue = "")String phoneno,
			@RequestParam(value = "email", required = false, defaultValue = "")String email) {
		
		username = StringUtils.trim(username);
		password = StringUtils.trim(password);
		password2 = StringUtils.trim(password2);
		qq = StringUtils.trim(qq);
		phoneno = StringUtils.trim(phoneno);
		email = StringUtils.trim(email);
		
		if (StringUtils.isNotEmpty(username) && 
				StringUtils.isNotEmpty(password) &&
				StringUtils.equals(password, password2) &&
				userService.isNotExist(username)) {
				Map<String, String> contations = new HashMap<String, String>();
				contations.put("username", username);
				contations.put("password", MD5.getMD5Code(password));
				contations.put("qq", qq);
				contations.put("phoneno", phoneno);
				contations.put("email", email);
				if (userService.save(contations)) {
					model.addAttribute("msg", "success");
				} else {
					model.addAttribute("msg", "error");
				}
		} else {
			model.addAttribute("msg", "error");
		}
		return "register";
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
	
}
