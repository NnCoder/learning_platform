package com.edu.protal.controller.domain;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import com.edu.common.pojo.AnswerSheetItem;

@XmlRootElement
public class ExamFinishParam implements Serializable {
	private static final long serialVersionUID = 4265690784518580278L;
	
	private int kpId;
	private int courseId;
	
	private int duration;
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	private HashMap<Integer, AnswerSheetItem> as;


	public HashMap<Integer, AnswerSheetItem> getAs() {
		return as;
	}

	public void setAs(HashMap<Integer, AnswerSheetItem> as) {
		this.as = as;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getKpId() {
		return kpId;
	}

	public void setKpId(int kpId) {
		this.kpId = kpId;
	}

	

}
