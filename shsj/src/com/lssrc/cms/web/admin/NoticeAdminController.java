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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dao.NoticeDao;
import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.ErrorCode;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/gonggao")
public class NoticeAdminController {
	
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
		Map<String, Integer> navigator = noticeService.getNavigator(pageNo, pageSize, NoticeDao.NOTICE);

		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator, NoticeDao.NOTICE));
		return Constants.ADMIN_PATH_NAME + "/notice/list";
	}
	
	@RequestMapping(value = { "/add" })
	public String add() {
		return Constants.ADMIN_PATH_NAME + "/notice/add";
	}

	@RequestMapping(value = { "/save" })
	public String save(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		String userId = myself.get("userId") + "";
		if (StringUtils.isEmpty(id)) {
			noticeService.save(title, content, userId, NoticeDao.NOTICE);
		} else {
			noticeService.update(id, title, content, userId);
		}
		return "redirect:/admin/gonggao";
	}
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(
			ModelMap model,
			@PathVariable("id")String id) {
		NoticeDto noticeDto = noticeService.getById(id);
		if(noticeDto != null) {
			model.addAttribute("notice", noticeDto.getNotice());
			return Constants.ADMIN_PATH_NAME + "/notice/edit";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@PathVariable("id")String id) {
		int count = noticeService.delete(id);
		return "redirect:/admin/gonggao";
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
