package com.quinFS.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.quinFS.pojo.FileUploadResult;

public interface UploadService {
	/**
	 * 单文件上传
	 * 
	 * @param file
	 * @param savepath
	 * @return
	 */
	FileUploadResult upload(MultipartFile file, String savepath) throws Exception;

	/**
	 * 多文件上传
	 * 
	 * @param file
	 * @param savepath
	 * @return
	 */
	List<FileUploadResult> upload(MultipartFile[] files, String savepath) throws Exception;
	
	FileUploadResult delete(String filename, String savepath) throws Exception;
}
