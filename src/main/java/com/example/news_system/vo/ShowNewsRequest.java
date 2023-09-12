package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowNewsRequest {

	@JsonProperty("news_id")
	private int newsId;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	
	
	
}
