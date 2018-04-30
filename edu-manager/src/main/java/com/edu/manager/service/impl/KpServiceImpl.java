package com.edu.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.KnowledgePointMapper;
import com.edu.common.pojo.Data;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.KnowledgePointExample;
import com.edu.common.pojo.KnowledgePointWithBLOBs;
import com.edu.common.pojo.Video;
import com.edu.manager.service.DataService;
import com.edu.manager.service.KpService;
import com.edu.manager.service.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class KpServiceImpl implements KpService {
	@Autowired
	private KnowledgePointMapper knowledgePointMapper;
	@Autowired
	private VideoService videoService;
	@Autowired
	private DataService dataService;

	@Override
	public EasyUIDataGridResult getKpList(Integer chapterId, int page, int rows) {
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		// 分页插件
		PageHelper.startPage(page, rows);
		// 查询该章节所有知识点
		KnowledgePointExample example = new KnowledgePointExample();
		KnowledgePointExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		criteria.andStateEqualTo((byte) 1);
		List<KnowledgePointWithBLOBs> list = knowledgePointMapper.selectByExampleWithBLOBs(example);
		PageInfo<KnowledgePointWithBLOBs> pageInfo = new PageInfo<>(list);
		result.setRows(list);
		// 得到知识点总数
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public HttpResult createKp(KnowledgePointWithBLOBs knowledgePoint) {
		int kpId = knowledgePointMapper.insertSelective(knowledgePoint);
		return HttpResult.ok(kpId);
	}

	@Override
	public HttpResult updateKp(KnowledgePointWithBLOBs knowledgePoint) {
		knowledgePointMapper.updateByPrimaryKeySelective(knowledgePoint);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteKps(String ids) {
		String[] strings = ids.split(",");
		List<Video> videos = null;
		List<Data> datas = null;
		for (String id : strings) {
			int idInt = Integer.parseInt(id);
			// 删除知识点

			deleteKp(idInt);
			// 删除该知识点下所有视频及资料
			videos = videoService.getVideoListByKpId(idInt);
			for (Video video : videos) {
				videoService.deleteVideo(video.getVedioId());
			}
			// 删除普通资料
			datas = dataService.getDataListByKpId(idInt, 1);
			for (Data data : datas) {
				dataService.deleteData(data.getDataId());
			}
			// 删除测试资料
			datas = dataService.getDataListByKpId(idInt, 2);
			for (Data data : datas) {
				dataService.deleteData(data.getDataId());
			}
		}
		return HttpResult.ok();
	}

	@Override
	public List<KnowledgePoint> getKpList(Integer chapterId) {
		// 查询该章节所有知识点
		KnowledgePointExample example = new KnowledgePointExample();
		KnowledgePointExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		criteria.andStateEqualTo((byte) 1);
		List<KnowledgePoint> list = knowledgePointMapper.selectByExample(example);
		// 得到知识点总数
		return list;
	}

	@Override
	public HttpResult deleteKp(Integer id) {
		KnowledgePointWithBLOBs kp = new KnowledgePointWithBLOBs();
		kp.setKpId(id);
		kp.setState((byte) 0);
		knowledgePointMapper.updateByPrimaryKeySelective(kp);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteKpEx(Integer id) {
		List<Video> videos = null;
		List<Data> datas = null;
		
		// 删除该知识点下所有视频及资料
		videos = videoService.getVideoListByKpId(id);
		for (Video video : videos) {
			videoService.deleteVideoEx(video.getVedioId());
		}
		// 删除普通资料
		datas = dataService.getDataListByKpId(id, 1);
		for (Data data : datas) {
			dataService.deleteData(data.getDataId());
		}
		// 删除测试资料
		datas = dataService.getDataListByKpId(id, 2);
		for (Data data : datas) {
			dataService.deleteData(data.getDataId());
		}
		// 删除知识点
		deleteKp(id);
		return HttpResult.ok();
	}

}
