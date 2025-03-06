package com.kh.mvc.service;

import java.sql.Connection;
import java.util.List;

import com.kh.mvc.model.UserDTO;
import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.util.JdbcUtil;

public class MemberService {

	private UserDAO userDao = new UserDAO();
	
	public List<UserDTO> findAll(){
		Connection conn =JdbcUtil.getConnection();
		
		List<UserDTO> list = userDao.findAll(conn);
		
		
		return list;
	}
}
