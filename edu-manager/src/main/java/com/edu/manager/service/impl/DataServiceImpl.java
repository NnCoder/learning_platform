package com.edu.manager.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.DataMapper;
import com.edu.common.pojo.Data;
import com.edu.common.pojo.DataExample;
import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.HttpClientUtil;
import com.edu.manager.service.DataService;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public List<Data> getDataListByKpId(Integer kpId, Integer dataType) {
		//根据知识点和资料类型查询
		DataExample example = new DataExample();
		DataExample.Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andDataTypeEqualTo((byte)dataType.intValue());
		
		//返回资料列表
		List<Data> datas = dataMapper.selectByExample(example);
		if (datas == null) {
			//空值处理
			datas = new ArrayList<>();
		}
		return datas;
	}

	@Override
	public HttpResult createData(Data data) {
		Date date = new Date();
		data.setCreateTime(date);
		data.setUpdateTime(date);
		dataMapper.insert(data);
		return HttpResult.ok(data.getDataId());
	}

	@Override
	public HttpResult deleteData(Integer id) {
		//从文件库中删除
		Data data = dataMapper.selectByPrimaryKey(id);
		try {
			HttpClientUtil.doGet(data.getDataSrc()+"/delete");
		} catch (Exception e) {
		}
		//从数据库中删除
		dataMapper.deleteByPrimaryKey(id);
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateDate(Data data) {
		data.setUpdateTime(new Date());
		dataMapper.updateByPrimaryKeySelective(data);
		return HttpResult.ok();
	}

}
