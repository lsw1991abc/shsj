/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月8日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lssrc.cms.service.LinkService;
import com.lssrc.cms.service.NoticeService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/xiaoyuan")
public class SchoolController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private LinkService linkService;
	
	/**
	 * 信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping({"", "/"})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		model.addAttribute("notices", noticeService.getByTop(5, NoticeService.TYPE_NOTICE));
		model.addAttribute("treasures", noticeService.getByTop(5, NoticeService.TYPE_TREASURE));
		model.addAttribute("sites", linkService.getByPage(LinkService.TYPE_SITE));
		
		return "school/index";
	}	
	
}
