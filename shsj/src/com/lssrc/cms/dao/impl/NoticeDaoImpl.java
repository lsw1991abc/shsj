/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.NoticeDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("noticeDao")
public class NoticeDaoImpl extends BaseDao implements NoticeDao {
	
	public static String TABLE_NAME = "shsj_notice";
	
	public static String ID = "n_id";
	public static String TITLE = "n_title";
	public static String DESC = "n_desc";
	public static String BUILDER = "n_builder";
	public static String TYPE = "n_type";
	public static String DATETIME_BUILD = "n_datetime_build";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ BUILDER + ", "
										+ DATETIME_BUILD;
	private static String INSERT_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ BUILDER + ", "
										+ TYPE + ", "
										+ DATETIME_BUILD;
	
	private static String BASE_SELECT_SQL = "select * from " + TABLE_NAME + ", " + UserDaoImpl.TABLE_NAME + " where n_builder=user_id ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?,?,?,?)";

	@Override
	public int queryCount(int type) {
		String sql = "select count(*) from " + TABLE_NAME + " where n_type=? and isdeled=0";
		return super.queryForInt(sql, new Object[]{type});
	}

	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize, int type) {
		String sql = BASE_SELECT_SQL + " and n_type=? and isdeled=0 order by " + DATETIME_BUILD + " desc limit ?,?";
		return super.queryForList(sql, new Object[]{ type, start, pageSize});
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + "and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public int save(String title, String content, String userId, int type) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(title);
		contations.add(content);
		contations.add(userId);
		contations.add(type);
		contations.add(DateFormater.getDateTime());
		return super.saveOrUpdate(BASE_INSERT_SQL, contations.toArray());
	}
	
	@Override
	public int update(String id, String title, String content, String userId) {
		String sql = "update shsj_notice set n_title=?, n_desc=?, n_builder=? where n_id=?";
		List<Object> contations = new ArrayList<Object>();
		contations.add(title);
		contations.add(content);
		contations.add(userId);
		contations.add(id);
		return super.saveOrUpdate(sql, contations.toArray());
	}

	@Override
	public int delete(String id) {
		String sql = "update shsj_notice set isdeled=1 where n_id=?";
		return super.saveOrUpdate(sql, new Object[]{ id });
	}

}