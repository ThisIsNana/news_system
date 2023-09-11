package com.example.news_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_account")
	private String userAccount;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_name")
	private String userName;
	
	// ========================================================

	public Users() {
		super();
	}

	public Users(String userAccount, String userPassword, String userName) {
		super();
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	// ========================================================
	
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
