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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dao.NoticeDao;
import com.lssrc.cms.service.NoticeService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/baodian")
public class TreasureAdminController {
	
	private HashMap<String, Object> myself;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = { "/", "" })
	public String list(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Map<String, Integer> navigator = noticeService.getNavigator(pageNo, pageSize, NoticeDao.TREASURE);

		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator, NoticeDao.TREASURE));
		
		return Constants.ADMIN_PATH_NAME + "/treasure/list";
	}
	
	@RequestMapping(value = { "/add" })
	public String add() {
		return Constants.ADMIN_PATH_NAME + "/treasure/add";
	}

	@RequestMapping(value = { "/save" })
	public String save(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		String userId = myself.get("userId") + "";
		noticeService.save(title, content, userId, NoticeDao.TREASURE);
		return "redirect:/admin/baodian";
	}
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(
			ModelMap model,
			@PathVariable("id")String id) {
		return Constants.ADMIN_PATH_NAME + "/treasure/edit";
	}
	
	@RequestMapping(value = { "/update" })
	public String update(
			ModelMap model,
			@PathVariable("id")String id) {
		return Constants.ADMIN_PATH_NAME + "/treasure/edit";
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@PathVariable("id")String id) {
		int count = noticeService.delete(id);
		return "redirect:/admin/baodian";
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
