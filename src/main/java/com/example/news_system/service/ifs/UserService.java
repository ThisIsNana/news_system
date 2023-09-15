package com.example.news_system.service.ifs;

import com.example.news_system.vo.UserResponse;

public interface UserService {
	
	public UserResponse login(String userAccount, String userPassword);
	
	public UserResponse signUp(String userAccount, String userPassword, String userName);
	
	public UserResponse isExistAccount(String userAccount);
}
