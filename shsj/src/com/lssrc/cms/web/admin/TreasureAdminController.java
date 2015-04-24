/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web.admin;

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
import com.lssrc.cms.dto.NoticeDto;
import com.lssrc.cms.entity.Notice;
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
@RequestMapping(Constants.ADMIN_PATH + "/baodian")
public class TreasureAdminController {
	
	private User myself;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = { "/", "" })
	public String list(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		Navigator navigator = noticeService.getNavigator(pageNo, pageSize, NoticeService.TYPE_TREASURE, null);

		model.addAttribute("navigator", navigator);
		model.addAttribute("notices", noticeService.getByPage(navigator, NoticeService.TYPE_TREASURE, null));
		
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
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "content", required = false, defaultValue = "") String content) {
		Notice notice = new Notice();
		if (StringUtils.isEmpty(id)) {
			notice.setnId(UUID.generateRandomUUID());
		} else {
			notice = noticeService.getById(id).getNotice();
		}
		notice.setnTitle(title);
		notice.setnDesc(content);
		if (StringUtils.isEmpty(id)) {
			notice.setnDatetimeBuild(DateFormater.getDateTime());
			notice.setnBuilder(myself.getUserId());
			notice.setnType(NoticeService.TYPE_TREASURE);
			noticeService.save(notice);
		} else {
			noticeService.update(notice);
		}
		return "redirect:/admin/baodian";
	}
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(ModelMap model,
			@PathVariable("id")String id) {
		NoticeDto noticeDto = noticeService.getById(id);
		if(noticeDto != null) {
			model.addAttribute("treasure", noticeDto.getNotice());
			return Constants.ADMIN_PATH_NAME + "/treasure/edit";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(@PathVariable("id")String id) {
		int count = noticeService.delete(id);
		return "redirect:/admin/baodian";
	}
	
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (User) session.getAttribute("myself");
	}
	
}
