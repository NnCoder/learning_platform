package com.edu.protal.service;

import java.util.List;
import java.util.Set;

import com.edu.common.pojo.QuestionQueryResult;
import com.edu.protal.controller.domain.PraticeHistory;

public interface QuestionService {
     List<QuestionQueryResult> getQuestionQueryResultListByFieldIdList(int kpId,List<Integer> typeIdList, int limit);
     
     List<QuestionQueryResult> getQuestionQueryResultListByIdSet(Set<Integer> idSet);
     
     void insertPraticeHistory(PraticeHistory ph);
     
     PraticeHistory getUserPraticeHistoryByUserAccountAndKpId(String userAccount, int kpId);
     
     int isUserPraticeHistoryExists(String userAccount, int kpId);
     
     int isPremAnswer(String userAccount, int courseId);
}
