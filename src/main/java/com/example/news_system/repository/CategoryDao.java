package com.example.news_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.news_system.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	// �j�M������
	public List<Category> findByCategoryFather(String categoryFather);
	
	// �j�M�l����
	public Category findByCategoryChild(String categoryChild);
	
	
	
	
}
