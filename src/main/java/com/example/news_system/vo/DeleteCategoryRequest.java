package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteCategoryRequest {
	
	@JsonProperty("delete_category_id")
	private int deleteCategoryId;

	public int getDeleteCategoryId() {
		return deleteCategoryId;
	}

	public void setDeleteCategoryId(int deleteCategoryId) {
		this.deleteCategoryId = deleteCategoryId;
	}

}
