package com.example.news_system.vo;

import java.util.List;

import com.example.news_system.entity.News;

public class NewsResponse {

	private List<News> newsList;

	private News news;

	private String message;

	// ========================================================

	public NewsResponse() {
		super();
	}

	public NewsResponse(String message) {
		super();
		this.message = message;
	}

	public NewsResponse(News news, String message) {
		super();
		this.news = news;
		this.message = message;
	}

	public NewsResponse(List<News> newsList, String message) {
		super();
		this.newsList = newsList;
		this.message = message;
	}

	// ========================================================

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
