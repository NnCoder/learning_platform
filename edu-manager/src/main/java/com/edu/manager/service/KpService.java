package com.edu.manager.service;

import java.util.List;

import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.KnowledgePointWithBLOBs;

/**
 * 知识点服务类
 * @Description TODO
 * @ClassName KpService
 * @author Tao
 * @date 2018年1月31日
 */
public interface KpService {
	EasyUIDataGridResult getKpList(Integer chapterId, int page, int rows);
	List<KnowledgePoint> getKpList(Integer chapterId);
	
	HttpResult createKp(KnowledgePointWithBLOBs knowledgePoint);
	HttpResult updateKp(KnowledgePointWithBLOBs knowledgePoint);
	/**
	 * 批量删除知识点
	 * @param ids
	 * @return
	 */
	HttpResult deleteKps(String ids);
	
	HttpResult deleteKp(Integer id);
	
	/**
	 * 删除知识点与和该知识点相关的所有文件
	 * @param id
	 * @return
	 */
	HttpResult deleteKpEx(Integer id);
}
