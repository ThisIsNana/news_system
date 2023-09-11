package com.example.news_system.vo;

import java.util.List;

import com.example.news_system.entity.Category;

public class CategoryResponse {

	private List<Category> categoryList;

	private Category category;

	private String Message;

	// ========================================================

	public CategoryResponse() {
		super();
	}

	public CategoryResponse(String message) {
		super();
		Message = message;
	}

	public CategoryResponse(Category category, String message) {
		super();
		this.category = category;
		Message = message;
	}

	public CategoryResponse(List<Category> categoryList, String message) {
		super();
		this.categoryList = categoryList;
		Message = message;
	}
	
	// ========================================================

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
