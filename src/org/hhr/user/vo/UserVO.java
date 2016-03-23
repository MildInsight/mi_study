package org.hhr.user.vo;

public class UserVO {
	
	private int mynum;		// 번호(프라이머리키)
	private String name;	// 이름
	private char sex;		// 성별(M/F)
	private int age;		// 나이
	private String email;	// 이메일

	public int getMynum() {
		return mynum;
	}
	public void setMynum(int mynum) {
		this.mynum = mynum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		
		return  mynum+","+name+","+sex+","+","+age+","+email;
	}
}
