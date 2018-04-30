package com.edu.manager.service;

import java.util.List;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.HttpResult;

public interface DataService {
	/**
	 * 通过知识点id和资料类型获取资料列表
	 * @param kpId
	 * @param dataType
	 * @return
	 */
	List<Data> getDataListByKpId (Integer kpId, Integer dataType);
	
	HttpResult createData(Data data);
	
	HttpResult deleteData(Integer id);
		
	HttpResult updateDate(Data data);
}
