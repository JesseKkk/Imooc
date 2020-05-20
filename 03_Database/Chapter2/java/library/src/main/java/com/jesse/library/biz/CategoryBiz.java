package com.jesse.library.biz;

import com.jesse.library.entity.Category;

import java.util.List;

public interface CategoryBiz {
    List<Category> getCategoryList();

    void setCategory(Category category);
}

