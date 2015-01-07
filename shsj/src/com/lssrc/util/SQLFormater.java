/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月18日
 */
package com.lssrc.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lssrc.util.entity.SQL;
import com.lssrc.util.entity.SQLCondition;

/**
 * @author Carl_Li
 *
 */
public class SQLFormater {

	private static final String SQLENCODE = " escape '\\' ";
		
	/**
	 * 
	 * @param sql
	 * @param conditions
	 * @param sqlorder
	 * @return SQL
	 */
	public static SQL getFormatSQL(String sql, List<SQLCondition> conditions, String sqlorder) {
		StringBuilder sqlBuilder = new StringBuilder(150);
		sqlBuilder.append(sql);
		if (conditions == null) {
			if (StringUtils.isNotEmpty(sqlorder)) {
	        	sqlBuilder.append("ORDER BY " + sqlorder);
			}
			return new SQL(sqlBuilder.toString(), null);
		} else {
	        List<Object> values = new ArrayList<Object>();
	        for (SQLCondition sqlCondition : conditions) {
	            String con = sqlCondition.getCondition();
	            sqlBuilder.append("and ").append(sqlCondition.getColName()).append(' ').append(con).append(" ? ");
	            if ("like".equals(con.toLowerCase())) {
	                values.add("%" + sqlCondition.getValue().replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_") + "%");
	                sqlBuilder.append(SQLENCODE);
	            } else {
	                values.add(sqlCondition.getValue());
	            }
	        }
	        if (StringUtils.isNotEmpty(sqlorder)) {
	        	sqlBuilder.append("ORDER BY " + sqlorder);
			}
	        return new SQL(sqlBuilder.toString(), values);
		}
	}
	
}
