package org.hhr;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hhr.user.vo.UserVO;
import org.hhr.user.web.UserController;

public class HHRMain {
	public static void main(String...args) {
		
		  System.out.println("입력하세요");
		  System.out.println("1=입력,2=읽기,3=검색");
		  String option;
		  Scanner scan= new Scanner(System.in);
		  option=scan.nextLine();
		  UserController user = new UserController();
		  
		  
		  if(option.equals("1")){
			  user.insertUser();
			  
			  System.out.println("입력되었습니다.");
			  HHRMain.main(args);
			  
		  }else if(option.equals("2")){
			  user.selectData();
			  HHRMain.main(args);
			  System.out.println("파일을 읽어옵니다.");
		  }else if(option.equals("3")){
			  System.out.println("데이터를 검색합니다.");
			  user.serchData();
			  	  
			  HHRMain.main(args);
			
		

		  }else{
			  System.out.println("1~4을 입력하세요");
			 HHRMain.main(args);
		  }
		  
		
		
//		Map<String,Object> selectData = user.selectData();
//		
//		List<UserVO> datas = (List<UserVO>)selectData.get("getData");
//
//		for(UserVO output : datas){
//			System.out.println(output);
//			System.out.println(output.toString());
//		}

	}
}
