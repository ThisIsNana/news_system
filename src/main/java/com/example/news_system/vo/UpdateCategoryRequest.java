package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCategoryRequest {
	
	@JsonProperty("update_category_id")
	private int categoryId;

	@JsonProperty("update_category_father")
	private String categoryFather;

	@JsonProperty("update_category_child")
	private String categoryChild;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryFather() {
		return categoryFather;
	}

	public void setCategoryFather(String categoryFather) {
		this.categoryFather = categoryFather;
	}

	public String getCategoryChild() {
		return categoryChild;
	}

	public void setCategoryChild(String categoryChild) {
		this.categoryChild = categoryChild;
	}
	
	

}
