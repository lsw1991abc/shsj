/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月22日
 */
package com.lssrc.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.NoticeCountDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("noticeCountDao")
public class NoticeCountDaoImpl extends BaseDao implements NoticeCountDao {
	
	public static String TABLE_NAME = "shsj_notice_count";
	
	public static String ID = "nc_id";
	public static String TREASURE = "n_id";
	public static String DATETIME = "nc_datetime";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TREASURE + ", "
										+ DATETIME;
	private static String INSERT_COLUMN = ID + ", "
										+ TREASURE + ", "
										+ DATETIME;
	
	private static String BASE_SELECT_SQL = "select " + ALL_COLUMN + " from " + TABLE_NAME;
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?)";

	@Override
	public int queryCount(String id) {
		String sql = "select count(*) from " + TABLE_NAME + " where n_id=?";
		return super.queryForInt(sql.toString(), new Object[]{ id });
	}

	@Override
	public int save(String id) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(id);
		contations.add(DateFormater.getDateTime());
		return super.saveOrUpdate(BASE_INSERT_SQL, contations.toArray());
	}

}
