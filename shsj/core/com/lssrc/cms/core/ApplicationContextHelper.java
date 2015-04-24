/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年4月12日
 */
package com.lssrc.cms.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Carl_Li
 *
 */
public class ApplicationContextHelper implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		ApplicationContextHelper.context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}

}