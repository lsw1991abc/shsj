/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
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
@RequestMapping("/baodian")
public class TreasureController {
	
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
		
		Map<String, Integer> navigator = noticeService.getNavigator(pageNo, pageSize, NoticeDao.TREASURE);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("treasures", noticeService.getByPage(navigator, NoticeDao.TREASURE));
		
		return "treasure/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") String id) {
		NoticeDto treasure = noticeService.getById(id);
		if(treasure != null) {
			model.addAttribute("treasure", treasure);
			return "treasure/detail";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
}