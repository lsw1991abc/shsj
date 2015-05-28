/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月13日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.lssrc.cms.service.ActivitService;
import com.lssrc.cms.service.JobService;
import com.lssrc.cms.service.NoticeService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(value = {"/baoxiang"})
public class BxController {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ActivitService activitService;
	
	@RequestMapping({"", "/", "/index"})
	public String index(HttpServletRequest request, HttpServletResponse response, SessionStatus session, Model model) {
		model.addAttribute("notices", noticeService.getByTop(10, NoticeService.TYPE_NOTICE));
		
		model.addAttribute("jobs", jobService.getByTop(10, JobService.TYPE_JOB));
		
		model.addAttribute("partTimes", jobService.getByTop(10, JobService.TYPE_PARTTIME));
		
		model.addAttribute("activits", activitService.getByTop(10));
		
		model.addAttribute("dailies", noticeService.getByTop(10, NoticeService.TYPE_DAILY));
		
		model.addAttribute("treasures", noticeService.getByTop(10, NoticeService.TYPE_TREASURE));
		
		return "baoxiang/index";
	}
	
}
