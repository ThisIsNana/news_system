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
	
	// ��ܩҦ�����
	@GetMapping(value = "show_all_news")
	public NewsResponse showAllNews() {
		return newsService.showAllNews();
	}
 	
	
	
	// ��ܳ�@����
	@PostMapping(value="show_one_news")
	public NewsResponse showOneNews(@RequestBody ShowNewsRequest request) {
		return newsService.showOneNews(request.getNewsId());
	}
	

	
	// �s�W����
	@PostMapping(value="add_news")
	public NewsResponse addNews(@RequestBody AddNewsRequest request) {
		return newsService.addNews(request.getNewsTitle(), request.getNewsCreateDate(), request.getNewsUpdateName(),
				request.getNewsCategoryId(), request.getNewsDescription());
	}
	
	
	
	// ��s����
	@PostMapping(value="updateNews")
	public NewsResponse updateNews(@RequestBody UpdateNewsRequest request) {
		return newsService.updateNews(request.getNewsId(),request.getNewsTitle(), 
				request.getNewsUpdateDate(), request.getNewsUpdateName(),
				request.getNewsCategoryId(), request.getNewsDescription());
	}
	
	
	// ����ܮ���
	@PostMapping(value="inactive_news")
	public NewsResponse inactiveNews(@RequestBody UpdateNewsRequest request) {
		return newsService.inactiveNews(request.getNewsId());
	}
	
	
	
	// ��s�\����
	@PostMapping(value="update_reading_count")
	public NewsResponse updateReadingCount(@RequestBody UpdateNewsRequest request) {
		return newsService.updateReadingCount(request.getNewsId());
	}
	
	
	
	// �j�M����(���D�B�_���ɶ�)
	@PostMapping(value="searchNews")
	public NewsResponse searchNews(@RequestBody SearchNewsRequest request) {
		return newsService.searchNews(request.getTitle(), request.getStartDate(), request.getEndDate());
	}
	
	// �j�M����(by����)
	@PostMapping(value="searchNews")
	public NewsResponse searchNewsByCategoryFatherOrChild(@RequestBody SearchNewsRequest request) {
		return newsService.searchNewsByCategoryFatherOrChild(request.getCategoryFather(), request.getCategoryChild());
	}
	
	
	
}
