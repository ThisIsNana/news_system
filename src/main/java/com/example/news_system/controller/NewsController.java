package com.example.news_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.news_system.service.ifs.NewsService;
import com.example.news_system.vo.AddNewsRequest;
import com.example.news_system.vo.NewsResponse;
import com.example.news_system.vo.SearchNewsRequest;
import com.example.news_system.vo.ShowNewsRequest;
import com.example.news_system.vo.UpdateNewsRequest;

@CrossOrigin
@RestController
public class NewsController {


	@Autowired
 	private NewsService newsService;
	
	// 顯示所有消息
	@GetMapping(value = "show_all_news")
	public NewsResponse showAllNews() {
		return newsService.showAllNews();
	}
 	
	
	
	// 顯示單一消息
	@PostMapping(value="show_one_news")
	public NewsResponse showOneNews(@RequestBody ShowNewsRequest request) {
		return newsService.showOneNews(request.getNewsId());
	}
	

	
	// 新增消息
	@PostMapping(value="add_news")
	public NewsResponse addNews(@RequestBody AddNewsRequest request) {
		return newsService.addNews(request.getNewsTitle(), request.getNewsCreateDate(), request.getNewsUpdateName(),
				request.getNewsCategoryId(), request.getNewsDescription());
	}
	
	
	
	// 更新消息
	@PostMapping(value="updateNews")
	public NewsResponse updateNews(@RequestBody UpdateNewsRequest request) {
		return newsService.updateNews(request.getNewsId(),request.getNewsTitle(), 
				request.getNewsUpdateDate(), request.getNewsUpdateName(),
				request.getNewsCategoryId(), request.getNewsDescription());
	}
	
	
	// 不顯示消息
	@PostMapping(value="inactive_news")
	public NewsResponse inactiveNews(@RequestBody UpdateNewsRequest request) {
		return newsService.inactiveNews(request.getNewsId());
	}
	
	
	
	// 更新閱覽數
	@PostMapping(value="update_reading_count")
	public NewsResponse updateReadingCount(@RequestBody UpdateNewsRequest request) {
		return newsService.updateReadingCount(request.getNewsId());
	}
	
	
	
	// 搜尋消息(標題、起迄時間)
	@PostMapping(value="search_news_title_date")
	public NewsResponse searchNews(@RequestBody SearchNewsRequest request) {
		return newsService.searchNews(request.getTitle(), request.getStartDate(), request.getEndDate());
	}
	
	
	
	// 搜尋消息(by分類)
	@PostMapping(value="search_news_category")
	public NewsResponse searchNewsByCategoryFatherOrChild(@RequestBody SearchNewsRequest request) {
		return newsService.searchNewsByCategoryFatherOrChild(request.getCategoryFather(), request.getCategoryChild());
	}
	

	
	//搜尋某使用者發布、編輯的所有文章
	@PostMapping(value="search_news_user")
	public NewsResponse searchNewsByUser(@RequestBody SearchNewsRequest request) {
		return newsService.searchNewsByUser(request.getSearchNewsUser());
	}
	
	
	
}
