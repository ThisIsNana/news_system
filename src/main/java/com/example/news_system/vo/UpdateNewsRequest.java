package com.example.news_system.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateNewsRequest {


	@JsonProperty("update_news_id")
	private int newsId;
	
	@JsonProperty("update_news_title")
	private String newsTitle;

	@JsonProperty("news_update_date")
	private LocalDateTime newsUpdateDate;
	
	@JsonProperty("update_news_update_name")
	private String newsUpdateName;

	@JsonProperty("update_news_category_id")
	private int newsCategoryId;

	@JsonProperty("update_news_description")
	private String newsDescription;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public LocalDateTime getNewsUpdateDate() {
		return newsUpdateDate;
	}

	public void setNewsUpdateDate(LocalDateTime newsUpdateDate) {
		this.newsUpdateDate = newsUpdateDate;
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
