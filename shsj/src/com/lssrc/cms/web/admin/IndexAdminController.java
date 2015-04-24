/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月17日
 */
package com.lssrc.cms.web.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.entity.User;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH)
public class IndexAdminController {

	private User myself;

	@RequestMapping(value = { "/", "" })
	public String index() {
		return "admin/index";
	}

	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (User) session.getAttribute("myself");
	}

}
