package org.hhr.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hhr.user.dao.UserDAO;
import org.hhr.user.vo.UserVO;

public class FileUtil {
	
	public static List<Map<String,String>> modifyTxt(){
		
		
		
		
		return null;
	}
	public static List<Map<String,String>> csvRead(String filePath) throws FileNotFoundException{
		
		//csv 파일을 읽기위한 클레스 호출
		BufferedReader br = readFileBuffer(filePath);
		 
		 
		 String line="";
		 
		 try{
			 int a = 0;
			 
			 //Map 키값을 저장하는 배열  
			 String[] key=null;
			 List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			 while((line = br.readLine()) !=null){
				 //Map value 값을 저장하는 배열 
				String[] value = line.split(",");
			 	if(a==0){
			 		//첫번째값은 키값임으로 키값으로 저장
			 		key = value;
			 	}else{
			 		Map <String,String> dataList= new LinkedHashMap<String, String>(); 
			 		
			 		for(int x=0;x<key.length;x++ ){
			 			dataList.put(key[x], value[x]);
			 		}
			 		
			 		
			 		/*dataList.put(key[1], value[1]);
			 		dataList.put(key[2], value[2]);
			 		dataList.put(key[3], value[3]);*/
			 		list.add(dataList);
			 	}
				 a++;
			 }
			 return list;
		 }catch (Exception e) {
		System.out.println(e.getMessage());
	}
		 return null;
 }
	
	private static BufferedReader readFileBuffer(String filePath) throws FileNotFoundException {
		 FileInputStream fis = new FileInputStream(filePath);
		 InputStreamReader isr = new InputStreamReader(fis);
		 
		 return new BufferedReader(isr);
	}
	
	private List<CsvBean> getData(){
		List<CsvBean> data =new ArrayList<CsvBean>();
		CsvBean csvBean = new CsvBean();
		csvBean.setName("KKK");
		csvBean.setSex("F");
		csvBean.setAge("27");
		csvBean.setEmail("KKK@email.com");
		
		return data;
	}
	
	public boolean writeCsv(String filePath,String txt) {
		try{
			//파일객체 생성
			File file = new File(filePath);
			 BufferedWriter fw = new BufferedWriter(new FileWriter(file, true));
			/* List<CsvBean> data = getData();*/
			/* for(CsvBean csvBean : data){
				 fw.write(csvBean.csvString());
			 }*/
			 
			fw.write(txt);
			fw.flush();
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	
		
		return true;
	}
	public void writeCSV()throws IOException{
	String name;
	String sex;
	String age;
	String email;
	String txt;
		//출력 데이터
	
	CsvBean csvBean =new CsvBean();
	Scanner scan =new Scanner(System.in);
	//성명
	System.out.println("성명을 입력해주세요");
	 name=scan.nextLine();
	csvBean.setName(name);
	
	//성별을
	System.out.println("성별을 입력해주세요");
	sex=scan.nextLine();
	csvBean.setSex(sex);
	//나이
	System.out.println("나이를 입력해 주세요");
	 age=scan.nextLine();
	csvBean.setAge(age);
	
	//이메일
	System.out.println("이메일을 입력해 주세요");
	email=scan.nextLine();
	csvBean.setEmail(email);
	
		
	
	String fileName="c:/hhr/data.csv";
	
	
	
	//String name=csvBean.getName();	
	
	txt ="\n"+csvBean.getName()+","+csvBean.getSex()+","+csvBean.getAge()+","+csvBean.getEmail();
	
		try{
			//파일객체 생성
			File file = new File(fileName);
			 BufferedWriter fw = new BufferedWriter(new FileWriter(file, true));
			/* List<CsvBean> data = getData();*/
			/* for(CsvBean csvBean : data){
				 fw.write(csvBean.csvString());
			 }*/
			 
			fw.write(txt);
			fw.flush();
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	
		
	}
	public void writeCSV(Map<String,String> dataMap)throws IOException {
		
		String fileName = "c:/hhr/data.csv";
		
		// 파일열기
		BufferedReader br = readFileBuffer(fileName);
		// 키값 가져오기
		String keys = br.readLine();
		String[] keyArray = keys.split(",");
		
		StringBuffer insertData = new StringBuffer();
		
		for(int i = 0; i < keyArray.length; i++) {
			String data = dataMap.get(keyArray[i]);
			insertData.append(",").append(data);
		}
		
		
	String txt = null;
	CsvBean csvBean =new CsvBean();
	csvBean.setName("AAA");	
	
	txt = csvBean.getName()+","+csvBean.getSex()+","+csvBean.getAge()+","+csvBean.getEmail();
	
		try{
			//파일객체 생성
			File file = new File(fileName);
			 BufferedWriter fw = new BufferedWriter(new FileWriter(file, true));
			/* List<CsvBean> data = getData();*/
			/* for(CsvBean csvBean : data){
				 fw.write(csvBean.csvString());
			 }*/
			 
			String temp = insertData.deleteCharAt(0).toString();
			System.out.println(temp);
			fw.write("\n"+temp);
			fw.flush();
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
 	
		}
	}
	public List<UserVO> selectData(UserVO vo) throws IOException {
		

		FileUtil fileUtil = new FileUtil(); 
		UserDAO userDAO= new UserDAO();

		boolean check=true ;
		List<UserVO> result= new ArrayList<UserVO>();
		try{
			 List<Map<String,String>> list = fileUtil.csvRead("C:/hhr/data.csv");
			
			
			 for(int i=0;i<list.size();i++){

				
				if(vo.getName().equals(list.get(i).get("name"))){
					check =false;
					
					vo.setMynum(Integer.parseInt(list.get(i).get("mynum")));
					vo.setName(list.get(i).get("name"));
					vo.setSex(list.get(i).get("sex").charAt(0));
					vo.setAge(Integer.parseInt(list.get(i).get("age")));
					vo.setEmail(list.get(i).get("email"));
					result.add(vo);
					
				}
				
				
			 }
			 
			if(check==true){
				System.out.println("검색결과가 없습니다");
				
			}
			 
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return result ;
		
	}

 
}
