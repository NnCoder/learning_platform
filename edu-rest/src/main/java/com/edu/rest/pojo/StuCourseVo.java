package com.edu.rest.pojo;

public class StuCourseVo {
	
	private Integer order; //排行榜中的序号
	private String stuAccount;
	private String stuName;
	private String majorName;
	private Integer classIndex;
	private Integer score;
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getStuAccount() {
		return stuAccount;
	}
	public void setStuAccount(String stuAccount) {
		this.stuAccount = stuAccount;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getClassIndex() {
		return classIndex;
	}
	public void setClassIndex(Integer classIndex) {
		this.classIndex = classIndex;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	
}
