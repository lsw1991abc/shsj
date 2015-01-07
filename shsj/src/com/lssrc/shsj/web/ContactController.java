/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.shsj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping("/help")
public class ContactController {
	
	/**
	 * 
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "")
	public String index() {
		return "contact/about";
	}
	
	/**
	 * 
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "gywm")
	public String about() {
		return "contact/about";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 
	 * @author Carl_Li
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "activit/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	public String add() {
		return "avtivit/add";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "save")
	public String save() {
		return "redirect:/acivit/";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "detail")
	public String detail() {
		return "activit/detail";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "delete")
	public String delete() {
		return "redirect:/acivit/";
	}
	
}
