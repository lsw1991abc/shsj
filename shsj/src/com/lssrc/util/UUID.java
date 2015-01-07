/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.util;

/**
 * @author Carl_Li
 *
 */
public class UUID {

	/**
	 * 
	 * @return
	 */
	public static String generateRandomUUID() {
		String uuid = java.util.UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
}
