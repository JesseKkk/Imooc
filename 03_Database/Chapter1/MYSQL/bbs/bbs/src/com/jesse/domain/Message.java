package com.jesse.domain;

import java.util.Date;

public class Message {
	private Integer mid;
	private String title;
	private String content;
	private String createTime;
	private User user = new User();
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", user=" + user + "]";
	}
	
}
