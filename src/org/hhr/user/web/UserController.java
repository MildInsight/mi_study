package org.hhr.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hhr.user.service.UserService;
import org.hhr.user.service.UserServiceImpl;
import org.hhr.user.vo.UserVO;

public class UserController {
	
	UserService userService = new UserServiceImpl();
	
	public Map<String,Object> selectData(){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		List<UserVO> getData = userService.getUserList();
		
		resultMap.put("getData", getData);
		
		return resultMap;
	}
	
	
		
	

	
}
