/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.cms.web;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl_Li
 *
 */
@Controller
@RequestMapping(value = "/front")
public class FrontController {

	@RequestMapping(value = {"/{fm}/{sm}"})
	public String index(
			@PathVariable("fm") String fm,
			@PathVariable("sm") String sm) {
		if (StringUtils.isEmpty(fm)) {
			return "";
		}
		return "";
	}
	
}
