package com.example.news_system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignUpRequest {

	@JsonProperty("signup_account")
	private String userAccount;

	@JsonProperty("signup_password")
	private String userPassword;

	@JsonProperty("signup_name")
	private String userName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
