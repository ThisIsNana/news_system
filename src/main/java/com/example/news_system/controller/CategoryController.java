package com.example.news_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.news_system.service.ifs.CategoryService;
import com.example.news_system.vo.AddCategoryRequest;
import com.example.news_system.vo.CategoryResponse;
import com.example.news_system.vo.UpdateCategoryRequest;

@CrossOrigin
@RestController
public class CategoryController {


	@Autowired
 	private CategoryService categoryService;
	
	// �s�W����
	@PostMapping(value = "add_category")
	public CategoryResponse addCategory(@RequestBody AddCategoryRequest request) {
		return categoryService.addCategory(request.getCategoryFather(), request.getCategoryChild());
	}

	// ��s����
	@PostMapping(value = "update_category")
	public CategoryResponse updateCategory(@RequestBody UpdateCategoryRequest request) {
		return categoryService.updateCategory(request.getCategoryId() ,request.getCategoryFather(), request.getCategoryChild());
	}

	// ��ܩҦ���������
	@GetMapping(value = "show_all_category")
	public CategoryResponse showAllCategory() {
		return categoryService.showAllCategory();
	}
	
	
}
