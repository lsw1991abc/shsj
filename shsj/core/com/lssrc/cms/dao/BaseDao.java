/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2014年12月10日
 */
package com.lssrc.cms.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Carl_Li
 *
 */
public class BaseDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	/**
	 * 插入或更新
	 * @param sql
	 * @param contations
	 * @return
	 */
	public int saveOrUpdate(String sql, Object[] contations) throws DataAccessException {
		return jdbcTemplate.update(sql, contations);
	}
	
	/**
	 * 
	 * @param sql
	 * @return
	 * @throws DataAccessException
	 */
	public int queryForInt(String sql) throws DataAccessException {
		Number number = jdbcTemplate.queryForObject(sql, null, Integer.class);
		return (number != null ? number.intValue() : 0);
	}
	
	/**
	 * 
	 * @param sql
	 * @param contations
	 * @param key
	 * @return
	 */
	public int queryForInt(String sql, Object[] contations) throws DataAccessException {
		Number number = jdbcTemplate.queryForObject(sql, contations, Integer.class);
		return (number != null ? number.intValue() : 0);
	}
	
	/**
	 * 
	 * @param sql
	 * @param contations
	 * @return
	 */
	public long queryForLong(String sql, Object[] contations) throws DataAccessException {
		Number number = jdbcTemplate.queryForObject(sql, contations, Long.class);
		return (number != null ? number.longValue() : 0);
	}
	
	/**
	 * 
	 * @param sql
	 * @param contations
	 * @return
	 */
	public Map<String, Object> queryForMap(String sql, Object[] contations) {
		try {
			return jdbcTemplate.queryForMap(sql, contations);
		} catch (Exception e) {
			return null;
		}
		
	}

	/**
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql) {
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql, Object[] contations) {
		return jdbcTemplate.queryForList(sql, contations);
	}

	/**
	 * @param sql
	 * @param contations
	 * @return
	 */
	public int delete(String sql, Object[] contations) {
		return jdbcTemplate.update(sql, contations);
	}
	
}
