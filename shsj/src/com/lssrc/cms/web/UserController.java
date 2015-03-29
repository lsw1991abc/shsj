/**
 * UserController.java
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月5日
 */
package com.lssrc.cms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lssrc.cms.dto.DailyDto;
import com.lssrc.cms.dto.DailyListDto;
import com.lssrc.cms.dto.FileInfoDto;
import com.lssrc.cms.service.DailyService;
import com.lssrc.cms.service.ResumeService;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.FileUtils;
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
	 * 个人中心
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
	
	/**
	 * 日志列表
	 * @param request
	 * @param response
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
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
	
	/**
	 * 日志编辑
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {"/rizhi/edit"})
	public String dailyEdit(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "")String id){
		Map<String, Object> daily = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(id)) {
			daily = dailyService.getById(id).getDaily();
			if(!daily.get("d_builder").equals(myself.get("userId"))) {
				return "redirect:/rizhi/" + id;
			}
		} else {
			daily.put("d_title", "");
			daily.put("d_content", "");
		}
		model.addAttribute("daily", daily);
		return "daily/edit";
	}
	
	/**
	 * 日志保存
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping(value = {"/rizhi/save"}, method = RequestMethod.POST)
	public String dailySave(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "")String id,
			@RequestParam(value = "title", required = false, defaultValue = "")String title,
			@RequestParam(value = "content", required = false, defaultValue = "")String content){
		int count = 0;
		if (StringUtils.isNotEmpty(id)) {
			count = dailyService.update(id, title, content);
		} else {
			count = dailyService.save(myself.get("userId") + "", title, content);
		}
		if (count == 1) {
			return "redirect:/user/rizhi";
		} else {
			model.addAttribute("msg", "error");
			return "daily/edit";
		}
		
	}
	
	/**
	 * 日志删除
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 */
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
	public String resume(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Map<String, Object> resume = resumeService.getByUserId(myself.get("userId").toString());
		if (resume == null) {
			resume = new HashMap<String, Object>();
			resume.put("user", myself.get("nickname").toString());
			resume.put("userId", myself.get("userId").toString());
			int count = resumeService.save(resume);
			resume = resumeService.getByUserId(myself.get("userId").toString());
		}
		model.addAttribute("resume", resume);
		return "user/resume";
	}
	
	@RequestMapping(value = { "/jianli/img" })
	public FileInfoDto resumeImg(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		String path = "images/resume";
		String url = FileUtils.save(request, file, path);
		if (url != null) {
			return new FileInfoDto("success", url);
		} else {
			return new FileInfoDto("error", null);
		}
	}
	
	@RequestMapping(value = {"/jianli/update"}, method = RequestMethod.POST)
	public String updateResume(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "sex", required = false, defaultValue = "1") int sex,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age,
			@RequestParam(value = "height", required = false, defaultValue = "0.0") double height,
			@RequestParam(value = "weight", required = false, defaultValue = "0.0") double weight,
			@RequestParam(value = "college", required = false, defaultValue = "") String college,
			@RequestParam(value = "major", required = false, defaultValue = "") String major,
			@RequestParam(value = "experience", required = false, defaultValue = "") String experience,
			@RequestParam(value = "desc", required = false, defaultValue = "") String desc,
			@RequestParam(value = "imgPath", required = false, defaultValue = "") String imgPath,
			@RequestParam(value = "show", required = false, defaultValue = "0") int show) {
		Map<String, Object> resume = resumeService.getByUserId(myself.get("userId").toString());
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
			resume.put("imgPath", imgPath);
			resume.put("show", show);
			int count = resumeService.update(resume);
			if (count == 1) {
				model.addAttribute("msg", "success");
				model.addAttribute("resume", resumeService.getByUserId(myself.get("userId").toString()));
			} else {
				model.addAttribute("msg", "error");
			}
		} else {
			model.addAttribute("msg", "error");
		}
		
		return "user/resume";
	}
	
	/**
	 * 个人资料
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping({"/ziliao"})
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