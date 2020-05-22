package com.jesse.hm.common.dao;

import com.jesse.hm.common.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/5/21.
 */
@Repository("categoryDao")
public interface CategoryDao {
    void insert(Category category);
    void delete(Integer id);
    void update(Category category);
    Category selectById(Integer id);
    List<Category> selectAll();
}
