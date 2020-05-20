package com.jesse.service.impl;

import java.util.List;

import com.jesse.dao.ProductDao;
import com.jesse.dao.impl.ProductDaoImpl;
import com.jesse.domain.PageBean;
import com.jesse.domain.Product;
import com.jesse.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findAll() {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findAll();
	}

	@Override
	public void save(Product product) {
		ProductDao productDao = new ProductDaoImpl();
		productDao.save(product);
	}

	@Override
	public Product findOne(Integer pid) {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findOne(pid);
	}

	@Override
	public void update(Product product) {
		ProductDao productDao = new ProductDaoImpl();
		productDao.update(product);		
	}

	@Override
	public void delete(Integer pid) {
		ProductDao productDao = new ProductDaoImpl();
		productDao.delete(pid);	
	}

	@Override
	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//封装的当前的页数：
		pageBean.setPage(page);
		//封装每页显示记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//封装总记录数：
		ProductDao productDao =new ProductDaoImpl();
		int totalCount = productDao.findCount();
		pageBean.setTotalPage(totalCount);
		//封装总页数：（根据总记录数进行计算）
		int totalPage = 0;
		if(totalCount %limit == 0) {
			totalPage = totalCount / limit;
		}else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//封装每页显示数据的集合：select * from xx limit begin,limit;
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

}
