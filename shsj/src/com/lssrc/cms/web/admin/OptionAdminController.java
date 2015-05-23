/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月22日
 */
package com.lssrc.cms.web.admin;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.entity.Option;
import com.lssrc.cms.service.OptionService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/setting")
public class OptionAdminController {

	@Autowired
	private OptionService optionService;
	
	@RequestMapping(value = {"/", ""})
	public String index(Model model) {
		model.addAttribute("options", optionService.get());
		return Constants.ADMIN_PATH_NAME + "/option/index";
	}
	
	@RequestMapping(value = {"/update"})
	public String update(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> attrs = request.getParameterNames();
		ServletContext context = request.getSession().getServletContext();
		Option option = null;
		for (Enumeration<String> enumeration = attrs; enumeration.hasMoreElements();) {
			String paraName = enumeration.nextElement().toString();
			option = optionService.getByKey(paraName);
			option.setoValue(request.getParameter(paraName));
			optionService.updateByPrimaryKey(option);
			
			context.setAttribute(paraName, option.getoValue());
			
		}
		return "redirect:" + Constants.ADMIN_PATH + "/setting";
	}
	
}
