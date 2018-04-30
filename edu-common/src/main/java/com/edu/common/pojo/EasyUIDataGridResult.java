package com.edu.common.pojo;

import java.util.List;

public class EasyUIDataGridResult {
	
	private int status;
	
	private long total;
	//?代表可传入任意类型
	private List<?> rows;
	
	public EasyUIDataGridResult() {
		this.setStatus(200);
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
