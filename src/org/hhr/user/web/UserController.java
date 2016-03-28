package org.hhr.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hhr.common.CsvBean;
import org.hhr.user.service.UserService;
import org.hhr.user.service.UserServiceImpl;
import org.hhr.user.vo.UserVO;

public class UserController {

	UserService userService = new UserServiceImpl();

	public Map<String, Object> selectData() {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<UserVO> getData = userService.getUserList();
		
		/*resultMap.put("getData", getData);*/
		
		for(UserVO getdata:getData){
			System.out.println(getdata.getMynum()+","+getdata.getName()+","+getdata.getSex()+","+getdata.getAge()+","+getdata.getEmail());
			
		}

		return resultMap;
	}

	public boolean insertUser() {
		String inputData;
		
		

		UserVO vo = new UserVO();
		// 출력 데이터

		CsvBean csvBean = new CsvBean();
		Scanner scan = new Scanner(System.in);
		// 구분번호
		System.out.println("구분번호를 입력해주세요");
		inputData = scan.nextLine();
		vo.setMynum(Integer.parseInt(inputData));

		// 성명
		System.out.println("성명을 입력해주세요");
		inputData = scan.nextLine();
		vo.setName(inputData);

		// 성별을
		System.out.println("성별을 입력해주세요");
		inputData = scan.nextLine();
		vo.setSex(inputData.charAt(0));
		// 나이
		System.out.println("나이를 입력해 주세요");
		inputData = scan.nextLine();
		vo.setAge(Integer.parseInt(inputData));

		// 이메일
		System.out.println("이메일을 입력해 주세요");
		inputData = scan.nextLine();
		vo.setEmail(inputData);

		return userService.insertUserVO(vo);
	}
	public List<UserVO> serchData(){
		
		UserVO vo = new UserVO();
		
		String selectData="";
		System.out.println("이름을 입력해주세요");
		Scanner scan = new Scanner(System.in);
		selectData=scan.nextLine();
		vo.setName(selectData);
		List<UserVO> getData = userService.searchData(vo);
		for(UserVO getdata:getData){
			System.out.println(getdata.getMynum()+","+getdata.getName()+","+getdata.getSex()+","+getdata.getAge()+","+getdata.getEmail());
		}
	
	
		return userService.searchData(vo);
		
		
	}

}
