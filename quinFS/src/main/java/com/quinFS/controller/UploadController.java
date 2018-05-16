package com.quinFS.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.quinFS.pojo.FileUploadResult;
import com.quinFS.service.UploadService;
import com.quinFS.utils.CookieUtils;
import com.quinFS.utils.JedisClient;
import com.quinFS.utils.NameUtil;

@Controller
public class UploadController {
	private final static Logger logger = Logger.getLogger(UploadController.class);
	
	@Autowired
	private UploadService uploadService;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	
	
	@Value("${SERVER_HOST}")
	private String SERVER_HOST;
	
	@RequestMapping(value="/upload/filechunk",method=RequestMethod.POST)
	@ResponseBody
	public FileUploadResult uploadEx(HttpServletRequest request, HttpServletResponse response) {
		
		
		try { 
		      boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		      if (isMultipart) { 
		        FileItemFactory factory = new DiskFileItemFactory(); 
		        ServletFileUpload upload = new ServletFileUpload(factory); 
		        // 得到所有的表单域，它们目前都被当作FileItem
		        List<FileItem> fileItems = upload.parseRequest(request); 
		        String id = ""; 
		        String fileName = ""; 
		        // 如果大于1说明是分片处理 
		        int chunks = 1; 
		        int chunk = 0; 
		        FileItem tempFileItem = null; 
		        for (FileItem fileItem : fileItems) { 
		          if (fileItem.getFieldName().equals("id")) { 
		            id = fileItem.getString();
		            logger.info(id);
		          } else if (fileItem.getFieldName().equals("name")) { 
		            fileName = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8"); 
		            logger.info(fileName);
		          } else if (fileItem.getFieldName().equals("chunks")) { 
		
		            chunks = NumberUtils.parseNumber(fileItem.getString(), Integer.class); 
		            logger.info(chunks);
		          } else if (fileItem.getFieldName().equals("chunk")) { 
		            chunk = NumberUtils.parseNumber(fileItem.getString(), Integer.class);  
		            logger.info(chunk);
		          } else if (fileItem.getFieldName().equals("file")) { 
		            tempFileItem = fileItem; 
		          } 
		        }
		        
		        //session中的参数设置获取是我自己的原因,文件名你们可以直接使用fileName,这个是原来的文件名 
		        String fileSysName = NameUtil.getName();; 
		        String realname = fileSysName+fileName.substring(fileName.lastIndexOf("."));//转化后的文件名 
		        String filePath = request.getSession().getServletContext().getRealPath("/file/") + "/";//文件上传路径 
		        // 临时目录用来存放所有分片文件 
		        String tempFileDir = filePath + id;
		        File parentFileDir = new File(tempFileDir); 
		        if (!parentFileDir.exists()) { 
		          parentFileDir.mkdirs(); 
		        } 
		        // 分片处理时，前台会多次调用上传接口，每次都会上传文件的一部分到后台 
		        File tempPartFile = new File(parentFileDir, realname + "_" + chunk + ".part"); 
		        FileUtils.copyInputStreamToFile(tempFileItem.getInputStream(), tempPartFile); 
		        // 是否全部上传完成 
		        // 所有分片都存在才说明整个文件上传完成 
		        boolean uploadDone = true; 
		        for (int i = 0; i < chunks; i++) { 
		          File partFile = new File(parentFileDir, realname + "_" + i + ".part"); 
		          if (!partFile.exists()) { 
		            uploadDone = false; 
		          } 
		        } 
		        // 所有分片文件都上传完成 
		        // 将所有分片文件合并到一个文件中 
		        if (uploadDone) { 
		          // 得到 destTempFile 就是最终的文件 
		          File destTempFile = new File(filePath, realname); 
		          for (int i = 0; i < chunks; i++) { 
		            File partFile = new File(parentFileDir, realname + "_" + i + ".part"); 
		            FileOutputStream destTempfos = new FileOutputStream(destTempFile, true); 
		            //遍历"所有分片文件"到"最终文件"中 
		            FileUtils.copyFile(partFile, destTempfos); 
		            destTempfos.close(); 
		          } 
		          // 删除临时目录中的分片文件 
		        //返回文件名
		          FileUtils.deleteDirectory(parentFileDir);
		          return FileUploadResult.ok(SERVER_HOST + realname);
		        } else { 
		          // 临时文件创建失败 
		          if (chunk == chunks -1) { 
		            FileUtils.deleteDirectory(parentFileDir); 
		          } 
		        } 
		      } 
		    } catch (Exception e) { 
		      logger.error(e.getMessage(), e); 
		    }
		return FileUploadResult.build(1, "", "文件上传错误!"); 
	}
	
	@CrossOrigin //跨域访问
	@RequestMapping(value="/upload/file", method=RequestMethod.POST)
	@ResponseBody
	public FileUploadResult upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String token) {
		String uRedisKey = REDIS_SESSION_KEY + ":" +token;
		String pass = jedisClient.get(uRedisKey);
		if(pass != null || !pass.equals("")) {
			logger.info("上传文件开始!");
			try {
				String savepath = request.getSession().getServletContext().getRealPath("/file/") + "/";
				FileUploadResult result = uploadService.upload(file, savepath);
				logger.info("文件上传完成");
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("上传文件错误!");
				return FileUploadResult.build(1, null, e.getMessage());
			}
		}else {
			return FileUploadResult.build(1, null, "SESSION超时，请重新登录!");
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
