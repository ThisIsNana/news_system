package com.example.news_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.news_system.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	// 搜尋父分類
	public List<Category> findByCategoryFather(String categoryFather);
	
	// 搜尋子分類 => 確認層級用
	public List<Category> findByCategoryChild(String categoryChild);
	
	// 用父子分類去搜尋id
	public Category findByCategoryFatherAndCategoryChild(String categoryFather, String categoryChild);
}
