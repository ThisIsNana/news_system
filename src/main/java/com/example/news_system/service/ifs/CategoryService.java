package com.example.news_system.service.ifs;

import com.example.news_system.vo.CategoryResponse;

public interface CategoryService {

	// 新增分類
	public CategoryResponse addCategory(String categoryFather, String categoryChild);
	
	// 更新分類
	public CategoryResponse updateCategory(int categoryId, String categoryFather, String categoryChild);
	
	// 顯示所有分類項目
	public CategoryResponse showAllCategory();
}
