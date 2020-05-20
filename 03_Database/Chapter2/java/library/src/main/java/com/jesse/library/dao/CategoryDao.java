package com.jesse.library.dao;

import com.jesse.library.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {
    @Select("SELECT * FROM category")
    List<Category> selectAll();

    @Insert("INSERT INTO category(name,create_time) VALUES (#{name}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Category category);
}
