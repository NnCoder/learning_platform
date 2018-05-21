package com.edu.protal.controller.domain;

import java.util.Date;

public class PraticeHistory {
	private int id;
	private String userAccount;
	private int kpId;
	private String content;
	private Date createTime;
	private String answerSheet;
	private int duration;
	private String paperName;
	private float pointGet;
	public Date submitTime;
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public float getPointGet() {
		return pointGet;
	}
	public void setPointGet(float pointGet) {
		this.pointGet = pointGet;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAnswerSheet() {
		return answerSheet;
	}
	public void setAnswerSheet(String answerSheet) {
		this.answerSheet = answerSheet;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public int getKpId() {
		return kpId;
	}
	public void setKpId(int kpId) {
		this.kpId = kpId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
