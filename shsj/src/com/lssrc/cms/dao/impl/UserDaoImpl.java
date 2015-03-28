/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月9日
 */
package com.lssrc.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

import com.lssrc.cms.dao.UserDao;
import com.lssrc.util.BaseDao;
import com.lssrc.util.DateFormater;
import com.lssrc.util.UUID;

/**
 * @author Carl_Li
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
	public static String TABLE_NAME = "sys_user";
	public static String ALL_COLUMN = "user_id userId, "
										+ "user_account username, "
										+ "user_password passwd, "
										+ "user_nickname nickname, "
										+ "qq, "
										+ "email, "
										+ "phoneno, "
										+ "user_desc userDesc, "
										+ "enabled, "
										+ "build_date buildDate, "
										+ "issys";
	public static String INSERT_COLUMN = "user_id, "
										+ "user_account, "
										+ "user_password, "
										+ "user_nickname, "
										+ "qq, "
										+ "email, "
										+ "phoneno, "
										+ "build_date";
	
	private static String BASE_SELECT_SQL = "select " + ALL_COLUMN + " from " + TABLE_NAME + " where 1=1 ";
	private static String BASE_INSERT_SQL = "insert into " + TABLE_NAME + "(" + INSERT_COLUMN + ") values";

	@Override
	public Map<String, Object> queryByUsername(String username) throws IncorrectResultSizeDataAccessException {
		String sql = BASE_SELECT_SQL + "and user_account=?";
		return super.queryForMap(sql, new Object[] { username });
	}
	
	@Override
	public int queryCountByUsername(String username) {
		String sql = "select count(*) from " + TABLE_NAME + " where 1=1 and user_account=?";
		return super.queryForInt(sql, new Object[] { username });
	}
	
	@Override
	public int queryCountByIssys(int issys) {
		String sql = "select count(*) from " + TABLE_NAME + " where 1=1 and issys=?";
		return super.queryForInt(sql, new Object[] { issys });
	}
	
	@Override
	public List<Map<String, Object>> queryByPage(int start, int pageSize, int issys) {
		String sql = BASE_SELECT_SQL + " and issys=? order by build_date desc limit ?,?";
		return super.queryForList(sql, new Object[] {issys, start, pageSize});
	}

	@Override
	public int save(Map<String, String> contations) {
		String sql = BASE_INSERT_SQL + "(?, ?, ?, ?, ?, ?, ?, ?)";
		return super.saveOrUpdate(sql, new Object[] {UUID.generateRandomUUID(), 
														contations.get("username"), 
														contations.get("password"),
														contations.get("username"),
														contations.get("qq"),
														contations.get("email"),
														contations.get("phoneno"),
														DateFormater.getDateTime()});
	}

	@Override
	public Map<String, Object> queryById(String id) {
		String sql = BASE_SELECT_SQL + " and user_id=?";
		return super.queryForMap(sql, new Object[] { id });
	}

	@Override
	public int update(Map<String, Object> user) {
		String sql = "update " + TABLE_NAME + " set user_nickname=?, qq=?, email=?, phoneno=?, user_desc=? where user_id=?";
		List<Object> contations = new ArrayList<Object>();
		contations.add(user.get("nickname"));
		contations.add(user.get("qq"));
		contations.add(user.get("email"));
		contations.add(user.get("phoneno"));
		contations.add(user.get("userDesc"));
		contations.add(user.get("userId"));
		return super.saveOrUpdate(sql, contations.toArray());
	}

	@Override
	public int changePasswd(Map<String, Object> user) {
		String sql = "update " + TABLE_NAME + " set user_password=? where user_id=?";
		List<Object> contations = new ArrayList<Object>();
		contations.add(user.get("passwd"));
		contations.add(user.get("userId"));
		return super.saveOrUpdate(sql, contations.toArray());
	}

}
