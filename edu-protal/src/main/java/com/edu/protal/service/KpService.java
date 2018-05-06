package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.Video;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.pojo.KpDetail;
import com.edu.protal.pojo.PageResult;

public interface KpService {
	
	public KpDetail getKpDetailById(int kpId);
	
	public KnowledgePoint getKpById(int kpId);
	
	PageResult getCommentsByKpId(int kpId, int page, int rows);
	/**
	 * 通过知识点id和类型来获取资料
	 * @param kpId
	 * @param type
	 * @return
	 */
	public List<Data> getDataByIdAndType(int kpId, int type);
	
	public List<Video> getVedioById(int kpId);
}
