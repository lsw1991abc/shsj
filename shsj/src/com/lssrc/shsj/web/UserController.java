/**
 * UserController.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.shsj.web;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.jsf.FacesContextUtils;

import com.lssrc.shsj.dto.DailyDto;
import com.lssrc.shsj.dto.DailyListDto;
import com.lssrc.shsj.service.DailyService;
import com.lssrc.shsj.service.ResumeService;
import com.lssrc.shsj.service.UserService;
import com.lssrc.util.MD5;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private HashMap<String, Object> myself;

	@Autowired
	private UserService userService;
	
	@Autowired
	private DailyService dailyService;
	
	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 个人信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping({"", "/", "/myself", })
	public String myself(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "user/index";
	}
	
	@RequestMapping({"/rizhi"})
	public String daily(HttpServletRequest request, HttpServletResponse response, ModelMap model, 
			@RequestParam(value = "page", required = false, defaultValue = "1")int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize) {
		
		String userId = myself.get("userId").toString();
		Map<String, Integer> navigator = dailyService.getNavigatorByUser(pageNo, pageSize, userId);
		List<Map<String, Object>> dailies = dailyService.getByPageByUser(navigator, userId);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("dailies", dailies);
		
		return "user/daily";
	}
	
	@RequestMapping(value = {"/rizhi/edit"})
	public String dailyEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "")String id){
		DailyDto daily = new DailyDto();
		if (StringUtils.isNotEmpty(id)) {
			daily = dailyService.getById(id);
			if(!daily.getDaily().get("d_builder").equals(myself.get("userId"))) {
				return "redirect:/rizhi/" + id;
			}
		} else {
			daily.getDaily().put("d_title", "");
			daily.getDaily().put("d_content", "");
		}
		model.addAttribute("daily", daily);
		return "daily/edit";
	}
	
	@RequestMapping(value = {"/rizhi/save"}, method = RequestMethod.POST)
	public Map<String, Object> dailySave(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "")String id,
			@RequestParam(value = "title", required = false, defaultValue = "")String title,
			@RequestParam(value = "content", required = false, defaultValue = "")String content){
		Map<String, Object> result = new HashMap<String, Object>();
		
		int count = 0;
		if (StringUtils.isNotEmpty(id)) {
			count = dailyService.update(id, title, content);
		} else {
			count = dailyService.save(myself.get("userId") + "", title, content);
		}
		if (count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}
		return result;
	}
	
	@RequestMapping(value = {"/rizhi/del"}, method = RequestMethod.POST)
	public Map<String, Object> dailyDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "")String id) {
		DailyDto daily = new DailyDto();
		Map<String, Object> result = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(id)) {
			daily = dailyService.getById(id);
			if(daily.getDaily().get("d_builder").equals(myself.get("userId")) && 1 == dailyService.delete(id)) {
				result.put("result", "success");
			} else {
				result.put("result", "error");
			}
		} else {
			result.put("result", "error");
		}
		return result;
	}
	
	@RequestMapping({"/jianli"})
	public Map<String, Object> resume(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Map<String, Object> resume = resumeService.getByUserId(myself.get("userId").toString());
		if (resume == null) {
			resume = new HashMap<String, Object>();
			resume.put("user", myself.get("nickname").toString());
			resume.put("userId", myself.get("userId").toString());
			int count = resumeService.save(resume);
			resume = resumeService.getByUserId(myself.get("userId").toString());
		}
		return resume;
	}
	
	@RequestMapping(value = {"/jianli/update"}, method = RequestMethod.POST)
	public Map<String, Object> updateResume(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "userId", required = true)String userId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "sex", required = false, defaultValue = "1") String sex,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age,
			@RequestParam(value = "height", required = false, defaultValue = "0.0") double height,
			@RequestParam(value = "weight", required = false, defaultValue = "0.0") double weight,
			@RequestParam(value = "college", required = false, defaultValue = "") String college,
			@RequestParam(value = "major", required = false, defaultValue = "") String major,
			@RequestParam(value = "experience", required = false, defaultValue = "") String experience,
			@RequestParam(value = "desc", required = false, defaultValue = "") String desc,
			@RequestParam(value = "show", required = false, defaultValue = "0") String show) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> resume = resumeService.getByUserId(userId);
		if (resume != null) {
			if (StringUtils.isEmpty(name)) {
				name = myself.get("nickname") + "";
			}
			resume.put("name", name);
			resume.put("sex", sex);
			resume.put("age", age);
			resume.put("height", height);
			resume.put("weight", weight);
			resume.put("college", college);
			resume.put("major", major);
			resume.put("experience", experience);
			resume.put("desc", desc);
			resume.put("show", show);
			int count = resumeService.update(resume);
			if (count == 1) {
				result.put("result", "success");
			} else {
				result.put("result", "error");
			}
		} else {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@RequestMapping({"/ziliao"})
	public Map<String, Object> profile(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return userService.getById(myself.get("userId").toString());
	}
	
	@RequestMapping(value = {"/ziliao/update"}, method = RequestMethod.POST)
	public Map<String, Object> updateProfile(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "userId", required = true)String userId,
			@RequestParam(value = "username", required = true)String username,
			@RequestParam(value = "nickname", required = false, defaultValue = "")String nickname,
			@RequestParam(value = "qq", required = false, defaultValue = "")String qq,
			@RequestParam(value = "phoneno", required = false, defaultValue = "")String phoneno,
			@RequestParam(value = "email", required = false, defaultValue = "")String email,
			@RequestParam(value = "userDesc", required = false, defaultValue = "")String userDesc) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Map<String, Object> user = userService.getById(userId);
		if (user != null) {
			if (user.get("username").equals(username)) {
				if (StringUtils.isEmpty(nickname)) {
					nickname = username;
				}
				user.put("nickname", nickname);
				user.put("qq", qq);
				user.put("phoneno", phoneno);
				user.put("email", email);
				user.put("userDesc", userDesc);
				int count = userService.update(user);
				if (count == 1) {
					result.put("result", "success");
				} else {
					result.put("result", "error");
				}
			} else {
				result.put("result", "error");
			}
		} else {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@RequestMapping(value = {"/xgmm"})
	public String password(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "user/password";
	}
	
	@RequestMapping(value = {"/passwd"}, method = RequestMethod.POST)
	public Map<String, Object> updatePassword(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "oldPasswd", required = false, defaultValue = "")String oldPasswd,
			@RequestParam(value = "newPasswd1", required = false, defaultValue = "")String newPasswd1,
			@RequestParam(value = "newPasswd2", required = false, defaultValue = "")String newPasswd2) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(oldPasswd) && StringUtils.isNotEmpty(newPasswd1) && StringUtils.isNotEmpty(newPasswd2) && newPasswd1.equals(newPasswd2)) {
			String userId = myself.get("userId") + "";
			Map<String, Object> user = userService.getById(userId);
			if (user != null && user.get("passwd").equals(MD5.getMD5Code(oldPasswd))) {
				user.put("passwd", MD5.getMD5Code(newPasswd1));
				int count = userService.changePasswd(user);
				if (count == 1) {
					result.put("result", "success");
				} else {
					result.put("result", "error");
				}
			} else {
				result.put("result", "error");
			}
		} else {
			result.put("result", "error");
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute(value  = "myself")
	public void name(HttpSession session ) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
