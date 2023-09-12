package com.example.news_system.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchNewsRequest {
	
	@JsonProperty("search_title")
	private String title;
	
	@JsonProperty("search_start_date")
	private LocalDate startDate;
	
	@JsonProperty("search_end_date")
	private LocalDate endDate;
	
	@JsonProperty("search_category_father")
	private String categoryFather;
	
	@JsonProperty("search_category_child")
	private String categoryChild;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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
