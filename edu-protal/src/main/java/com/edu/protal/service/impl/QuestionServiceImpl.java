package com.edu.protal.service.impl;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.common.pojo.QuestionQueryResult;
import com.edu.protal.controller.domain.PraticeHistory;
import com.edu.protal.mapper.QuestionMapper;
import com.edu.protal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * 随机组卷
	 */
	@Override
	public List<QuestionQueryResult> getQuestionQueryResultListByFieldIdList(int kpId, List<Integer> typeIdList,
			int limit) {
		List<Integer> idList = questionMapper.selectQuestionIdList();
		Random random = new Random();
		while(limit < idList.size()) {
			idList.remove(random.nextInt(idList.size()));
		}
		List<QuestionQueryResult> list = questionMapper.getQuestionAnalysisListByIdList(kpId, idList, typeIdList);
		return list; 
	}

	@Override
	public List<QuestionQueryResult> getQuestionQueryResultListByIdSet(Set<Integer> idSet) {
		return questionMapper.getQuestionQueryResultListByIdSet(idSet);
	}

	@Override
	@Transactional
	public void insertPraticeHistory(PraticeHistory ph) {
		questionMapper.insertPraticeHistory(ph);
	}

	@Override
	public PraticeHistory getUserPraticeHistoryByUserAccountAndKpId(String userAccount, int kpId) {
		return questionMapper.getUserPraticeHistoryByUserAccountAndKpId(userAccount, kpId);
	}

	@Override
	public int isUserPraticeHistoryExists(String userAccount, int kpId) {
		return questionMapper.isUserPraticeHistoryExists(userAccount, kpId);
	}

	@Override
	public int isPremAnswer(String userAccount, int courseId) {
		return questionMapper.isPermAnswer(userAccount, courseId);
	}
}
