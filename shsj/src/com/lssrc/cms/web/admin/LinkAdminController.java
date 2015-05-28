/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月22日
 */
package com.lssrc.cms.web.admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.entity.Link;
import com.lssrc.cms.service.LinkService;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/link")
public class LinkAdminController {

	@Autowired
	private LinkService linkService;
	
	@RequestMapping(value = {"/", ""})
	public String index(Model model) {
		model.addAttribute("links", linkService.getAll());
		return Constants.ADMIN_PATH_NAME + "/link/list";
	}
	
	@RequestMapping(value = {"/add"})
	public String add() {
		return Constants.ADMIN_PATH_NAME + "/link/edit";
	}
	
	@RequestMapping(value = {"/edit/{id}"})
	public String edit(
			Model model,
			@PathVariable("id") String id) {
		model.addAttribute("link", linkService.getById(id));
		return Constants.ADMIN_PATH_NAME + "/link/edit";
	}
	
	@RequestMapping(value = {"/save", "/update"})
	public String update(
			HttpServletRequest request,
			@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "name", required = false, defaultValue = "标题") String name,
			@RequestParam(value = "url", required = false, defaultValue = "#") String url,
			@RequestParam(value = "target", required = false, defaultValue = "_self") String target,
			@RequestParam(value = "type", required = false, defaultValue = "1") int type,
			@RequestParam(value = "sort", required = false, defaultValue = "1") int sort) {
		
		Link link = new Link();
		if (StringUtils.isEmpty(id)) {
			link.setlId(UUID.generateRandomUUID());
		} else {
			link = linkService.getById(id);
		}
		
		link.setlName(name);
		link.setlParent("0");
		link.setlSort(sort);
		link.setlTarget(target);
		link.setlType(type);
		link.setlUrl(url);
		
		if (StringUtils.isEmpty(id)) {
			linkService.save(link);
		} else {
			linkService.update(link);
		}
		
		ServletContext context = request.getSession().getServletContext();
		switch (type) {
			case LinkService.TYPE_FRIEND:
				context.setAttribute("friendlinks", linkService.getByType(LinkService.TYPE_FRIEND));
				break;
			case LinkService.TYPE_COPYRIGHT:
				context.setAttribute("copyrightlinks", linkService.getByType(LinkService.TYPE_COPYRIGHT));
				break;
		}
		return "redirect:/" + Constants.ADMIN_PATH_NAME + "/link";
	}
	
}
