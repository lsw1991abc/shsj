/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.service.JobService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/zhaopin")
public class JobAdminController {
	
	private HashMap<String, Object> myself;

	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = { "/", "" })
	public String list(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		
		
		Map<String, Integer> navigator = jobService.getNavigator(pageNo,
				pageSize, null);

		model.addAttribute("navigator", navigator);
		model.addAttribute("jobs", jobService.getByPage(navigator, null));

		return Constants.ADMIN_PATH_NAME + "/job/list";
	}
	
	@RequestMapping(value = { "/add" })
	public String add(Model model) {
		model.addAttribute("belongs", jobService.getBelong());
		return Constants.ADMIN_PATH_NAME + "/job/add";
	}

	@RequestMapping(value = { "/save" })
	public String save(
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
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(
			ModelMap model,
			@PathVariable("id")String id) {
		return Constants.ADMIN_PATH_NAME + "/job/edit";
	}
	
	@RequestMapping(value = { "/update" })
	public String update(
			ModelMap model,
			@PathVariable("id")String id) {
		return Constants.ADMIN_PATH_NAME + "/job/edit";
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(			
			@PathVariable("id")String id) {
		int count = jobService.delete(id);
		return "redirect:/admin/zhaopin";
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
