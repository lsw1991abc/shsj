package com.lssrc.cms.core;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lssrc.cms.dao.LinkMapper;
import com.lssrc.cms.dao.MenuMapper;
import com.lssrc.cms.dao.OptionMapper;
import com.lssrc.cms.entity.Link;
import com.lssrc.cms.entity.Option;
import com.lssrc.cms.service.LinkService;

/**
 * 
 * @author Carl_Li
 *
 */
public class InitApplication implements ServletContextListener {

	private static WebApplicationContext webApplicationContext;
	private static ApplicationContextHelper helper = new ApplicationContextHelper();
	
	private OptionMapper optionMapper;
	private MenuMapper menuMapper;
	private LinkMapper linkMapper;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		helper.setApplicationContext(webApplicationContext);
		
		optionMapper = webApplicationContext.getBean(OptionMapper.class);
		menuMapper = webApplicationContext.getBean(MenuMapper.class);
		linkMapper = webApplicationContext.getBean(LinkMapper.class);
		
		List<Option> options = optionMapper.selectByPage();
		for (Option option : options) {
			context.setAttribute(option.getoKey(), option.getoValue());
		}
		context.setAttribute("menus", menuMapper.selectByPage());
		context.setAttribute("friendlinks", linkMapper.selectByType(LinkService.TYPE_FRIEND));
		context.setAttribute("copyrightlinks", linkMapper.selectByType(LinkService.TYPE_COPYRIGHT));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}