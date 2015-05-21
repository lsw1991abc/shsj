package com.lssrc.cms.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lssrc.cms.dao.LinkMapper;
import com.lssrc.cms.dao.MenuMapper;
import com.lssrc.cms.service.LinkService;

/**
 * 
 * @author Carl_Li
 *
 */
public class InitApplication implements ServletContextListener {

	private static WebApplicationContext webApplicationContext;
	private static ApplicationContextHelper helper = new ApplicationContextHelper();
	
	private MenuMapper menuMapper;
	private LinkMapper linkMapper;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		helper.setApplicationContext(webApplicationContext);
		
		menuMapper = webApplicationContext.getBean(MenuMapper.class);
		linkMapper = webApplicationContext.getBean(LinkMapper.class);
		
		context.setAttribute("menus", menuMapper.selectByPage());
		context.setAttribute("friendlinks", linkMapper.selectByPage(LinkService.TYPE_FRIEND));
		context.setAttribute("copyrightlinks", linkMapper.selectByPage(LinkService.TYPE_COPYRIGHT));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}