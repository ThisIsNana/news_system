package com.example.news_system.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewsRequest {


	@JsonProperty("news_title")
	private String newsTitle;

	@JsonProperty("news_create_date")
	private LocalDateTime newsCreateDate;

	@JsonProperty("news_update_name")
	private String newsUpdateName;

	@JsonProperty("news_category_id")
	private int newsCategoryId;

	@JsonProperty("news_description")
	private String newsDescription;
	
	

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public LocalDateTime getNewsCreateDate() {
		return newsCreateDate;
	}

	public void setNewsCreateDate(LocalDateTime newsCreateDate) {
		this.newsCreateDate = newsCreateDate;
	}

	public String getNewsUpdateName() {
		return newsUpdateName;
	}

	public void setNewsUpdateName(String newsUpdateName) {
		this.newsUpdateName = newsUpdateName;
	}

	public int getNewsCategoryId() {
		return newsCategoryId;
	}

	public void setNewsCategoryId(int newsCategoryId) {
		this.newsCategoryId = newsCategoryId;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	
	
	

}
