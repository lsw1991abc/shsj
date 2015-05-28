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
import com.lssrc.cms.entity.Menu;
import com.lssrc.cms.service.MenuService;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/menu")
public class MenuAdminController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = {"/", ""})
	public String index(Model model) {
		model.addAttribute("menus", menuService.getByPage());
		return Constants.ADMIN_PATH_NAME + "/menu/list";
	}
	
	@RequestMapping(value = {"/add"})
	public String add() {
		return Constants.ADMIN_PATH_NAME + "/menu/edit";
	}
	
	@RequestMapping(value = {"/edit/{id}"})
	public String edit(
			Model model,
			@PathVariable("id") String id) {
		model.addAttribute("menu", menuService.getById(id));
		return Constants.ADMIN_PATH_NAME + "/menu/edit";
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
		
		Menu menu = new Menu();
		if (StringUtils.isEmpty(id)) {
			menu.setMenuId(UUID.generateRandomUUID());
		} else {
			menu = menuService.getById(id);
		}
		
		menu.setMenuName(name);
		menu.setMenuParent("0");
		menu.setMenuSort(sort);
		menu.setMenuTarget(target);
		menu.setMenuType(type);
		menu.setMenuUrl(url);
		
		if (StringUtils.isEmpty(id)) {
			menuService.save(menu);
		} else {
			menuService.update(menu);
		}
		
		ServletContext context = request.getSession().getServletContext();
		context.setAttribute("menus", menuService.getByPage());
		return "redirect:/" + Constants.ADMIN_PATH_NAME + "/menu";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(HttpServletRequest request, 
			@PathVariable("id") String id) {
		int i = menuService.delete(id);
		ServletContext context = request.getSession().getServletContext();
		context.setAttribute("menus", menuService.getByPage());
		return "redirect:/" + Constants.ADMIN_PATH_NAME + "/menu";
	}
	
}
