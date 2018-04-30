package com.edu.manager.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.MajorMapper;
import com.edu.common.pojo.EasyUIComboboxData;
import com.edu.common.pojo.Major;
import com.edu.common.pojo.MajorExample;
import com.edu.manager.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService{

	@Autowired
	private MajorMapper majorMapper;
	
	@Override
	public List<EasyUIComboboxData> getMajorList() {
		MajorExample example = new MajorExample();
		List<Major> list = majorMapper.selectByExample(example);
		List<EasyUIComboboxData> datas = new LinkedList<>();
		EasyUIComboboxData data = null;
		for(Major major : list) {
			data = new EasyUIComboboxData();
			data.setId(major.getMajorName());
			data.setText(major.getMajorName());
			datas.add(data);
		}
		return datas;
	}
	
}
