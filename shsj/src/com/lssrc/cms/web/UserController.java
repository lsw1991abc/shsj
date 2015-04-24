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
import org.springframework.web.multipart.MultipartFile;

import com.lssrc.cms.dto.FileInfoDto;
import com.lssrc.cms.entity.Notice;
import com.lssrc.cms.entity.Resume;
import com.lssrc.cms.entity.User;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.cms.service.ResumeService;
import com.lssrc.cms.service.UserService;
import com.lssrc.util.DateFormater;
import com.lssrc.util.FileUtils;
import com.lssrc.util.MD5;
import com.lssrc.util.Navigator;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private User myself;

	@Autowired
	private UserService userService;
	
	@Autowired
	private NoticeService noticeService;
	
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
		
		String userId = myself.getUserId();
		Navigator navigator = noticeService.getNavigator(pageNo, pageSize, NoticeService.TYPE_DAILY, userId);
		List<Notice> dailies = noticeService.getByPage(navigator, NoticeService.TYPE_DAILY, userId);
		
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
		Notice notice = new Notice();
		if (StringUtils.isNotEmpty(id)) {
			notice = noticeService.getById(id).getNotice();
			if(!notice.getnBuilder().equals(myself.getUserId())) {
				return "redirect:/rizhi/" + id;
			}
		} else {
			notice.setnTitle("");
			notice.setnDesc("");
		}
		model.addAttribute("daily", notice);
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
		Notice notice = new Notice();
		if (StringUtils.isNotEmpty(id)) {
			notice = noticeService.getById(id).getNotice();
			notice.setnTitle(title);
			notice.setnDesc(content);
			count = noticeService.update(notice);
		} else {
			notice.setnId(UUID.generateRandomUUID());
			notice.setnBuilder(myself.getUserId());
			notice.setnTitle(title);
			notice.setnDesc(content);
			notice.setnDatetimeBuild(DateFormater.getDateTime());
			notice.setnType(NoticeService.TYPE_DAILY);
			notice.setIsdeled(0);
			count = noticeService.save(notice);
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
		Map<String, Object> result = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(id)) {
			Notice notice = noticeService.getById(id).getNotice();
			if(notice.getnBuilder().equals(myself.getUserId()) && 1 == noticeService.delete(id)) {
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
		Resume resume = resumeService.getByUserId(myself.getUserId());
		if (resume == null) {
			resume = new Resume();
			resume.setrId(UUID.generateRandomUUID());
			resume.setrDatetimeUpdate(DateFormater.getDateTime());
			resume.setrName(myself.getUserNickname());
			resume.setuId(myself.getUserId());
			resume.setrHot(0);
			resume.setrShow(0);
			int count = resumeService.save(resume);
			resume = resumeService.getByUserId(myself.getUserId());
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
			@RequestParam(value = "sex", required = false, defaultValue = "1") String sex,
			@RequestParam(value = "age", required = false, defaultValue = "0") Integer age,
			@RequestParam(value = "height", required = false, defaultValue = "0.0") Double height,
			@RequestParam(value = "weight", required = false, defaultValue = "0.0") Double weight,
			@RequestParam(value = "college", required = false, defaultValue = "") String college,
			@RequestParam(value = "major", required = false, defaultValue = "") String major,
			@RequestParam(value = "experience", required = false, defaultValue = "") String experience,
			@RequestParam(value = "desc", required = false, defaultValue = "") String desc,
			@RequestParam(value = "imgPath", required = false, defaultValue = "") String imgPath,
			@RequestParam(value = "show", required = false, defaultValue = "0") Integer show) {
		Resume resume = resumeService.getByUserId(myself.getUserId());
		if (resume != null) {
			if (StringUtils.isEmpty(name)) {
				name = myself.getUserNickname();
			}
			resume.setrName(name);
			resume.setrSex(sex);
			resume.setrAge(age);
			resume.setrHeight(height);
			resume.setrWeight(weight);
			resume.setrCollege(college);
			resume.setrMajor(major);
			resume.setrExperience(experience);
			resume.setrProfile(desc);
			resume.setrPic(imgPath);
			resume.setrShow(show);
			int count = resumeService.update(resume);
			if (count == 1) {
				model.addAttribute("msg", "success");
				model.addAttribute("resume", resumeService.getByUserId(myself.getUserId()));
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
		model.addAttribute("myself", userService.getById(myself.getUserId()));
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
		
		//Map<String, Object> user = userService.getById(myself.get("userId").toString());
		User user = userService.getById(myself.getUserId());
		if (user != null) {
				if (StringUtils.isEmpty(nickname)) {
					//nickname = myself.get("nickname").toString();
					nickname = myself.getUserNickname();
				}
				user.setUserNickname(nickname);
				user.setQq(qq);
				user.setPhoneno(phoneno);
				user.setEmail(email);
				user.setUserDesc(userDesc);
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
			//Map<String, Object> user = userService.getById(myself.get("userId") + "");
			User user = userService.getById(myself.getUserId());
			if (user != null && user.getUserPassword().equals(MD5.getMD5Code(oldPasswd))) {
				//user.put("passwd", MD5.getMD5Code(newPasswd1));
				user.setUserPassword(MD5.getMD5Code(newPasswd1));
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
	@ModelAttribute(value  = "myself")
	public void name(HttpSession session ) {
		myself = (User) session.getAttribute("myself");
	}
	
}
