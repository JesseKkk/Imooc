package com.jesse.domain;

public class Category implements Comparable<Category> {
	private String categoryId;
	private String categoryName;
	
	public Category() {
		
	}
	
	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() == Category.class) {
			Category cate = (Category)obj;
			return (cate.getCategoryId().equals(categoryId) || cate.getCategoryName().equals(categoryName));
		}
		return false;
	}

	@Override
	public int compareTo(Category o) {
		
		return this.categoryId.compareTo(o.categoryId);
	}

	
}
