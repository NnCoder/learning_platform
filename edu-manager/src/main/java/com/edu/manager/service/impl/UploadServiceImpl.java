package com.edu.manager.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.utils.FileUtil;
import com.edu.common.utils.NameUtil;
import com.edu.manager.pojo.FileUploadResult;
import com.edu.manager.service.UploadService;


@Service
public class UploadServiceImpl implements UploadService{
	@Value("${SERVER_HOST}")
	private String SERVER_HOST;
	
	public FileUploadResult upload(MultipartFile file, String savepath) throws Exception{
		String filename = NameUtil.getName();
		String originalFilename = file.getOriginalFilename();
		//取后缀
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		//合并完整filename
		filename = filename + suffix;
		savepath = savepath + filename;
		FileUtil.transferTo(file.getInputStream(),new File(savepath));
		
		//返回文件名
		return FileUploadResult.ok(SERVER_HOST + filename);
	}

	public List<FileUploadResult> upload(MultipartFile[] files, String savepath) throws Exception{
		String filename = null;
		String originalFilename = null;
		//取后缀
		String suffix = null;
		//合并完整filename
		String filepath = null;
		List<FileUploadResult> results = new ArrayList<FileUploadResult>();
		for (MultipartFile file : files) {
			filename = NameUtil.getName();
			originalFilename = file.getOriginalFilename();
			suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			filename = filename + suffix;
			filepath = savepath + filename;
			file.transferTo(new File(filepath));
			results.add(FileUploadResult.ok(SERVER_HOST + filename));
		}
		return results;
	}

	public FileUploadResult delete(String filename, String savepath) throws Exception {
		File file = new File(savepath+filename);
		if (file.exists()) {
			file.delete();
		}
		return FileUploadResult.ok("");
	}
	
}
