/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月13日
 */
package com.lssrc.cms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.JobDao;
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
		sql.append("select j_id,j_title,j_organizer,j_type,j_number,j_number_ready,j_number_limit,j_work_place,j_work_time,j_salary,j_salary_type,j_contact,j_content,j_audition_time,j_audition_place,j_datetime_build,j_datetime_end,j_belong,jt_name,jb_name "
				+ "from shsj_job, shsj_job_belong, shsj_job_type "
				+ "where shsj_job.j_belong=shsj_job_belong.jb_id and shsj_job.j_type=shsj_job_type.jt_id and isdeled=0 ");
		List<Object> contations = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(type)) {
			sql.append("and j_type=? ");
			contations.add(type);
		}
		sql.append("order by " + DATETIME_BUILD + " desc limit ?,?");
		contations.add(start);
		contations.add(pageSize);
		return super.queryForList(sql.toString(), contations.toArray());
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = "select j_id,j_title,j_organizer,j_type,j_number,j_number_ready,j_number_limit,j_work_place,j_work_time,j_salary,j_salary_type,j_contact,j_content,j_audition_time,j_audition_place,j_datetime_build,j_datetime_end,j_belong,jt_name,jb_name "
				+ "from shsj_job, shsj_job_belong, shsj_job_type "
				+ "where shsj_job.j_belong=shsj_job_belong.jb_id and shsj_job.j_type=shsj_job_type.jt_id and j_id=?";
		return super.queryForMap(sql, new Object[]{ id });
	}

	@Override
	public int queryCount(String type) {
		String sql = "select count(*) "
				+ "from shsj_job, shsj_job_belong, shsj_job_type "
				+ "where shsj_job.j_belong=shsj_job_belong.jb_id and shsj_job.j_type=shsj_job_type.jt_id and isdeled=0 ";
		List<Object> contations = new ArrayList<Object>();
		if (StringUtils.isNotEmpty(type)) {
			sql += "and j_type=?";
			contations.add(type);
		}
		return super.queryForInt(sql, contations.toArray());
	}

	@Override
	public int save(String organizer, String title, String type, String place,
			String salary, String datetimeWork, int number,
			int numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content, String belong,
			String userId) {
		List<Object> contations = new ArrayList<Object>();
		contations.add(UUID.generateRandomUUID());
		contations.add(title);
		contations.add(organizer);
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
	public int update(String id, String organnizer, String title, String type,
			String place, String salary, String datetimeWork, int number,
			int numberLimit, String contact, String datetimeStart,
			String datetimeEnd, String auditionPlace, String content,
			String belong, String userId) {
		String sql = "update shsj_job set "
				+ "j_title=?, "
				+ "j_organizer=?, "
				+ "j_belong=?, "
				+ "j_type=?, "
				+ "j_number=?, "
				+ "j_number_limit=?, "
				+ "j_work_place=?, "
				+ "j_work_time=?, "
				+ "j_salary=?, "
				+ "j_contact=?, "
				+ "j_content=?, "
				+ "j_audition_place=?, "
				+ "j_audition_time=?, "
				+ "j_datetime_end=? "
				+ "where j_id=?";
		List<Object> contations = new ArrayList<Object>();
		contations.add(title);
		contations.add(organnizer);
		contations.add(belong);
		contations.add(type);
		contations.add(number);
		contations.add(numberLimit);
		contations.add(place);
		contations.add(datetimeWork);
		contations.add(salary);
		contations.add(contact);
		contations.add(content);
		contations.add(auditionPlace);
		contations.add(datetimeStart);
		contations.add(datetimeEnd);
		contations.add(id);
		return super.saveOrUpdate(sql, contations.toArray());
	}

	@Override
	public int delete(String id) {
		String sql = "update shsj_job set isdeled=1 where j_id=?";
		return super.saveOrUpdate(sql, new Object[]{ id });
	}

	@Override
	public List<Map<String, Object>> queryBelong() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from shsj_job_belong order by jb_id asc");
		return super.queryForList(sql.toString(), new Object[]{});
	}

}
