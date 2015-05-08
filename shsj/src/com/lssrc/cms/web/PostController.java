/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.entity.Notice;
import com.lssrc.cms.entity.NoticeComment;
import com.lssrc.cms.entity.User;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.DateFormater;
import com.lssrc.util.ErrorCode;
import com.lssrc.util.Navigator;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/tieba")
public class PostController {
	
	@Autowired
	private NoticeService noticeService;
	
	private User myself;
	
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
	public String list(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1")int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize) {
		
		Navigator navigator = noticeService.getNavigator(pageNo, pageSize, NoticeService.TYPE_POST, null);
		
		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator, NoticeService.TYPE_POST, null));
		
		return "post/list";
	}
	
	/**
	 * 获取详情
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "/{id}")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") String id) {
		NoticeDto noticeDto = noticeService.getById(id);
		if(noticeDto != null) {
			model.addAttribute("notice", noticeDto);
			return "post/detail";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
	@RequestMapping(value = "/{id}/comment")
	public String comment(
			Model model,
			@PathVariable("id") String id,
			@RequestParam(value = "page", required = false, defaultValue = "1")int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize) {
		Navigator navigator = noticeService.getNavigatorComment(pageNo, pageSize, NoticeService.TYPE_POST, id);
		model.addAttribute("navigator", navigator);
		model.addAttribute("noticeComments", noticeService.getCommentByNotice(navigator, NoticeService.TYPE_POST, id));
		return "";
	}
	
	@RequestMapping(value = "/{id}/comment/save")
	public String commentSave(
			Model model,
			@RequestParam(value = "id", required = false, defaultValue = "") String nId,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		if (StringUtils.isEmpty(nId) || myself == null) {
			model.addAttribute("message", "error");
		} else {
			NoticeComment comment = new NoticeComment();
			comment.setNcBuilder(myself.getUserId());
			comment.setNcContent(content);
			comment.setNcDatetime(DateFormater.getDateTime());
			comment.setNcId(UUID.generateRandomUUID());
			comment.setnId(nId);
			noticeService.saveComment(comment);
			model.addAttribute("message", "success");
		}
		return "";
	}
	
	@RequestMapping(value = {"/save"})
	public String save(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		
		if (myself != null) {
			Notice notice = new Notice();
			notice.setnId(UUID.generateRandomUUID());
			notice.setnBuilder(myself.getUserId());
			notice.setnTitle(title);
			notice.setnDesc(content);
			notice.setnDatetimeBuild(DateFormater.getDateTime());
			notice.setnType(NoticeService.TYPE_POST);
			noticeService.save(notice);
			return "redirect:/tieba";
		} else {
			return "redirect:/login";
		}
	}
	
	/**
	 * 获取当前session
	 * @param session
	 */
	@ModelAttribute(value  = "myself")
	public void name(HttpSession session ) {
		myself = (User) session.getAttribute("myself");
	}
	
}
