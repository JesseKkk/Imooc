package com.jesse.domain;

import java.util.List;

public class PageBean {
	private int page;//当前的页数
	private int limit;//每页显示的记录数
	private int totalCount;//总的记录数
	private int totalPage;//总页数
	private List<Message> list;//每页显示的数据的集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Message> getList() {
		return list;
	}
	public void setList(List<Message> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", limit=" + limit + ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", list=" + list + "]";
	}
	
}
