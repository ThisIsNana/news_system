package com.example.news_system.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int newsId;

	@Column(name = "news_title")
	private String newsTitle;

	@Column(name = "news_create_date")
	private LocalDateTime newsCreateDate;

	@Column(name = "news_update_date")
	private LocalDateTime newsUpdateDate;

	@Column(name = "news_update_name")
	private String newsUpdateName;

	@Column(name = "news_category_id")
	private String newsCategoryId;

	@Column(name = "news_description")
	private String newsDescription;

	@Column(name = "news_reading_count")
	private int newsReadingCount;

	@Column(name = "news_active")
	private boolean newsActive;

	// ========================================================

	public News() {
		super();
	}

	public News(int newsId, String newsTitle, LocalDateTime newsCreateDate, LocalDateTime newsUpdateDate,
			String newsUpdateName, String newsCategoryId, String newsDescription, int newsReadingCount,
			boolean newsActive) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsCreateDate = newsCreateDate;
		this.newsUpdateDate = newsUpdateDate;
		this.newsUpdateName = newsUpdateName;
		this.newsCategoryId = newsCategoryId;
		this.newsDescription = newsDescription;
		this.newsReadingCount = newsReadingCount;
		this.newsActive = newsActive;
	}

	// ========================================================

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

	public LocalDateTime getNewsCreateDate() {
		return newsCreateDate;
	}

	public void setNewsCreateDate(LocalDateTime newsCreateDate) {
		this.newsCreateDate = newsCreateDate;
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

	public String getNewsCategoryId() {
		return newsCategoryId;
	}

	public void setNewsCategoryId(String newsCategoryId) {
		this.newsCategoryId = newsCategoryId;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

	public int getNewsReadingCount() {
		return newsReadingCount;
	}

	public void setNewsReadingCount(int newsReadingCount) {
		this.newsReadingCount = newsReadingCount;
	}

	public boolean isNewsActive() {
		return newsActive;
	}

	public void setNewsActive(boolean newsActive) {
		this.newsActive = newsActive;
	}

}
