/**
 * TODO
 * 
 * Author：Carl_Li
 * Date：2015年5月8日
 */
package com.lssrc.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lssrc.cms.dao.LinkMapper;
import com.lssrc.cms.entity.Link;
import com.lssrc.cms.service.LinkService;

/**
 * @author Carl_Li
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> getByPage(int type) {
		return linkMapper.selectByPage(type);
	}

}
