package com.edu.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.DataMapper;
import com.edu.common.pojo.Data;
import com.edu.common.pojo.DataExample;
import com.edu.rest.service.DataService;
import com.github.pagehelper.PageHelper;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public List<Data> getDataByKpIdAndType(Integer kpId, int type) {
		//根据知识点以及资料类型获取资料
		//'资料类型 1:普通资料 2:测试资料'
		DataExample example = new DataExample();
		DataExample.Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andDataTypeEqualTo((byte) type);
		
		List<Data> list = dataMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Data> getRecentDatas(int limit) {
		PageHelper.startPage(1, limit);
		DataExample example = new DataExample();
		List<Data> list = dataMapper.selectByExample(example);
		return list;
	}
	
}
