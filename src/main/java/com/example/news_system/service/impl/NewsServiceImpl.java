package com.example.news_system.service.impl;

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

	

	// 防呆用
	private boolean hasString(String str) {
		boolean result = StringUtils.hasText(str);
		return result;
	}
	
	private boolean isLegalInt(int i) {
		boolean result = i > 0;
		return result;
	}
	
	private boolean hasDateTime(LocalDateTime ldt) {
		boolean result = ldt != null;
		return result;
	}
	
	
	// 顯示所有消息
	@Override
	public NewsResponse showAllNews() {
		List<News> result = newsDao.findAllByOrderByNewsCreateDateDesc();
		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

	// 顯示單一消息
	@Override
	public NewsResponse showOneNews(int newsId) {

		// 防呆
		if (!isLegalInt(newsId)) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		Optional<News> resultOp = newsDao.findById(newsId);

		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		News result = resultOp.get();
		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

	// 新增消息
	@Override
	public NewsResponse addNews(String newsTitle, LocalDateTime newsCreateDate, String newsCreateUser,
			int newsCategoryId, String newsDescription) {

		// 防呆
		if (!hasString(newsTitle) 
				|| !hasString(newsDescription)  || !hasString(newsCreateUser) 
				|| !hasDateTime(newsCreateDate) || !isLegalInt(newsCategoryId)) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// 分類不存在
		if (!categoryDao.findById(newsCategoryId).isPresent()) {
			return new NewsResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}

		// 寫入
		News news = new News();
		news.setNewsTitle(newsTitle);
		news.setNewsCreateDate(newsCreateDate);
		news.setNewsCreateUser(newsCreateUser);
		news.setNewsUpdateDate(newsCreateDate);
		news.setNewsUpdateUser(newsCreateUser);
		news.setNewsCategoryId(newsCategoryId);
		news.setNewsDescription(newsDescription);

		newsDao.save(news);

		return new NewsResponse(news, RtnCode.ADD_NEWS_SUCCESS.getMessage());
	}

	// 更新消息
	@Override
	public NewsResponse updateNews(int newsId, String newsTitle, LocalDateTime newsUpdateDate, String newsUpdateUser,
			int newsCategoryId, String newsDescription) {

		// 防呆
		if (!hasString(newsTitle) || !hasString(newsDescription)
			|| !hasString(newsUpdateUser)   || !isLegalInt(newsId) 
			|| !hasDateTime(newsUpdateDate) || !isLegalInt(newsCategoryId)) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// 分類不存在
		if (!categoryDao.findById(newsCategoryId).isPresent()) {
			return new NewsResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}

		// 消息不存在
		Optional<News> resultOp = newsDao.findById(newsId);
		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		// 新資料寫入
		News result = resultOp.get();
		result.setNewsTitle(newsTitle);
		result.setNewsDescription(newsDescription);
		result.setNewsUpdateDate(newsUpdateDate);
		result.setNewsUpdateUser(newsUpdateUser);
		result.setNewsCategoryId(newsCategoryId);

		newsDao.save(result);

		return new NewsResponse(result, RtnCode.UPDATE_NEWS_SUCCESS.getMessage());
	}

	// 不顯示消息(隱藏)
	@Override
	public NewsResponse inactiveNews(int newsId) {

		// 防呆
		if (!isLegalInt(newsId)) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		// 消息不存在
		Optional<News> resultOp = newsDao.findById(newsId);
		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		News result = resultOp.get();

		// 已經隱藏的消息
		if (result.isNewsActive() == false) {
			return new NewsResponse(RtnCode.NEWS_NOT_ACTIVE.getMessage());
		}

		// 寫入+儲存
		result.setNewsActive(false);
		newsDao.save(result);
		return new NewsResponse(RtnCode.INACTIVE_NEWS_SUCCESS.getMessage());

	}

	// 更新閱覽數
	@Override
	public NewsResponse updateReadingCount(int newsId) {

		// 防呆
		if (!isLegalInt(newsId)) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		// 消息不存在
		Optional<News> resultOp = newsDao.findById(newsId);
		if (!resultOp.isPresent()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		// 有資料就加1
		News result = resultOp.get();
		result.setNewsReadingCount(result.getNewsReadingCount() + 1);
		return new NewsResponse(result, RtnCode.UPDATE_NEWS_SUCCESS.getMessage());
	}

	
	
	// 搜尋消息(標題、起始時間、結束時間)
	@Override
	public NewsResponse searchNews(String title, LocalDateTime startDate, LocalDateTime endDate) {

		List<News> result = new ArrayList<>();

		if ( hasString(title) || hasDateTime(startDate) || hasDateTime(endDate)) {
			// 有任何一個值，就進行搜尋
			result = newsDao.searchNews(title, startDate, endDate);

		} else {
			// 所有參數皆空，顯示全部結果
			result = newsDao.findAll();
		}

		// 搜尋不到結果時，回傳錯誤
		if (result.isEmpty()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}
	
	

	// 搜尋消息(by分類id)
	@Override
	public NewsResponse searchNewsByCategoryFatherOrChild(String categoryFather, String categoryChild) {

		if (!StringUtils.hasText(categoryFather) || !StringUtils.hasText(categoryChild)) {
			return new NewsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// 確認是否存在
		Category category = categoryDao.findByCategoryFatherAndCategoryChild(categoryFather, categoryChild);
		if(category == null) {
			return new NewsResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
				
		// 用id去搜尋
		List<News> result = newsDao.findByNewsCategoryIdOrderByNewsCreateDateDesc(category.getCategoryId());

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}

	
	
	// 搜尋某使用者發布、編輯的所有文章
	@Override
	public NewsResponse searchNewsByUser(String userAccount) {
		List<News> result = newsDao.findByNewsCreateUserOrNewsUpdateUser(userAccount, userAccount);
		if (result.isEmpty()) {
			return new NewsResponse(RtnCode.NEWS_NOT_FOUND.getMessage());
		}

		return new NewsResponse(result, RtnCode.SEARCH_NEWS_SUCCESS.getMessage());
	}


}
