package com.edu.protal.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.edu.common.pojo.QuestionQueryResult;
import com.edu.protal.controller.domain.PraticeHistory;

public interface QuestionMapper {
	List<Integer> selectQuestionIdList();
	
	List<QuestionQueryResult> getQuestionAnalysisListByIdList(
			@Param("kpId")Integer kpId,
			@Param("array")List<Integer> ids,
			@Param("typeIdList")List<Integer> typeIdList);
	
	List<QuestionQueryResult> getQuestionQueryResultListByIdSet(@Param("set")Set<Integer> idSet);

	void insertPraticeHistory(PraticeHistory praticeHistory);
	
	int isUserPraticeHistoryExists(@Param("userAccount")String userAccount, 
			@Param("kpId")int kpId);
	
	PraticeHistory getUserPraticeHistoryByUserAccountAndKpId(
			@Param("userAccount")String userAccount, 
			@Param("kpId")int kpId);
	
	int isPermAnswer(@Param("userAccount")String userAccount, 
			@Param("courseId")int courseId);
}
