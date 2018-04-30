package com.edu.protal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.Data;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.service.DataService;

@Service
public class DataServiceImpl implements DataService{
	
	@Value("${REST_DATA_URL}")
	private String REST_DATA_URL;
	
	@Override
	public List<Data> getDataRecent(int limit) {
		String jsonData = HttpClientUtil.doGet(REST_DATA_URL+"/recent?limit="+limit);
		List<Data> datas = JsonUtils.jsonToList(jsonData, Data.class);
		return datas;
	}
	
}
