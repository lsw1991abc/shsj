/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.lssrc.shsj.dao.DailyDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.SQLFormater;
import com.lssrc.util.UUID;
import com.lssrc.util.entity.SQL;
import com.lssrc.util.entity.SQLCondition;

/**
 * @author Carl_Li
 *
 */
@Repository("dailyDao")
public class DailyDaoImpl extends BaseDao implements DailyDao {

	public static String TABLE_NAME = "shsj_daily";
	
	public static String ID = "d_id";
	public static String TITLE = "d_title";
	public static String CONTENT = "d_content";
	public static String BUILDER = "d_builder";
	public static String DATETIME_BUILD = "d_datetime_build";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TITLE + ", "
										+ CONTENT + ", "
										+ BUILDER + ", "
										+ DATETIME_BUILD;
	private static String INSERT_COLUMN = ID + ", "
										+ TITLE + ", "
										+ CONTENT + ", "
										+ BUILDER + ", "
										+ DATETIME_BUILD;
	
	private static String BASE_SELECT_SQL = "select * from " + TABLE_NAME + ", " + UserDaoImpl.TABLE_NAME + " where d_builder=user_id ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?,?,?)";

	@Override
	public int queryCount(String userId) {
		StringBuffer sql = new StringBuffer("select count(*) from " + TABLE_NAME);
		if (StringUtils.isNotEmpty(userId)) {
			sql.append(" where " + BUILDER + "=?");
			return super.queryForInt(sql.toString(), new Object[]{ userId });
		} else {
			return super.queryForInt(sql.toString());
		}
	}

	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize, List<SQLCondition> conditions) {
		String order = DATETIME_BUILD + " desc";
		SQL sqlEntity = SQLFormater.getFormatSQL(BASE_SELECT_SQL, conditions, order);
		List<Object> values = sqlEntity.getValues();
		if (values == null) {
			values = new ArrayList<Object>();
		}
		values.add(start);
		values.add(pageSize);
		return super.queryForList(sqlEntity.getSql() + " limit ?,?", values.toArray());
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + " and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public int update(String id, String title, String content) {
		String sql = "update " + TABLE_NAME + " set " + TITLE + "=?, " + CONTENT + "=? where " + ID + "=?";
		
		List<Object> contations = new ArrayList<Object>();
		contations.add(title);
		contations.add(content);
		contations.add(id);
		
		return super.saveOrUpdate(sql, contations.toArray());
	}

	@Override
	public int save(String userId, String title, String content) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(title);
		contations.add(content);
		contations.add(userId);
		contations.add(DateFormater.getDateTime());
		return super.saveOrUpdate(BASE_INSERT_SQL, contations.toArray());
	}

	@Override
	public int delete(String id) {
		String sql = "delete from " + TABLE_NAME + " where " + ID + "=?";
		return super.delete(sql, new Object[]{ id });
	}

}
