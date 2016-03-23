package org.hhr.user.service;

import java.util.List;

import org.hhr.user.dao.UserDAO;
import org.hhr.user.vo.UserVO;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO = new UserDAO();
	
	// Exam1VO 리스트 가져온다
	public List<UserVO> getUserList(){
//		List<UserVO> list = userDAO.getUserList();
//		return list;
		return userDAO.getUserList();
	};

	// Exam1VO 저장한다.
	public boolean insertUserVO(UserVO vo){
		
		return true;
	};
	
	// Exam1VO 변경한다.
	public boolean updateUserVO(UserVO vo){
		
		return true;
	};

	// Exam1VO 삭제한다.
	public boolean deleteUserVO(UserVO vo){
		
		return true;
	};
	
}
