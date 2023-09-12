package com.example.news_system.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.news_system.constant.RtnCode;
import com.example.news_system.entity.Category;
import com.example.news_system.entity.News;
import com.example.news_system.repository.CategoryDao;
import com.example.news_system.repository.NewsDao;
import com.example.news_system.service.ifs.NewsService;
import com.example.news_system.vo.NewsResponse;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Autowired
	private CategoryDao categoryDao;

	// ��ܩҦ�����
	@Override
	public NewsResponse showAllNews() {
		List<News> result = newsDao.findAllByOrderByNewsCreateDateDesc();
		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

	// ��ܳ�@����
	@Override
	public NewsResponse showOneNews(int newsId) {

		if (newsId < 0) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		Optional<News> resultOp = newsDao.findById(newsId);

		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		News result = resultOp.get();
		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

	
	
	
	// �s�W����
	@Override
	public NewsResponse addNews(String newsTitle, LocalDateTime newsCreateDate, String newsUpdateName,
			int newsCategoryId, String newsDescription) {

		// ���b
		if (!StringUtils.hasText(newsTitle) || !StringUtils.hasText(newsDescription)
				|| !StringUtils.hasText(newsUpdateName) || newsCreateDate == null || newsCategoryId < 0) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �������s�b
		if (!categoryDao.findById(newsCategoryId).isPresent()) {
			return new NewsResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}

		// �g�J
		News news = new News();
		news.setNewsTitle(newsTitle);
		news.setNewsCreateDate(newsCreateDate);
		news.setNewsUpdateDate(newsCreateDate);
		news.setNewsCategoryId(newsCategoryId);
		news.setNewsUpdateName(newsUpdateName);
		news.setNewsDescription(newsDescription);

		newsDao.save(news);

		return new NewsResponse(news, RtnCode.ADD_NEWS_SUCCESS.getMessage());
	}

	
	
	
	// ��s����
	@Override
	public NewsResponse updateNews(int newsId, String newsTitle, LocalDateTime newsUpdateDate, String newsUpdateName,
			int newsCategoryId, String newsDescription) {

		// ���b
		if (!StringUtils.hasText(newsTitle) || !StringUtils.hasText(newsDescription)
				|| !StringUtils.hasText(newsUpdateName) || newsId < 0 || newsUpdateDate == null || newsCategoryId < 0) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �������s�b
		if (!categoryDao.findById(newsCategoryId).isPresent()) {
			return new NewsResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}

		// �������s�b
		Optional<News> resultOp = newsDao.findById(newsId);
		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		// �s��Ƽg�J
		News result = resultOp.get();
		result.setNewsTitle(newsTitle);
		result.setNewsDescription(newsDescription);
		result.setNewsUpdateDate(newsUpdateDate);
		result.setNewsUpdateName(newsUpdateName);
		result.setNewsCategoryId(newsCategoryId);

		newsDao.save(result);

		return new NewsResponse(result, RtnCode.UPDATE_NEWS_SUCCESS.getMessage());
	}

	
	
	
	// ����ܮ���(����)
	@Override
	public NewsResponse inactiveNews(int newsId) {

		if(newsId < 0) {
		}
		
		// �������s�b
		Optional<News> resultOp = newsDao.findById(newsId);
		if(!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}
		
		News result = resultOp.get();
		
		// �w�g���ê�����
		if(result.isNewsActive() == false) {
			return new NewsResponse(RtnCode.NEWS_NOT_ACTIVE.getMessage());
		}
		
		//�g�J+�x�s
		result.setNewsActive(false);
		newsDao.save(result);
		return new NewsResponse(RtnCode.INACTIVE_NEWS_SUCCESS.getMessage());
		
	}
	
	

	// ��s�\����
	@Override
	public NewsResponse updateReadingCount(int newsId) {
		
		// ���b
		if(newsId < 0) {
		}
		
		// �������s�b
		Optional<News> resultOp = newsDao.findById(newsId);
		if(!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}
		
		//����ƴN�[1
		News result = resultOp.get();
		result.setNewsReadingCount(result.getNewsReadingCount() + 1);
		return new NewsResponse(result, RtnCode.UPDATE_NEWS_SUCCESS.getMessage());
	}
	
	
	
	// �j�M����(���D�B�_�l�ɶ��B�����ɶ�)
	@Override
	public NewsResponse searchNews(String title, LocalDate startDate, LocalDate endDate) {

		List<News> result = new ArrayList<>();

		if (StringUtils.hasText(title) || startDate != null || endDate != null) {
			// ������@�ӭȡA�N�i��j�M
			result = newsDao.searchNews(title, startDate, endDate);

		} else {
			// �Ҧ��ѼƬҪšA��ܥ������G
			result = newsDao.findAll();
		}

		// �j�M���쵲�G�ɡA�^�ǿ��~
		if (result.isEmpty()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}
	
	

	
	// �j�M����(by����id)
	@Override
	public NewsResponse searchNewsByCategoryFatherOrChild(String categoryFather, String categoryChild) {

		if(!StringUtils.hasText(categoryFather) || !StringUtils.hasText(categoryChild)) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		// ��XcategoryId
		int categoryId = categoryDao.findByCategoryFatherAndCategoryChild(categoryFather, categoryChild);
		
		// ��id�h�j�M
		List<News> result = newsDao.findByNewsCategoryIdOrderByNewsCreateDateDesc(categoryId);
		
		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}


}
