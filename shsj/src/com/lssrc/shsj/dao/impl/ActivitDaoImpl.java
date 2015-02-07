/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.shsj.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.shsj.dao.ActivitDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("activitDao")
public class ActivitDaoImpl extends BaseDao implements ActivitDao {

	public static String TABLE_NAME = "shsj_activit";
	public static String TABLE_NAME_STATU = "shsj_activit_statu";
	
	public static String ID = "a_id";
	public static String TITLE = "a_title";
	public static String DESC = "a_desc";
	public static String ORGANIZER = "a_organizer";
	public static String PLOTTER = "a_plotter";
	public static String NUMBER = "a_number";
	public static String DATETIME_START = "a_datetime_start";
	public static String DATETIME_END = "a_datetime_end";
	public static String STATU = "as_name";
	public static String BUILDER = "a_builder";
	public static String PIC = "a_pic";
	public static String HOT = "a_hot";
	public static String DATETIME_BUILD = "a_datetime_build";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ ORGANIZER + ", "
										+ PLOTTER + ", "
										+ NUMBER + ", "
										+ DATETIME_START + ", "
										+ DATETIME_END + ", "
										+ DATETIME_BUILD + ", "
										+ STATU + ", "
										+ BUILDER + ", "
										+ PIC + ", "
										+ HOT;
	private static String INSERT_COLUMN = ID + ", "
										+ TITLE + ", "
										+ DESC + ", "
										+ ORGANIZER + ", "
										+ PLOTTER + ", "
										+ NUMBER + ", "
										+ DATETIME_START + ", "
										+ DATETIME_END + ", "
										+ DATETIME_BUILD + ", "
										+ BUILDER + ", "
										+ PIC;
	
	private static String BASE_SELECT_SQL = "select * from " + TABLE_NAME + ", " + TABLE_NAME_STATU + " where shsj_activit.a_statu=shsj_activit_statu.as_id ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?,?,?,?,?,?,?,?,?)";
	
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
	public int save(String title, String organizer, String plotter,
			String number, String statu, String dateTimeStart,
			String dateTimeEnd, String content, String imgPath, String userId) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(title);
		contations.add(content);
		contations.add(organizer);
		contations.add(plotter);
		contations.add(number);
		contations.add(dateTimeStart);
		contations.add(dateTimeEnd);
		contations.add(DateFormater.getDateTime());
		contations.add(userId);
		contations.add(imgPath);
		return super.saveOrUpdate(BASE_INSERT_SQL, contations.toArray());
	}

	@Override
	public int delete(String id) {
		String sql = "delete from " + TABLE_NAME + " where " + ID + "=?";
		return super.delete(sql, new Object[]{ id });
	}

	@Override
	public List<Map<String, Object>> queryStatus() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from shsj_activit_statu order by as_id asc");
		return super.queryForList(sql.toString(), new Object[]{});
	}
	
}
