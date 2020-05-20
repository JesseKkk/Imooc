package com.jesse.library.biz;

import com.jesse.library.entity.Book;

import java.util.List;

public interface BookBiz {
    List<Book> getBookListByCid(int cid);

    void addListBook(List<Book> listBook);

    List<Book> getBookListAll();
}


