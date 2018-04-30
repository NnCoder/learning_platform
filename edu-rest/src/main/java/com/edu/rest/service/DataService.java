package com.edu.rest.service;

import java.util.List;

import com.edu.common.pojo.Data;



public interface DataService {
	
	public List<Data> getDataByKpIdAndType(Integer kpId, int type);
	public List<Data> getRecentDatas(int limit);
}
