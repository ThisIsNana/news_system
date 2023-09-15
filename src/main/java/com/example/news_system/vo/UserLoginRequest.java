package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequest {
	
	
	@JsonProperty("user_account")
	private String userAccount;
	
	@JsonProperty("user_password")
	private String userPassword;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
}
