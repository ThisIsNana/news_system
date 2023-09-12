package com.example.news_system.service.ifs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.news_system.vo.NewsResponse;

public interface NewsService {
	
	// 顯示所有消息
	public NewsResponse showAllNews();
	
	
	// 顯示單一消息
	public NewsResponse showOneNews(int newsId);
	
	
	// 新增消息
	public NewsResponse addNews(String newsTitle, LocalDateTime newsCreateDate, String newsUpdateName, 
			int newsCategoryId, String newsDescription);

	
	// 更新消息
	public NewsResponse updateNews(int newsId, String newsTitle, LocalDateTime newsUpdateDate, String newsUpdateName,
			int newsCategoryId, String newsDescription);
	

	// 不顯示消息
	public NewsResponse inactiveNews(int newsId);
	
	
	
	// 更新閱覽數
	public NewsResponse updateReadingCount(int newsId);
	
	
	// 搜尋消息(標題、起迄時間)
	public NewsResponse searchNews(String title, LocalDate startDate, LocalDate endDate);
	
	
	// 搜尋消息(by分類)
	public NewsResponse searchNewsByCategoryFatherOrChild(String categoryFather, String categoryChild);
	
	
	

}
