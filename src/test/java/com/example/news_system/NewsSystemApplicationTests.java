package com.example.news_system;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.news_system.entity.Category;
import com.example.news_system.repository.CategoryDao;
import com.example.news_system.service.ifs.CategoryService;
import com.example.news_system.service.ifs.NewsService;
import com.example.news_system.service.ifs.UserService;

@SpringBootTest
class NewsSystemApplicationTests {
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserService userService;
	
	
	
//	=CategoryTest==============================
	

	@Test
	public void daoFindByCategoryFatherAndChildTest() {
		Category result = categoryDao.findByCategoryFatherAndCategoryChild("平板", "配件");
		if(result == null) {
			System.out.println("正確");
		}
		else {
			System.out.println("錯誤");
		}
	}
	
	
	@Test
	public void addCategoryTest() {
		categoryService.addCategory("イベント", "今年イベント");
		categoryService.addCategory("イベント", "歴史イベント");
		System.out.println("完成");
	}
	

	@Test
	public void updateCategory() {
		categoryService.updateCategory(1, " ", "配件");
		categoryService.updateCategory(1, "平板", null);
		categoryService.updateCategory(1, "平板", "配件");
		System.out.println("完成");
	}

//	=NewsTest==================================
	@Test
	public void showAllNewsTest() {
		LocalDateTime now = LocalDateTime.of(2023, 9, 15, 23, 59, 59);
		newsService.addNews("Title Test1", now, "測試員1", 1, "內容測試!!!!!111111111");
	}
	
	
	
//	=UserTest==================================
	
	@Test
	public void contextLoads() {
	}

}
