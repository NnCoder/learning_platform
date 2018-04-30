package com.edu.rest.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.KnowledgePointMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.rest.service.KpService;

@Service
public class KpServiceImpl implements KpService {

	@Autowired
	private KnowledgePointMapper knowledgePointMapper;
	
	/*@Override
	public HttpResult getKpsByChapterId(Integer chapterId) {
		KnowledgePointExample example = new KnowledgePointExample();
		KnowledgePointExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		
		List<KnowledgePoint> list = knowledgePointMapper.selectByExample(example);
		return HttpResult.ok(list);
	}
*/
	@Override
	public HttpResult getKpDetailById(Integer kpId) {
		KnowledgePoint knowledgePoint = knowledgePointMapper.selectByPrimaryKey(kpId);
		return HttpResult.ok(knowledgePoint);
	}
	
}
