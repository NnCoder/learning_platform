package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.Data;

public interface DataService {	
	List<Data> getDataRecent(int limit);
}
