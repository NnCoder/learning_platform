package com.edu.protal.pojo;

import com.edu.common.pojo.Data;
import java.util.List;

import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.Video;

public class KpDetail {
	private KnowledgePoint knowledgePoint;
	private List<Data> normalDatas;
	private List<Data> testDatas;
	private List<Video> videos;
	public KnowledgePoint getKnowledgePoint() {
		return knowledgePoint;
	}
	public void setKnowledgePoint(KnowledgePoint knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public List<Data> getNormalDatas() {
		return normalDatas;
	}
	public void setNormalDatas(List<Data> normalDatas) {
		this.normalDatas = normalDatas;
	}
	public List<Data> getTestDatas() {
		return testDatas;
	}
	public void setTestDatas(List<Data> testDatas) {
		this.testDatas = testDatas;
	}
	
	
	
}
