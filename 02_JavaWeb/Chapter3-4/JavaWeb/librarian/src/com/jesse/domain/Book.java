package com.jesse.domain;

public class Book implements Comparable<Book> {
	private String bookId;
	private String bookName;
	private String categoryName;
	private String bookPrice;
	private String bookPic;
	private String remarks;
	
	public Book() {
		
	}

	public Book(String bookId, String bookName, String categoryName, String bookPrice, String bookPic, String remarks) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.categoryName = categoryName;
		this.bookPrice = bookPrice;
		this.bookPic = bookPic;
		this.remarks = remarks;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPic() {
		return bookPic;
	}

	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() == Book.class) {
			Book book = (Book)obj;
			return (book.bookId.equals(bookId));
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", categoryName=" + categoryName + ", bookPrice="
				+ bookPrice + ", bookPic=" + bookPic + ", remarks=" + remarks + "]";
	}

	@Override
	public int compareTo(Book o) {
		
		return this.getBookId().compareTo(o.getBookId());
	}
	
	
}
