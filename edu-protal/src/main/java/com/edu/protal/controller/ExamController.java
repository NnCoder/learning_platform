package com.edu.protal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.AnswerSheetItem;
import com.edu.common.pojo.QuestionQueryResult;
import com.edu.protal.controller.domain.ExamFinishParam;
import com.edu.protal.controller.domain.Message;
import com.edu.protal.controller.domain.PraticeHistory;
import com.edu.protal.controller.domain.QuestionAdapter;
import com.edu.protal.pojo.QuestionHistory;
import com.edu.protal.pojo.User;
import com.edu.protal.service.CourseService;
import com.edu.protal.service.QuestionService;
import com.edu.protal.util.Object2Xml;

@Controller
public class ExamController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/student/practice-test", method = RequestMethod.GET)
	public String practiceStartNew(Model model, HttpServletRequest request,
			@RequestParam(value = "kp") int knowledgepoint, int courseId) {
		
		String strUrl = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() + "/";
		User user = (User) request.getSession().getAttribute("user");
		if(questionService.isPremAnswer(user.getUserAccount(), courseId)==0) {
			return "error/400";
		}
		
		if(questionService.isUserPraticeHistoryExists(user.getUserAccount(), knowledgepoint)!=0) {
			return "redirect:exam-report.html?kpId="+knowledgepoint;
		}
		List<Integer> typeIdList = new ArrayList<Integer>();
		typeIdList.add(1);
		typeIdList.add(2);
		typeIdList.add(3);
		typeIdList.add(4);
		List<QuestionQueryResult> qqrList = questionService.getQuestionQueryResultListByFieldIdList(knowledgepoint,typeIdList, 20);
		
		int amount = qqrList.size();
		StringBuilder sb = new StringBuilder();
		for(QuestionQueryResult qqr : qqrList){
			QuestionAdapter adapter = new QuestionAdapter(qqr,strUrl);
			sb.append(adapter.getStringFromXML(false,true,false));
		}
		model.addAttribute("kpId", knowledgepoint);
		model.addAttribute("courseId", courseId);
		model.addAttribute("htmlStr", sb.toString());
		model.addAttribute("amount", amount);
		model.addAttribute("fieldName", "强化练习");
		return "student/examing";
	}
	
	@RequestMapping(value = "/student/practice-improve", method = RequestMethod.POST)
	public @ResponseBody Message practiceSubmit(@RequestBody QuestionHistory qh, HttpServletRequest request) {
		Message message = new Message();
		if(qh.getAnswer().equals(qh.getMyAnswer())) {
			User user = (User) request.getSession().getAttribute("user");
			courseService.improveStudentScore(user, qh.getCourseId(), qh.getQuestionTypeId());
		}
		return message;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/student/exam-report", method = RequestMethod.GET)
	public String examFinishPage(Model model,
		    int kpId,
			HttpServletRequest request) {
		String strUrl = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() + "/";
		User user = (User) request.getSession().getAttribute("user");
		if(!user.getRole().startsWith("s")) {
			return "page-login";
		}
		PraticeHistory examHistory = questionService.getUserPraticeHistoryByUserAccountAndKpId(user.getUserAccount(), kpId);
		
		List<QuestionQueryResult> questionList = Object2Xml.toBean(
				examHistory.getContent(), ArrayList.class);
		HashMap<Integer, AnswerSheetItem> hm = Object2Xml.toBean(
				examHistory.getAnswerSheet(), HashMap.class);

		StringBuilder sb = new StringBuilder();
		for (QuestionQueryResult q : questionList) {
			QuestionAdapter adapter = new QuestionAdapter(hm.get(q
					.getQuestionId()), q, strUrl);
			sb.append(adapter.getReportStringFromXML());
		}
		
		
		model.addAttribute("htmlStr", sb.toString());
		return "student/exam-finsh-report";
	}
	
	
	@RequestMapping(value="/student/exam-submit", method = RequestMethod.POST)
	public @ResponseBody Message examSubmit(@RequestBody ExamFinishParam efp, HttpServletRequest request) {
		
		Message message = new Message();
		
		User user = (User) request.getSession().getAttribute("user");
		if(!user.getRole().startsWith("s")) {
			message.setResult("只有学生才能参加测试!");
			return message;
		}
		int pointGet = 0;
		Set<Integer> pIdSet = efp.getAs().keySet();
		List<QuestionQueryResult> qrl = questionService.getQuestionQueryResultListByIdSet(pIdSet);
		for(QuestionQueryResult qResult : qrl) {
			String answer = qResult.getAnswer();
			String myAnswer = efp.getAs().get(qResult.getQuestionId()).getAnswer();
			if(answer.equals(myAnswer)) {
				pointGet += qResult.getQuestionTypeId();
			}
		}
		
		courseService.improveStudentScore(user, efp.getCourseId(), (int)pointGet);
		PraticeHistory ph = new PraticeHistory();
		
		ph.setKpId(efp.getKpId());
		ph.setCreateTime(new Date());
		ph.setContent(Object2Xml.toXml(qrl));
		ph.setUserAccount(user.getUserAccount());
		ph.setPointGet(pointGet);
		ph.setPaperName("知识点强化训练");
		ph.setAnswerSheet(Object2Xml.toXml(efp.getAs()));
		ph.setSubmitTime(new Date());
		ph.setDuration(efp.getDuration());
		questionService.insertPraticeHistory(ph);
		message.setObject(ph.getId());
		return message;
	}
	
}
