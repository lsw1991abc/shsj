/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.dto.JobDto;
import com.lssrc.cms.service.JobService;
import com.lssrc.util.ErrorCode;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/zhaopin")
public class JobController {

	@Autowired
	private JobService jobService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping({"", "/"})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1")int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize) {
		
		Navigator navigator = jobService.getNavigator(pageNo, pageSize, JobService.TYPE_JOB);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("jobs", jobService.getByPage(navigator, JobService.TYPE_JOB));
		model.addAttribute("controller", "zhaopin");
		model.addAttribute("type", "job");
		
		return "job/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") String id) {
		JobDto job = jobService.getById(id);
		if(job != null) {
			model.addAttribute("job", job);
			model.addAttribute("type", "job");
			return "job/detail";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
}
