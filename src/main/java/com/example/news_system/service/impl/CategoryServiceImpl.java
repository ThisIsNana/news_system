package com.example.news_system.service.impl;

import org.springframework.stereotype.Service;

import com.example.news_system.service.ifs.CategoryService;
import com.example.news_system.vo.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Override
	public CategoryResponse addCategory(String categoryFather, String categoryChild, String categoryLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponse updateCategory(int categoryId, String categoryFather, String categoryChild,
			String categoryLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponse showAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
