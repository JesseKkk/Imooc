package com.jesse.service;

import java.util.List;

import com.jesse.domain.Data;

public interface DataService {

	boolean add(List<Data> dataList, Data data);

	void delete(List<Data> dataList, String dataId);
	
	void update(List<Data> dataList, Data data);

	List<Data> query(List<Data> dataList, String searchContent);

}
