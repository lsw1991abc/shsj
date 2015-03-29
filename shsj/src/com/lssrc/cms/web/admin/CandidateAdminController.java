/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.web.admin;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.service.CandidateService;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/qiuzhi")
public class CandidateAdminController {
	
	private HashMap<String, Object> myself;

	@Autowired
	private CandidateService candidateService;
	
	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}
	
}
