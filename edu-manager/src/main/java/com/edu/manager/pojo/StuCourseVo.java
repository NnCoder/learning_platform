package com.edu.manager.pojo;

public class StuCourseVo {
	private String stuAccount;
	private String stuName;
	private String majorName;
	private Integer classIndex;
	private String courseId;
	private Integer score;
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Integer getClassIndex() {
		return classIndex;
	}
	public void setClassIndex(Integer classIndex) {
		this.classIndex = classIndex;
	}
	
	
	
}
