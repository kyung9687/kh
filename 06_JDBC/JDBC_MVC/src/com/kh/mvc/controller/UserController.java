package com.kh.mvc.controller;

import java.util.List;

import com.kh.mvc.model.UserDTO;
import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.service.MemberService;

public class UserController {
	/**
	 * view 에서 온 요청을 처리해주는 클래스 입니다.
	 * 메소드로 전달된 데이터 값을 가공 처리한 후 DAO로 전닳합니다
	 * DAO로 부터 반환하는
	 * @return 
	 */
	private  UserDAO userDao = new UserDAO();
	private MemberService memberService = new MemberService();
	
	public List<UserDTO> findAll() {
		return userDao.findAll();
		
	}
	

	public int insertUser(String userId, String userPw, String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		
		return userDao.insertUser(user);
		
	}
}
