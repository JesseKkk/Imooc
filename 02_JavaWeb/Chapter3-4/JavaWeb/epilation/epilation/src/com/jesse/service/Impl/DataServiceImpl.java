package com.jesse.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jesse.domain.Data;
import com.jesse.service.DataService;

public class DataServiceImpl implements DataService {
	private static final List<Data> dataList = new ArrayList<Data>();

	public static List<Data> getDatalist() {
		return dataList;
	}

	@Override
	public boolean add(List<Data> dataList, Data data) {
		for(Data b : dataList) {
			if(b.equals(data)) {
				return false;
			}
		}
		dataList.add(data);
		//根据图书编号对所有图书进行排序
		Collections.sort(dataList);
		return true;
	}

	@Override
	public void delete(List<Data> dataList, String dataId) {
		int index = 0;
		for(Data d : dataList) {
			if(d.getDataId().equals(dataId)) {
				break;
			}
			index +=1;
		}
		dataList.remove(index);
	}
	
	@Override
	public void update(List<Data> dataList, Data data) {
		//先根据id删除之前的book
		this.delete(dataList, data.getDataId());
		//添加新的book
		this.add(dataList, data);
	}

	@Override
	public List<Data> query(List<Data> dataList, String searchContent) {
		List<Data> queryList = new ArrayList<>();
		//按id、图书名、分类依次进行查询
		for(Data d : dataList) {
			if(d.getDataId().equals(searchContent) || d.getDataName().equals(searchContent) || d.getCategoryName().equals(searchContent)) {
				queryList.add(d);
			}
		}
		return queryList;
	}

}
