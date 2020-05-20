package com.jesse.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jesse.domain.Book;
import com.jesse.domain.Category;
import com.jesse.service.BookService;

public class BookServiceImp implements BookService {
	private static final List<Book> bookList = new ArrayList<Book>();

	public static List<Book> getBooklist() {
		return bookList;
	}

	@Override
	public boolean add(List<Book> bookList, Book book) {
		for(Book b : bookList) {
			if(b.equals(book)) {
				return false;
			}
		}
		bookList.add(book);
		//根据图书编号对所有图书进行排序
		Collections.sort(bookList);
		return true;
	}

	@Override
	public void delete(List<Book> bookList, String bookId) {
		int index =0;
		for(Book b : bookList) {
			if(b.getBookId().equals(bookId)) {
				break;
			}
			index +=1;
		}
		bookList.remove(index);
	}

	@Override
	public void update(List<Book> bookList, Book book) {
		//先根据id删除之前的book
		this.delete(bookList, book.getBookId());
		//添加新的book
		this.add(bookList, book);
		
	}

	@Override
	public List<Book> query(List<Book> bookList, String searchContent) {
		List<Book> queryList = new ArrayList<>();
		//按id、图书名、分类依次进行查询
		for(Book b : bookList) {
			if(b.getBookId().equals(searchContent) || b.getBookName().equals(searchContent) || b.getCategoryName().equals(searchContent)) {
				queryList.add(b);
			}
		}
		return queryList;
	}
	
}
