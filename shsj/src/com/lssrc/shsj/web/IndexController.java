/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.shsj.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.lssrc.shsj.service.ActivitService;
import com.lssrc.shsj.service.DailyService;
import com.lssrc.shsj.service.JobService;
import com.lssrc.shsj.service.NoticeService;
import com.lssrc.shsj.service.TreasureService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ActivitService activitService;
	
	@Autowired
	private DailyService dailyService;
	
	@Autowired
	private TreasureService treasureService;

	@RequestMapping({"", "/", "/index"})
	public String index(HttpServletRequest request, HttpServletResponse response, SessionStatus session, Model model) {
		List<Map<String, Object>> notices = noticeService.getByTop(10);
		model.addAttribute("notices", notices);
		
		List<Map<String, Object>> jobs = jobService.getByTop(10, "1");
		model.addAttribute("jobs", jobs);
		
		List<Map<String, Object>> partTimes = jobService.getByTop(10, "2");
		model.addAttribute("partTimes", partTimes);
		
		List<Map<String, Object>> activits = activitService.getByTop(10);
		model.addAttribute("activits", activits);
		
		List<Map<String, Object>> dailies = dailyService.getByTop(10);
		model.addAttribute("dailies", dailies);
		
		List<Map<String, Object>> treasures = treasureService.getByTop(10);
		model.addAttribute("treasures", treasures);
		
		return "index";
	}
	
}
