/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.shsj.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.shsj.dao.NoticeDao;
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
										+ DATETIME_BUILD;
	
	private static String BASE_SELECT_SQL = "select * from " + TABLE_NAME + ", " + UserDaoImpl.TABLE_NAME + " where n_builder=user_id ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?,?,?)";

	@Override
	public int queryCount() {
		String sql = "select count(*) from " + TABLE_NAME;
		return super.queryForInt(sql);
	}

	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize) {
		String sql = BASE_SELECT_SQL + "order by " + DATETIME_BUILD + " desc limit " + start + "," + pageSize;
		return super.queryForList(sql);
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + "and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public int save(String title, String content, String userId) {
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
