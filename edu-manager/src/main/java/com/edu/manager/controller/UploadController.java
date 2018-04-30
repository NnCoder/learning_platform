package com.edu.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.manager.pojo.FileUploadResult;
import com.edu.manager.service.UploadService;


@Controller
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@CrossOrigin //跨域访问
	@RequestMapping(value="/upload/file", method=RequestMethod.POST)
	@ResponseBody
	public FileUploadResult upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			String savepath = request.getSession().getServletContext().getRealPath("/file/") + "/";
			FileUploadResult result = uploadService.upload(file, savepath);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return FileUploadResult.build(1, null, e.getMessage());
		}
	}
	
	
	@CrossOrigin //跨域访问
	@RequestMapping(value="/upload/files", method=RequestMethod.POST)
	@ResponseBody
	public Object upload(MultipartFile[] files, HttpServletRequest request) {
		try {
			String savepath = request.getSession().getServletContext().getRealPath("/file/") + "/";
			List<FileUploadResult> result = uploadService.upload(files, savepath);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return FileUploadResult.build(1, null, e.getMessage());
		}
	}
	
	@CrossOrigin //跨域访问
	@RequestMapping(value="/file/{filename}/delete", method=RequestMethod.GET)
	@ResponseBody
	public Object deleteFile(@PathVariable String filename, HttpServletRequest request) {
		try {
			String savepath = request.getSession().getServletContext().getRealPath("/file/") + "/";
			FileUploadResult result = uploadService.delete(filename, savepath);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return FileUploadResult.build(1, null, e.getMessage());
		}
	}
}
