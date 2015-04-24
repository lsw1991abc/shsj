/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.cms.web.admin;

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
import org.springframework.web.multipart.MultipartFile;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dto.ActivitDto;
import com.lssrc.cms.dto.FileInfoDto;
import com.lssrc.cms.entity.Activit;
import com.lssrc.cms.entity.User;
import com.lssrc.cms.service.ActivitService;
import com.lssrc.util.DateFormater;
import com.lssrc.util.ErrorCode;
import com.lssrc.util.FileUtils;
import com.lssrc.util.Navigator;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/huodong")
public class ActivitAdminController {
	
	private User myself;
	
	@Autowired
	private ActivitService activitService;
	
	@RequestMapping(value = { "/", "" })
	public String list(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		Navigator navigator = activitService.getNavigator(pageNo, pageSize);
		model.addAttribute("navigator", navigator);
		model.addAttribute("activits", activitService.getByPage(navigator));

		return Constants.ADMIN_PATH_NAME + "/activit/list";
	}
	
	@RequestMapping(value = { "/add" })
	public String add(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) {
		model.addAttribute("status", activitService.getStatus());
		return Constants.ADMIN_PATH_NAME + "/activit/add";
	}

	@RequestMapping(value = { "/save" })
	public String save(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "organizer", required = false, defaultValue = "") String organizer,
			@RequestParam(value = "plotter", required = false, defaultValue = "") String plotter,
			@RequestParam(value = "number", required = false, defaultValue = "") Integer number,
			@RequestParam(value = "statu", required = false, defaultValue = "") Integer statu,
			@RequestParam(value = "datetime-start", required = false, defaultValue = "") String dateTimeStart,
			@RequestParam(value = "datetime-end", required = false, defaultValue = "") String dateTimeEnd,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "imgPath", required = false, defaultValue = "")String imgPath) {
		Activit activit = new Activit();
		if (StringUtils.isEmpty(id)) {
			activit.setaId(UUID.generateRandomUUID());
		} else {
			activit = activitService.getById(id).getActivit();
		}
		
		activit.setaTitle(title);
		activit.setaOrganizer(organizer);
		activit.setaPlotter(plotter);
		activit.setaNumber(number);
		activit.setaStatu(statu);
		activit.setaDatetimeStart(dateTimeStart);
		activit.setaDatetimeEnd(dateTimeEnd);
		activit.setaDesc(content);
		activit.setaPic(imgPath);
		activit.setaBuilder(myself.getUserId());
		
		if (StringUtils.isEmpty(id)) {
			activit.setaDatetimeBuild(DateFormater.getDateTime());
			int count = activitService.save(activit);
		} else {
			int count = activitService.update(activit);
		}
		
		return "redirect:/admin/huodong";
	}
	
	@RequestMapping(value = { "/edit/{id}" })
	public String edit(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@PathVariable("id")String id) {
		model.addAttribute("status", activitService.getStatus());
		ActivitDto activitDto = activitService.getById(id);
		if(activitDto != null) {
			model.addAttribute("activit", activitDto);
			return Constants.ADMIN_PATH_NAME + "/activit/edit";
		} else {
			return ErrorCode.OBJECT_NOT_FOUND;
		}
		
	}
	
	@RequestMapping(value = { "/img" })
	public FileInfoDto img(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		String path = "images/activit";
		String url = FileUtils.save(request, file, path);
		if (url != null) {
			return new FileInfoDto("success", url);
		} else {
			return new FileInfoDto("error", null);
		}
	}
	
	@RequestMapping(value = { "/delete/{id}" })
	public String delete(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@PathVariable("id")String id) {
		int count = activitService.delete(id);
		return "redirect:/admin/huodong";
	}
	
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (User) session.getAttribute("myself");
	}
	
}
