/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.cms.web.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lssrc.cms.common.Constants;
import com.lssrc.cms.dto.DailyDto;
import com.lssrc.cms.service.DailyService;
import com.lssrc.util.ErrorCode;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(Constants.ADMIN_PATH + "/rizhi")
public class DailyAdminController {
	
	@Autowired
	private DailyService dailyService;
	
}
