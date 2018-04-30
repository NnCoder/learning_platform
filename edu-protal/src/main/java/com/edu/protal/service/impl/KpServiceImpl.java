package com.edu.protal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.KnowledgePointWithBLOBs;
import com.edu.common.pojo.Video;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.pojo.KpDetail;
import com.edu.protal.service.KpService;
@Service
public class KpServiceImpl implements KpService{

	@Value("${REST_KP_URL}")
	private String REST_KP_URL;
	
	@Override
	public KnowledgePoint getKpById(int kpId) {
		String jsonData = HttpClientUtil.doGet(REST_KP_URL+"/"+kpId);
		HttpResult result = HttpResult.formatToPojo(jsonData, KnowledgePointWithBLOBs.class);
		KnowledgePoint kPoint = (KnowledgePoint) result.getData();
		return kPoint;
	}

	@Override
	public List<Data> getDataByIdAndType(int kpId, int type) {
		String jsonData = HttpClientUtil.doGet(REST_KP_URL+"/"+kpId+"/datas?type="+type);
		List<Data> datas = JsonUtils.jsonToList(jsonData, Data.class);
		return datas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> getVedioById(int kpId) {
		String jsonData = HttpClientUtil.doGet(REST_KP_URL+"/"+kpId+"/videos");
		HttpResult result = HttpResult.formatToList(jsonData, Video.class);
		List<Video> videos = (List<Video>) result.getData();
		return videos;
	}

	@Override
	public KpDetail getKpDetailById(int kpId) {
		KnowledgePoint kPoint = getKpById(kpId);
		List<Data> normalDatas = getDataByIdAndType(kpId, 1); 
		List<Data> testDatas = getDataByIdAndType(kpId, 2);
		List<Video> videos = getVedioById(kpId);
		KpDetail kpDetail = new KpDetail();
		kpDetail.setKnowledgePoint(kPoint);
		kpDetail.setNormalDatas(normalDatas);
		kpDetail.setTestDatas(testDatas);
		kpDetail.setVideos(videos);
		return kpDetail;
	}

	@Override
	public List<CommentVo> getCommentsByKpId(int kpId, int page, int rows) {
		Map<String, String> params = new HashMap<>();
		params.put("page", String.valueOf(page));
		params.put("rows", String.valueOf(rows));
		String jsonData = HttpClientUtil.doGet(REST_KP_URL+"/"+kpId+"/comments", params);
		List<CommentVo> list = JsonUtils.jsonToList(jsonData, CommentVo.class);
		return list;
	}

}
