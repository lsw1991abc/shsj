/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.dao.NoticeDao;
import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.ErrorCode;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/gonggao")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
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
		
		Map<String, Integer> navigator = noticeService.getNavigator(pageNo, pageSize, NoticeDao.NOTICE);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator, NoticeDao.NOTICE));
		
		return "notice/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") String id) {
		NoticeDto noticeDto = noticeService.getById(id);
		if(noticeDto != null) {
			model.addAttribute("notice", noticeDto);
			return "notice/detail";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
}
