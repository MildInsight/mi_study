package org.hhr.common;

public class CsvBean {
	private String name;
	private String sex;
	private String age;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String csvString(){
		StringBuilder str = new StringBuilder();
		str.append(name).append(",");
		str.append(sex).append(",");
		str.append(age).append(",");
		str.append(email);
		return str.toString();
	}
}
