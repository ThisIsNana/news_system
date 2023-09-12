package com.example.news_system.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.news_system.constant.RtnCode;
import com.example.news_system.entity.Category;
import com.example.news_system.repository.CategoryDao;
import com.example.news_system.service.ifs.CategoryService;
import com.example.news_system.vo.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao; 

	
//	�s�W����
	@Transactional
	@Override
	public CategoryResponse addCategory(String categoryFather, String categoryChild) {
		
		// ���b
		if(!StringUtils.hasText(categoryFather) || !StringUtils.hasText(categoryChild) ) {
			return new CategoryResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		int categoryLevel = 0;
		List<Category> existResult = categoryDao.findByCategoryFather(categoryFather);
		

		// �p�G���h���s�b -> �s�W�@�Ӥ��h
		if(existResult.isEmpty()) {
			Category newFather = new Category();
			newFather.setCategoryFather(categoryFather);
			newFather.setCategoryChild(categoryFather);
			categoryDao.save(newFather);
			categoryLevel++;
		}
		// �p�G���h�s�b -> ����l�h���Ʒs�W
		else {
			List<String> existChild = new ArrayList<>();
			for(Category result : existResult) {
				existChild.add(result.getCategoryChild());
			}
			if(existChild.contains(categoryChild)) {
				return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
			}

			// level�]�w
			if(categoryFather.equals(categoryChild)) {
				categoryLevel = existResult.get(0).getCategoryLevel();
			}
			else {
				categoryLevel = existResult.get(0).getCategoryLevel()+ 1;	
			}
		}
		
		
		// �g�J
		Category category = new Category();
		category.setCategoryFather(categoryFather);
		category.setCategoryChild(categoryChild);
		category.setCategoryLevel(categoryLevel);
		categoryDao.save(category);
		
		return new CategoryResponse(category, RtnCode.ADD_CATEGORY_SUCCESS.getMessage());
	}

	
	
	
//	��s����
	@Transactional
	@Override
	public CategoryResponse updateCategory(int categoryId, String categoryFather, String categoryChild) {
		
		//���b
		if(!StringUtils.hasText(categoryFather) || !StringUtils.hasText(categoryChild)) {
			return new CategoryResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		if(categoryId <= 0) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		

		// �T�w���o�����
		Optional<Category> resultOp = categoryDao.findById(categoryId);
		if(!resultOp.isPresent()) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		Category result = resultOp.get();
		

		// ���ƨ��b1 ��������(�S������ק�)
		if(result.getCategoryFather().equals(categoryFather) && result.getCategoryChild().equals(categoryChild)) {
			return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
		}
		

		// ���ƨ��b2 
		int categoryLevel = 0;
		List<Category> existResult = categoryDao.findByCategoryFather(categoryFather);
		
		// ���h���s�b -> �s�W�@�Ӥ��h
		if(existResult.isEmpty()) {
			Category newFather = new Category();
			newFather.setCategoryFather(categoryFather);
			newFather.setCategoryChild(categoryFather);
			categoryDao.save(newFather);
			categoryLevel++;
		}
		// ���h�s�b -> ����l��������
		else {
			List<String> existChild = new ArrayList<>();
			for(Category existRes : existResult) {
				existChild.add(existRes.getCategoryChild());
			}
			
			if(existChild.contains(categoryChild)) {
				return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
			}
			
			//level�]�w
			if(categoryFather.equals(categoryChild)) {
				categoryLevel = existResult.get(0).getCategoryLevel();
			}
			else {
				categoryLevel = existResult.get(0).getCategoryLevel()+ 1;	
			}
			
		}
		
		//�g�J
		result.setCategoryFather(categoryFather);
		result.setCategoryChild(categoryChild);
		result.setCategoryLevel(categoryLevel);
		categoryDao.save(result);
		
		return new CategoryResponse(result, RtnCode.UPDATE_CATEGORY_SUCCESS.getMessage());
	}

	
	
//	��ܩҦ�����
	@Transactional
	@Override
	public CategoryResponse showAllCategory() {
		List<Category> resultList = categoryDao.findAll();
		return new CategoryResponse(resultList, RtnCode.SHOW_SUCCESS.getMessage());
	}

}
