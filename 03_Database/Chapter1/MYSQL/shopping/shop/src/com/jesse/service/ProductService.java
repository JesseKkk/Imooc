package com.jesse.service;

import java.util.List;

import com.jesse.domain.PageBean;
import com.jesse.domain.Product;

public interface ProductService {

	List<Product> findAll();

	void save(Product product);

	Product findOne(Integer pid);

	void update(Product product);

	void delete(Integer pid);

	PageBean<Product> findByPage(int page);
}
