package org.hhr.user.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hhr.common.FileUtil;
import org.hhr.user.vo.UserVO;



public class UserDAO {
	
	private String filePath="c:/hhr/data.csv";
	
	
	public List<UserVO> getUserList(){  
		
		List<UserVO> getdata = new ArrayList<UserVO>();
		
		try {
			List<Map<String,String>> fileUtil = FileUtil.csvRead(filePath);
			for(Map<String,String> data:fileUtil){
				UserVO vo = new UserVO();
				getdata.add(vo);
				
				vo.setMynum(Integer.parseInt(data.get("mynum")));
				vo.setName(data.get("name"));
			   	vo.setSex(data.get("sex").charAt(0));
				vo.setAge(Integer.parseInt(data.get("age")));
			   	vo.setEmail(data.get("name"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return getdata;
	}
}
