package com.jesse.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jesse.domain.Category;
import com.jesse.service.CategoryService;

public class CategoryServiceImp implements CategoryService {
	private static final List<Category> categoryDb = new ArrayList<Category>() ;
	
	public static List<Category> getCategorydb() {
		return categoryDb;
	}

	@Override
	public boolean add(List<Category> categoryList, Category category) {
		for(Category c : categoryList) {
			if(c.equals(category)) {
				return  false;
			}
		}
		categoryList.add(category);
		//按照id对所有图书分类排序
		Collections.sort(categoryList);
		return true;
	}

	@Override
	public void delete(List<Category> categoryList, String categoryId) {
		int index = 0;
		for(Category c : categoryList) {
			if(c.getCategoryId().equals(categoryId)) {
				break;
			}
			index += 1;
		}
		categoryList.remove(index);
	}

}
