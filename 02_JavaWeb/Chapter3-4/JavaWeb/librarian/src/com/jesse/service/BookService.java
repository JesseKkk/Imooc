package com.jesse.service;

import java.util.List;

import com.jesse.domain.Book;

public interface BookService {

	boolean add(List<Book> bookList, Book book);

	void delete(List<Book> bookList, String bookId);

	void update(List<Book> bookList, Book book);

	List<Book> query(List<Book> bookList, String searchContent);

}
