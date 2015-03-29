/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月11日
 */
package com.lssrc.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.ResumeDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("resumeDao")
public class ResumeDaoImpl extends BaseDao implements ResumeDao {

	public static String TABLE_NAME = "shsj_resume";
	
	public static String ID = "r_id";
	public static String NAME = "r_name";
	public static String SEX = "r_sex";
	public static String AGE = "r_age";
	public static String COLLEGE = "r_college";
	public static String MAJOR = "r_major";
	public static String ENTRANCE = "r_entrance";
	public static String HEIGHT = "r_height";
	public static String WEIGHT = "r_weight";
	public static String PROFILE = "r_profile";
	public static String EXPERIENCE = "r_experience";
	public static String QQ = "r_qq";
	public static String PHONENO = "r_phoneno";
	public static String EMAIL = "r_email";
	public static String PIC = "r_pic";
	public static String HOT = "r_hot";
	public static String SHOW = "r_show";
	public static String DATETIME_UPDATE = "r_datetime_update";
	public static String USER = "u_id";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ NAME + ", "
										//+ "case " + SEX + " when '0' then '女' else '男' end as " + SEX + ", "
										+ SEX + ", "
										+ AGE + ", "
										+ COLLEGE + ", "
										+ MAJOR + ", "
										+ ENTRANCE + ", "
										+ HEIGHT + ", "
										+ WEIGHT + ", "
										+ PROFILE + ", "
										+ EXPERIENCE + ", "
										+ QQ + ", "
										+ PHONENO + ", "
										+ EMAIL + ", "
										+ PIC + ", "
										+ HOT + ", "
										+ SHOW + ", "
										+ USER + ", "
										+ DATETIME_UPDATE;
	private static String INSERT_COLUMN = ID + ", "
										+ NAME + ", "
										+ COLLEGE + ", "
										+ MAJOR + ", "
										+ HEIGHT + ", "
										+ WEIGHT + ", "
										+ PROFILE + ", "
										+ EXPERIENCE + ", "
										+ PIC + ", "
										+ USER + ", "
										+ DATETIME_UPDATE;
	
	private static String BASE_SELECT_SQL = "select " + ALL_COLUMN + " from " + TABLE_NAME + " where 1=1 ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values";
	
	@Override
	public int queryCount() {
		String sql = "select count(*) from " + TABLE_NAME + " where r_show=1";
		return super.queryForInt(sql);
	}

	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize) {
		String sql = BASE_SELECT_SQL + " and r_show=1 order by " + DATETIME_UPDATE + " desc limit " + start + "," + pageSize;
		return super.queryForList(sql);
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + "and " + ID + "=? and r_show=1";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public Map<String, Object> queryByUserId(String userId) {
		String sql = BASE_SELECT_SQL + "and " + USER + "=?";
		return super.queryForMap(sql, new Object[]{ userId });
	}

	@Override
	public int update(Map<String, Object> resume) {
		String sql = "update " + TABLE_NAME + " set "
					+ NAME + "=?, "
					+ SEX + "=?, "
					+ AGE + "=?, "
					+ HEIGHT + "=?, "
					+ WEIGHT + "=?, "
					+ COLLEGE + "=?, "
					+ MAJOR + "=?, "
					+ EXPERIENCE + "=?, "
					+ PROFILE + "=?, "
					+ DATETIME_UPDATE + "=?, "
					+ PIC + "=?, "
					+ SHOW + "=? "
					+ "where " + ID + "=?";
		List<Object> contations = new ArrayList<Object>();
		contations.add(resume.get("name"));
		contations.add(resume.get("sex"));
		contations.add(resume.get("age"));
		contations.add(resume.get("height"));
		contations.add(resume.get("weight"));
		contations.add(resume.get("college"));
		contations.add(resume.get("major"));
		contations.add(resume.get("experience"));
		contations.add(resume.get("desc"));
		contations.add(DateFormater.getDateTime());
		contations.add(resume.get("imgPath"));
		contations.add(resume.get("show"));
		contations.add(resume.get("r_id"));
		return super.saveOrUpdate(sql, contations.toArray());
	}

	@Override
	public int save(Map<String, Object> resume) {
		String sql = BASE_INSERT_SQL + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(resume.get("user"));
		contations.add("");
		contations.add("");
		contations.add(0);
		contations.add(0);
		contations.add("");
		contations.add("");
		contations.add(resume.get("imgPath"));
		contations.add(resume.get("userId"));
		contations.add(DateFormater.getDateTime());
		return super.saveOrUpdate(sql, contations.toArray());
	}
	
}
