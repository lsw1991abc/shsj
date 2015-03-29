/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.CandidateDao;
import com.lssrc.util.BaseDao;

/**
 * @author Carl_Li
 *
 */
@Repository("candidateDao")
public class CandidateDaoImpl extends BaseDao implements CandidateDao {
	
	public static String TABLE_NAME = "shsj_candidate";
	
	public static String ID = "c_id";
	public static String TITLE = "c_title";
	public static String DESC = "c_desc";
	public static String TYPE = "c_type";
	public static String BELONG = "c_belong";
	public static String BUILDER = "c_builder";
	public static String DATETIME_BUILD = "c_datetime_build";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ TYPE + ", "
										+ BELONG + ", "
										+ BUILDER + ", "
										+ DATETIME_BUILD;
	private static String INSERT_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ TYPE + ", "
										+ BELONG + ", "
										+ BUILDER + ", "
										+ DATETIME_BUILD;
	
	private static String BASE_SELECT_SQL = "select " + ALL_COLUMN + " from " + TABLE_NAME + " where 1=1 ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values";
	
	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.CandidateDao#queryCount()
	 */
	@Override
	public int queryCount() {
		String sql = "select count(*) from " + TABLE_NAME;
		return super.queryForInt(sql);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.CandidateDao#queryByPage(int, int)
	 */
	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize) {
		String sql = BASE_SELECT_SQL + "order by " + DATETIME_BUILD + " desc limit " + start + "," + pageSize;
		return super.queryForList(sql);
	}

	/* (non-Javadoc)
	 * @see com.lssrc.shsj.dao.CandidateDao#queryById(java.lang.String)
	 */
	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + "and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

}
