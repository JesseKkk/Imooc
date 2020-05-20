package com.jesse.service;

import java.util.List;

import com.jesse.domain.Category;

public interface CategoryService {

	List<Category> findAll();

	void save(Category category);

	Category finOne(Integer cid);

	void update(Category category);

	void delete(Integer cid);

}
