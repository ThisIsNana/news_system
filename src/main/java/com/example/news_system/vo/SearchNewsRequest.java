package com.example.news_system.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchNewsRequest {

	@JsonProperty("search_title")
	private String title;

	@JsonProperty("search_start_date")
	private LocalDateTime startDate;

	@JsonProperty("search_end_date")
	private LocalDateTime endDate;

	@JsonProperty("search_category_father")
	private String categoryFather;

	@JsonProperty("search_category_child")
	private String categoryChild;

	@JsonProperty("search_news_user")
	private String searchNewsUser;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
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

	public String getSearchNewsUser() {
		return searchNewsUser;
	}

	public void setSearchNewsUser(String searchNewsUser) {
		this.searchNewsUser = searchNewsUser;
	}

}
