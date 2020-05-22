package com.jesse.hm.common.service.impl;

import com.jesse.hm.common.dao.CategoryDao;
import com.jesse.hm.common.entity.Category;
import com.jesse.hm.common.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kong on 2020/5/21.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public void add(Category category) {
        categoryDao.insert(category);
    }

    public void remove(Integer id) {
        categoryDao.delete(id);
    }

    public void edit(Category category) {
        categoryDao.update(category);
    }

    public Category get(Integer id) {
        return categoryDao.selectById(id);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
