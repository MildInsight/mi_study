package org.hhr.user.service;

import java.util.List;
import java.util.Map;

import org.hhr.user.vo.UserVO;

public interface UserService {
	
	// Exam1VO 리스트 가져온다
	public List<UserVO> getUserList();

	// Exam1VO 저장한다.
	public boolean insertUserVO(UserVO vo);
	
	// Exam1VO 변경한다.
	public boolean updateUserVO(UserVO vo);

	// Exam1VO 삭제한다.
	public boolean deleteUserVO(UserVO vo);
	
	public List<UserVO> searchData(UserVO vo);
	
}
