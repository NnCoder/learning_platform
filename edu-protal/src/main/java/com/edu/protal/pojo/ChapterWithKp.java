package com.edu.protal.pojo;

import java.util.List;

import com.edu.common.pojo.KnowledgePoint;

public class ChapterWithKp {
	private int chapterId;
	private String chapterName;
	private List<KnowledgePoint> knowledgePoints;
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public List<KnowledgePoint> getKnowledgePoints() {
		return knowledgePoints;
	}
	public void setKnowledgePoints(List<KnowledgePoint> knowledgePoints) {
		this.knowledgePoints = knowledgePoints;
	}
	
	
}
