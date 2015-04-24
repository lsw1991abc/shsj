/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月10日
 */
package com.lssrc.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lssrc.cms.service.MenuService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping({"", "/"})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("menus", menuService.list());
		return "";
	}
	
}
