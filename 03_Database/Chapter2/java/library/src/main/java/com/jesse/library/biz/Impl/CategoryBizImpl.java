package com.jesse.library.biz.Impl;

import com.jesse.library.biz.CategoryBiz;
import com.jesse.library.dao.CategoryDao;
import com.jesse.library.entity.Category;
import com.jesse.library.utils.DaoFactory;

import java.util.List;

public class CategoryBizImpl implements CategoryBiz {
    private CategoryDao categoryDao = DaoFactory.getInstance().getDao(CategoryDao.class);

    public List<Category> getCategoryList() {
        return categoryDao.selectAll();
    }

    public void setCategory(Category category) {
        categoryDao.insert(category);
    }
}
