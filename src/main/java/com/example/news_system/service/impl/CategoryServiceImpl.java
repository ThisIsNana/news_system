package com.example.news_system.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.news_system.constant.RtnCode;
import com.example.news_system.entity.Category;
import com.example.news_system.repository.CategoryDao;
import com.example.news_system.repository.NewsDao;
import com.example.news_system.service.ifs.CategoryService;
import com.example.news_system.vo.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao; 
	
	@Autowired 
	private NewsDao newsDao;


	// 防呆用
	private boolean hasString(String str) {
		boolean result = StringUtils.hasText(str);
		return result;
	}
	
	private boolean isLegalInt(int i) {
		boolean result = i > 0;
		return result;
	}
	
	
	
//	新增分類
	@Transactional
	@Override
	public CategoryResponse addCategory(String categoryFather, String categoryChild) {

	    // 防呆
	    if (!hasString(categoryFather) || !hasString(categoryChild)) {
	        return new CategoryResponse(RtnCode.CANNOT_EMPTY.getMessage());
	    }

	    // 不允許父子層相同
	    if(categoryFather.equals(categoryChild)) {
		    return new CategoryResponse(RtnCode.CATEGORY_FATHER_CHILD_SAME.getMessage());
	    }

	    // 確認DB不重複
	    Category result = categoryDao.findByCategoryFatherAndCategoryChild(categoryFather, categoryChild);
	    if(result != null) {
		    return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
	    }
	    
	    
	    List<Category> existFather = categoryDao.findByCategoryFather(categoryFather);
	    // 父層存在 => 檢查子層
	    if(!existFather.isEmpty()) {
	    	for(Category father : existFather) {
	    		if(father.getCategoryChild().equals(categoryChild)) {
	    			return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
	    		}
	    	}
	    }
	    
	    // 父&子分類都檢查完，寫入!
	    Category category = new Category();
	    category.setCategoryFather(categoryFather);
	    category.setCategoryChild(categoryChild);
	    categoryDao.save(category);

	    return new CategoryResponse(RtnCode.ADD_CATEGORY_SUCCESS.getMessage());
	}

	
	
	
//	更新分類
	@Transactional
	@Override
	public CategoryResponse updateCategory(int categoryId, String categoryFather, String categoryChild) {
		
		//防呆
		if(!hasString(categoryFather) || !hasString(categoryChild)) {
			return new CategoryResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		if(!isLegalInt(categoryId)) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		

		// 確定有這筆資料
		Optional<Category> resultOp = categoryDao.findById(categoryId);
		if(!resultOp.isPresent()) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		Category result = resultOp.get();
		

		// 重複防呆1 完全重複(沒有任何修改)
		if(result.getCategoryFather().equals(categoryFather) && result.getCategoryChild().equals(categoryChild)) {
			return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
		}

		
	    List<Category> existFather = categoryDao.findByCategoryFather(categoryFather);
	    // 父層存在 => 檢查子層
	    if(!existFather.isEmpty()) {
	    	for(Category father : existFather) {
	    		if(father.getCategoryChild().equals(categoryChild)) {
	    			return new CategoryResponse(RtnCode.CATEGORY_EXIST.getMessage());
	    		}
	    	}
	    }
		
		// 都檢查完就寫入!
		result.setCategoryFather(categoryFather);
		result.setCategoryChild(categoryChild);
		categoryDao.save(result);
		
		return new CategoryResponse(result, RtnCode.UPDATE_CATEGORY_SUCCESS.getMessage());
	}

	
	
//	顯示所有分類
	@Transactional
	@Override
	public CategoryResponse showAllCategory() {
		List<Category> resultList = categoryDao.findAll();
		return new CategoryResponse(resultList, RtnCode.SHOW_SUCCESS.getMessage());
	}




	@Override
	public CategoryResponse deleteCateogory(int categoryId) {

		// 防呆
		if(isLegalInt(categoryId)) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		
		Optional<Category> resultOp = categoryDao.findById(categoryId);
		if(!resultOp.isPresent()) {
			return new CategoryResponse(RtnCode.CATEGORY_NOT_FOUND.getMessage());
		}
		Category result = resultOp.get();
		
		// 如果子分類名稱作為父分類去搜尋，發現還有子分類的話，報錯
		if(categoryDao.findByCategoryFather(result.getCategoryChild()).size() != 1) {
			return new CategoryResponse(RtnCode.DELETE_CATEGORY_CHILD_EXIST.getMessage());
		}
		
		// 如果這個分類有人使用，報錯
		if(newsDao.findByNewsCategoryIdOrderByNewsCreateDateDesc(categoryId).size() > 0) {
			return new CategoryResponse(RtnCode.DELETE_CATEGORY_NEWS_USED.getCode());
		}
		
		// 直接刪除
		categoryDao.delete(result);
		return null;
	}

}
