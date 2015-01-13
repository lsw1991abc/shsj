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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.lssrc.shsj.dao.JobDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("jobDao")
public class JobDaoImpl extends BaseDao implements JobDao {

	public static String TABLE_NAME = "shsj_job";
	
	public static String ID = "j_id";
	public static String TITLE = "j_title";
	public static String ORGANIZER = "j_organizer";
	public static String TYPE = "j_type";
	public static String NUMBER = "j_number";
	public static String NUMBER_READY = "j_number_ready";
	public static String NUMBER_LIMIT = "j_number_limit";
	public static String WORK_PLACE = "j_work_place";
	public static String WORK_TIME = "j_work_time";
	public static String SALARY = "j_salary";
	public static String SALARY_TYPE = "j_salary_type";
	public static String CONTACT = "j_contact";
	public static String CONTENT = "j_content";
	public static String AUDITION_PLACE = "j_audition_place";
	public static String AUDITION_TIME = "j_audition_time";
	public static String DATETIME_BUILD = "j_datetime_build";
	public static String DATETIME_END = "j_datetime_end";
	public static String BELONG = "j_belong";
	
	
	private static String ALL_COLUMN = ID + ", "
										+ TITLE + ", "
										+ TYPE + ", "
										+ ORGANIZER + ", "
										+ NUMBER_READY + ", "
										+ NUMBER + ", "
										+ NUMBER_LIMIT + ", "
										+ WORK_PLACE + ", "
										+ SALARY + ", "
										+ WORK_TIME + ", "
										+ SALARY_TYPE + ", "
										+ CONTACT + ", "
										+ CONTENT + ", "
										+ AUDITION_PLACE + ", "
										+ AUDITION_TIME + ", "
										+ DATETIME_END + ", "
										+ DATETIME_BUILD + ", "
										+ BELONG;
	private static String INSERT_COLUMN = ID + ", "
										+ TITLE + ", "
										+ ORGANIZER + ", "
										+ TYPE + ", "
										+ NUMBER + ", "
										+ NUMBER_READY + ", "
										+ NUMBER_LIMIT + ", "
										+ WORK_PLACE + ", "
										+ WORK_TIME + ", "
										+ SALARY + ", "
										+ SALARY_TYPE + ", "
										+ CONTACT + ", "
										+ CONTENT + ", "
										+ AUDITION_PLACE + ", "
										+ AUDITION_TIME + ", "
										+ DATETIME_END + ", "
										+ DATETIME_BUILD + ", "
										+ BELONG;
	
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize, String type) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from shsj_view_job where 1=1 ");
		//sql.append(BASE_SELECT_SQL);
		if (StringUtils.isNotEmpty(type)) {
			sql.append("and " + TYPE + "=" + type + " ");
		}
		sql.append("order by " + DATETIME_BUILD + " desc limit " + start + "," + pageSize);
		return super.queryForList(sql.toString(), new Object[]{});
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = "select * from shsj_view_job where 1=1 and " + ID + "=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public int queryCount(String type) {
		String sql = "select count(*) from shsj_view_job";
		if (StringUtils.isNotEmpty(type)) {
			sql += " where " + TYPE + "=" + type;
		}
		return super.queryForInt(sql, new Object[]{});
	}

	@Override
	public int save(String organnizer, String title, String type, String place,
			String salary, String datetimeWork, String number,
			String numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content, String belong,
			String userId) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(title);
		contations.add(organnizer);
		contations.add(type);
		contations.add(number);
		contations.add("0");
		contations.add(numberLimit);
		contations.add(place);
		contations.add(datetimeWork);
		contations.add(salary);
		contations.add("元/月");
		contations.add(contact);
		contations.add(content);
		contations.add(auditionPlace);
		contations.add(datetimeStart);
		contations.add(datetimeEnd);
		contations.add(DateFormater.getDateTime());
		contations.add(belong);
		return super.saveOrUpdate(BASE_INSERT_SQL, contations.toArray());
	}

	@Override
	public int delete(String id) {
		String sql = "delete from " + TABLE_NAME + " where " + ID + "=?";
		return super.delete(sql, new Object[]{ id });
	}

}
