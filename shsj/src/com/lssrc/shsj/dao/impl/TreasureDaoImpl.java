/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月14日
 */
package com.lssrc.shsj.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.shsj.dao.TreasureDao;
import com.lssrc.util.BaseDao;

/**
 * @author Carl_Li
 *
 */
@Repository("treasureDao")
public class TreasureDaoImpl extends BaseDao implements TreasureDao {

	public static String TABLE_NAME = "shsj_treasure";
	
	public static String ID = "t_id";
	public static String TITLE = "t_title";
	public static String CONTENT = "t_content";
	public static String BUILDER = "t_builder";
	public static String DATETIME_BUILD = "t_datetime_build";
	
	
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
	
	private static String BASE_SELECT_SQL = "select * from " + TABLE_NAME + ", " + UserDaoImpl.TABLE_NAME + " where t_builder=user_id ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values";

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.TreasureDao#queryCount()
	 */
	@Override
	public int queryCount() {
		String sql = "select count(*) from " + TABLE_NAME;
		return super.queryForInt(sql);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.TreasureDao#queryByPage(int, int)
	 */
	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize) {
		String sql = BASE_SELECT_SQL + "order by " + DATETIME_BUILD + " desc limit " + start + "," + pageSize;
		return super.queryForList(sql);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.TreasureDao#queryById(java.lang.String)
	 */
	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + "and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

}
