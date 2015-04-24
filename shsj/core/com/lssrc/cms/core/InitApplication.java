package com.lssrc.cms.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lssrc.cms.dao.MenuMapper;

/**
 * 
 * @author Carl_Li
 *
 */
public class InitApplication implements ServletContextListener {

	private static WebApplicationContext webApplicationContext;
	private static ApplicationContextHelper helper = new ApplicationContextHelper();
	
	private MenuMapper menuMapper;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		helper.setApplicationContext(webApplicationContext);
		menuMapper = webApplicationContext.getBean(MenuMapper.class);
		context.setAttribute("menus", menuMapper.selectByPage());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}