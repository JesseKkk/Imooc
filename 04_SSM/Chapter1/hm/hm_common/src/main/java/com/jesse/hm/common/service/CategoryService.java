package com.jesse.hm.common.service;

import com.jesse.hm.common.entity.Category;

import java.util.List;

/**
 * Created by Kong on 2020/5/21.
 */
public interface CategoryService {
    void add(Category category);
    void remove(Integer id);
    void edit(Category category);
    Category get(Integer id);
    List<Category> getAll();
}
