package com.jesse.library.dao;

import com.jesse.library.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {
    @Select("SELECT * FROM book WHERE category_id=#{cid}")
    List<Book> selectBookListByCid(int cid);

    @Insert("<script>" +
            "INSERT INTO book(category_id,name,level,price,img_path,create_time,update_time) VALUES" +
            "<foreach collection='list' item='book' separator=','>" +
            "(#{book.categoryId}, #{book.name}, #{book.level}, #{book.price}, #{book.imgPath}, #{book.createTime},#{book.updateTime})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertListBook(List<Book> listBook);

    @Select("SELECT * FROM book ORDER BY id DESC")
    List<Book> selectAll();
}

