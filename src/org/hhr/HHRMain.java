package org.hhr;

import java.util.List;
import java.util.Map;

import org.hhr.user.vo.UserVO;
import org.hhr.user.web.UserController;

public class HHRMain {
	public static void main(String...args) {
		UserController user = new UserController();

		Map<String,Object> selectData = user.selectData();
		
		List<UserVO> datas = (List<UserVO>)selectData.get("getData");

		for(UserVO output : datas){
			System.out.println(output);
//			System.out.println(output.toString());
		}

	}
}
