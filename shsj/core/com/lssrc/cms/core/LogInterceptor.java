/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月4日
 */
package com.lssrc.cms.core;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Carl_Li
 *
 */
public class LogInterceptor {

	private Logger logger = Logger.getLogger(LogInterceptor.class);
	
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		StringBuffer msg = new StringBuffer();
		try {
			Object result = joinPoint.proceed();
			return result;
		} catch (Exception e) {
			msg.append("开始方法：");
			msg.append(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() ");
			msg.append("错误信息如下：[ " + e.getMessage() + " ]");
			logger.error(msg.toString());
		}
		return "500";
	}
}
