package org.hhr.user.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hhr.common.FileUtil;
import org.hhr.user.vo.UserVO;



public class UserDAO {
	
	private String filePath="c:/hhr/data.csv";
		
	//데이터 읽기
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
	//데이터 삽입
	public boolean insertUser(UserVO vo){
		
		
		String txt ="\n"+vo.getMynum()+","+vo.getName()+","+vo.getSex()+","+vo.getAge()+","+vo.getEmail();
		FileUtil fileUtil = new FileUtil();
		fileUtil.writeCsv(filePath, txt);
		
		return true;
	}
	
	//데이터 이름으로 검색
	public List<UserVO> searchData(UserVO vo){
		
		List<UserVO> getData =new ArrayList<UserVO>();
		boolean check= true;
		try {
			 List<Map<String,String>> list = FileUtil.csvRead(filePath);
			 for(int i=0;i<list.size();i++){

					
					if(vo.getName().equals(list.get(i).get("name"))){
						check =false;
						
						vo.setMynum(Integer.parseInt(list.get(i).get("mynum")));
						vo.setName(list.get(i).get("name"));
						vo.setSex(list.get(i).get("sex").charAt(0));
						vo.setAge(Integer.parseInt(list.get(i).get("age")));
						vo.setEmail(list.get(i).get("email"));
						getData.add(vo);
						
					}
					
					
				 }
				 
				if(check==true){
					System.out.println("검색결과가 없습니다");
					
				}
				 
			
			 
		
		return getData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getData;
		
	}
	
}
