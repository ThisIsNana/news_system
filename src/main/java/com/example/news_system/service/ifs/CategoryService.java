package com.example.news_system.service.ifs;

import com.example.news_system.vo.CategoryResponse;

public interface CategoryService {

	// �s�W����
	public CategoryResponse addCategory(String categoryFather, String categoryChild);
	
	// ��s����
	public CategoryResponse updateCategory(int categoryId, String categoryFather, String categoryChild);
	
	// ��ܩҦ���������
	public CategoryResponse showAllCategory();
}
