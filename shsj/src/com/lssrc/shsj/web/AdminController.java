/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月17日
 */
package com.lssrc.shsj.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lssrc.shsj.dto.FileInfoDto;
import com.lssrc.shsj.service.ActivitService;
import com.lssrc.shsj.service.JobService;
import com.lssrc.shsj.service.NoticeService;
import com.lssrc.shsj.service.UserService;
import com.lssrc.util.FileUtils;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private HashMap<String, Object> myself;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private JobService jobService;

	@Autowired
	private ActivitService activitService;

	@RequestMapping(value = { "/", "" })
	public String index() {
		return "admin/index";
	}

	@RequestMapping(value = { "/gonggao", "/gonggao/" })
	public String notice(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Map<String, Integer> navigator = noticeService.getNavigator(pageNo,
				pageSize);

		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator));
		return "admin/notice";
	}

	@RequestMapping(value = { "/gonggao/save" })
	public String noticeSave(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		String userId = myself.get("userId") + "";
		noticeService.save(title, content, userId);
		return "redirect:/admin/gonggao";
	}
	
	@RequestMapping(value = { "/gonggao/delete/{id}" })
	public String noticeDelete(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@PathVariable("id")String id) {
		int count = noticeService.delete(id);
		return "redirect:/admin/gonggao";
	}

	@RequestMapping(value = { "/zhaopin", "/zhaopin/" })
	public String job(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		model.addAttribute("belongs", jobService.getBelong());
		
		Map<String, Integer> navigator = jobService.getNavigator(pageNo,
				pageSize, null);

		model.addAttribute("navigator", navigator);
		model.addAttribute("jobs", jobService.getByPage(navigator, null));

		return "admin/job";
	}

	@RequestMapping(value = { "/zhaopin/save" })
	public String jobSave(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "organnizer", required = true) String organnizer,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "place", required = true) String place,
			@RequestParam(value = "salary", required = false, defaultValue = "0") String salary,
			@RequestParam(value = "datetime-work", required = false, defaultValue = "") String datetimeWork,
			@RequestParam(value = "number", required = false, defaultValue = "0") int number,
			@RequestParam(value = "number-limit", required = false, defaultValue = "0") int numberLimit,
			@RequestParam(value = "contact", required = false, defaultValue = "") String contact,
			@RequestParam(value = "datetime-start", required = false, defaultValue = "") String datetimeStart,
			@RequestParam(value = "datetime-end", required = false, defaultValue = "") String datetimeEnd,
			@RequestParam(value = "audition-place", required = false, defaultValue = "") String auditionPlace,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "belong", required = true) String belong) {

		String userId = myself.get("userId") + "";
		int count = jobService.save(organnizer, title, type, place, salary,
				datetimeWork, number, numberLimit, contact, datetimeStart,
				datetimeEnd, auditionPlace, content, belong, userId);

		return "redirect:/admin/zhaopin";
	}
	
	@RequestMapping(value = { "/zhaopin/delete/{id}" })
	public String jobDelete(			
			@PathVariable("id")String id) {
		int count = jobService.delete(id);
		return "redirect:/admin/zhaopin";
	}

	@RequestMapping(value = { "/huodong", "/huodong/" })
	public String activit(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		Map<String, Integer> navigator = activitService.getNavigator(pageNo,
				pageSize);

		model.addAttribute("navigator", navigator);
		model.addAttribute("activits", activitService.getByPage(navigator));
		
		model.addAttribute("status", activitService.getStatus());

		return "admin/activit";
	}

	@RequestMapping(value = { "/huodong/save" })
	public String activitSave(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "organizer", required = false, defaultValue = "") String organizer,
			@RequestParam(value = "plotter", required = false, defaultValue = "") String plotter,
			@RequestParam(value = "number", required = false, defaultValue = "") String number,
			@RequestParam(value = "statu", required = false, defaultValue = "") String statu,
			@RequestParam(value = "datetime-start", required = false, defaultValue = "") String dateTimeStart,
			@RequestParam(value = "datetime-end", required = false, defaultValue = "") String dateTimeEnd,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "imgPath", required = false, defaultValue = "#")String imgPath) {
		String userId = myself.get("userId") + "";
		
		int count = activitService.save(title, organizer, plotter, number, statu, dateTimeStart, dateTimeEnd, content, imgPath, userId);
		return "redirect:/admin/huodong";
	}
	
	@RequestMapping(value = { "/huodong/img" })
	public FileInfoDto activitImg(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		String path = "/images/activit";
		String url = FileUtils.save(request, file, path);
		if (url != null) {
			return new FileInfoDto("success", url);
		} else {
			return new FileInfoDto("error", null);
		}
	}
	
	@RequestMapping(value = { "/huodong/delete/{id}" })
	public String activitDelete(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@PathVariable("id")String id) {
		int count = activitService.delete(id);
		return "redirect:/admin/huodong";
	}

	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}

}
