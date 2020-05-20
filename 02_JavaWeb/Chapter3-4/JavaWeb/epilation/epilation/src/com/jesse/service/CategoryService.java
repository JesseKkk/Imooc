package com.jesse.service;

import java.util.List;

import com.jesse.domain.Category;

public interface CategoryService {

	boolean add(List<Category> categoryList, Category category);

	void delete(List<Category> categoryList, String categoryId);

}
