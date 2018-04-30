package com.edu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.NoticeMapper;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;
import com.edu.common.pojo.NoticeExample;
import com.edu.manager.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public EasyUIDataGridResult getNoticeList(int page, int rows) {
		//分页
		PageHelper.startPage(page, rows);
		//检索数据库
		NoticeExample example = new NoticeExample();
		List<Notice> list = noticeMapper.selectByExample(example);
		//查看内容处理
		for (Notice notice : list) {
			int id = notice.getNoticeId();
			notice.setNoticeContent("admin/notice/content/"+id);
		}
		//获取分页信息
		PageInfo<Notice> pageInfo = new PageInfo<>(list);
		//包装成easyui所需数据
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public HttpResult deleteNotices(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] strs = ids.split(",");
			for (String string : strs) {
				deleteNoticeById(Integer.parseInt(string));
			}
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateNotice(Notice notice) {
		noticeMapper.updateByPrimaryKeySelective(notice);
		return HttpResult.ok();
	}

	@Override
	public Notice getNoticeById(Integer id) {
		Notice notice = noticeMapper.selectByPrimaryKey(id);
		return notice;
	}

	@Override
	public HttpResult deleteNoticeById(Integer id) {
		noticeMapper.deleteByPrimaryKey(id);
		return HttpResult.ok();
	}

	@Override
	public HttpResult insertNotice(Notice notice) {
		notice.setNoticeTime(new Date());
		noticeMapper.insertSelective(notice);
		return HttpResult.ok();
	}
	
	
}
