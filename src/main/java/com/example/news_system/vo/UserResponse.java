package com.example.news_system.vo;

public class UserResponse {
	
	//只回傳需要的值就好(是否為使用者及其姓名)

	private boolean isUser;

	private String userName;

	private String message;

	// ========================================================

	public UserResponse() {
		super();
	}

	public UserResponse(String message) {
		super();
		this.message = message;
	}

	public UserResponse(boolean isUser, String message) {
		super();
		this.isUser = isUser;
		this.message = message;
	}

	public UserResponse(boolean isUser, String userName, String message) {
		super();
		this.isUser = isUser;
		this.userName = userName;
		this.message = message;
	}

	// ========================================================

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isUser() {
		return isUser;
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
