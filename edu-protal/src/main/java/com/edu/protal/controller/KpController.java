package com.edu.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.Video;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.pojo.KpDetail;
import com.edu.protal.service.KpService;

@Controller
public class KpController {
	
	@Autowired
	private KpService kpService;
	
	@GetMapping("/kp/{kpId}/detail")
	public String getKpDetailById(@PathVariable int kpId, Model model) {
		KpDetail detail = kpService.getKpDetailById(kpId);
		model.addAttribute("kpDetail", detail);
		return "kp/kp-detail";
	}
	
	@GetMapping("/kp/{kpId}")
	public String getKpById(@PathVariable int kpId, Model model) {
		KnowledgePoint knowledgePoint = kpService.getKpById(kpId);
		List<Data> normalDatas = kpService.getDataByIdAndType(kpId, 1);
		List<Data> testDatas = kpService.getDataByIdAndType(kpId, 2);
		model.addAttribute("kp", knowledgePoint);
		model.addAttribute("normalDatas", normalDatas);
		model.addAttribute("testDatas", testDatas);
		return "kp/kp-another";
	}
	
	@GetMapping("/kp/{kpId}/videos")
	public String getKpVideosById(@PathVariable int kpId, Model model) {
		List<Video> videos = kpService.getVedioById(kpId);
		model.addAttribute("videos", videos);
		return "kp/kp-videos";
	}
	
	@GetMapping("/kp/{kpId}/datas")
	public String getKpDatasById(@PathVariable int kpId, int type, Model model) {
		List<Data> datas = kpService.getDataByIdAndType(kpId, type);
		model.addAttribute("datas", datas);
		return "kp/kp-datas";
	}
	
	@GetMapping("/kp/{kpId}/comments")
	public String getKpCommentsById(@PathVariable int kpId,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int rows,
			Model model) {
		List<CommentVo> list = kpService.getCommentsByKpId(kpId, page, rows);
		model.addAttribute("comments", list);
		model.addAttribute("kpId", kpId);
		return "kp/kp-comment";
	}
	
}
