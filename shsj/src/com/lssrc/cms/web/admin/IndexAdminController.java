/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月17日
 */
package com.lssrc.cms.web.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.lssrc.cms.dto.FileInfoDto;
import com.lssrc.cms.service.ActivitService;
import com.lssrc.cms.service.JobService;
import com.lssrc.cms.service.NoticeService;
import com.lssrc.util.FileUtils;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH)
public class IndexAdminController {

	private HashMap<String, Object> myself;


	@RequestMapping(value = { "/", "" })
	public String index() {
		return "admin/index";
	}

	@SuppressWarnings("unchecked")
	@ModelAttribute(value = "myself")
	public void name(HttpSession session) {
		myself = (HashMap<String, Object>) session.getAttribute("myself");
	}

}
