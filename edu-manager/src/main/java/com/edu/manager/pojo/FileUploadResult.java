package com.edu.manager.pojo;

public class FileUploadResult {
	private int error;
	private String url;
	private String message;
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public FileUploadResult() {}
	
	public FileUploadResult(int error, String url, String message) {
		super();
		this.error = error;
		this.url = url;
		this.message = message;
	}
	public static FileUploadResult build(int error, String url, String message) {
		return new FileUploadResult(error, url, message);
	}
	
	public static FileUploadResult ok(String url) {
		return new FileUploadResult(0, url, "OK");
	}
}
