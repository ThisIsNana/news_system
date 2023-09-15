package com.example.news_system.vo;

import com.example.news_system.entity.Users;

public class UserResponse {

	// 登入與註冊共用-->是否為使用者、是否為已存在帳號
	private boolean isUser;

	private Users user;

	private String message;

	// ========================================================

	public UserResponse() {
		super();
	}

	public UserResponse(String message) {
		super();
		this.message = message;
	}
	
	public UserResponse(boolean isUser) {
		super();
		this.isUser = isUser;
	}

	public UserResponse(boolean isUser, String message) {
		super();
		this.isUser = isUser;
		this.message = message;
	}

	public UserResponse(boolean isUser, Users user, String message) {
		super();
		this.isUser = isUser;
		this.user = user;
		this.message = message;
	}
	
	// ========================================================

	public boolean isUser() {
		return isUser;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
