package com.jesse.library.biz.Impl;

import com.jesse.library.biz.BookBiz;
import com.jesse.library.dao.BookDao;
import com.jesse.library.entity.Book;
import com.jesse.library.utils.DaoFactory;

import java.util.List;

public class BookBizImpl implements BookBiz {
    private BookDao bookDao = DaoFactory.getInstance().getDao(BookDao.class);

    public List<Book> getBookListByCid(int cid) {
        return bookDao.selectBookListByCid(cid);
    }

    public void addListBook(List<Book> listBook) {
        bookDao.insertListBook(listBook);
    }

    public List<Book> getBookListAll() {
        return bookDao.selectAll();
    }
}
