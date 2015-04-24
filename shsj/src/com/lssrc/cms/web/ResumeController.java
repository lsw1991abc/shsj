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

import com.lssrc.cms.entity.Resume;
import com.lssrc.cms.service.ResumeService;
import com.lssrc.util.ErrorCode;
import com.lssrc.util.Navigator;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/rencai")
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	

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
		
		Navigator navigator = resumeService.getNavigator(pageNo, pageSize);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("resumes", resumeService.getByPage(navigator));
		
		return "resume/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") String id) {
		Resume resume = resumeService.getById(id);
		if(resume != null) {
			model.addAttribute("resume", resume);
			return "resume/detail";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}

}
