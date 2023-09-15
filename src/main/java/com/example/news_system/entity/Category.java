
package com.example.news_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_father")
	private String categoryFather;

	@Column(name = "category_child")
	private String categoryChild;

	// ========================================================

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryFather, String categoryChild) {
		super();
		this.categoryId = categoryId;
		this.categoryFather = categoryFather;
		this.categoryChild = categoryChild;
	}

	// ========================================================

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryFather() {
		return categoryFather;
	}

	public void setCategoryFather(String categoryFather) {
		this.categoryFather = categoryFather;
	}

	public String getCategoryChild() {
		return categoryChild;
	}

	public void setCategoryChild(String categoryChild) {
		this.categoryChild = categoryChild;
	}

}
