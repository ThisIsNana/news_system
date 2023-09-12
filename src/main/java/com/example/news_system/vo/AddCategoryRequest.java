package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCategoryRequest {
	
	
	@JsonProperty("add_category_father")
	private String categoryFather;
	
	@JsonProperty("add_category_child")
	private String categoryChild;

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
