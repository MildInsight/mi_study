package org.hhr.example.vo;

public class ScoresVO {
	private String name = null;
	private int korean = 0;
	private int english = 0;
	private int math = 0;
	private int society = 0;
	private int science = 0;
	private int sum = 0;
	private double ave = 0.0;
	private double count = 0.0;
	
	public ScoresVO() {}
	
	public ScoresVO(String name, int korean, int english, int math, int society, int science) {
		this.name = name;
		this.korean = korean;
		count++;
		this.english = english;
		count++;
		this.math = math;
		count++;
		this.society = society;
		count++;
		this.science = science;
		count++;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getSociety() {
		return society;
	}
	public void setSociety(int society) {
		this.society = society;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
	
	public int calcSum() {
		return this.korean + this.english + this.math + this.science + this.society;
	}
	
	public double calcAve() {
		return Double.valueOf(calcSum()).doubleValue() / this.count;
	}
	
}
