package com.example.news_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.news_system.service.ifs.UserService;
import com.example.news_system.vo.UserLoginRequest;
import com.example.news_system.vo.UserResponse;
import com.example.news_system.vo.UserSignUpRequest;

@CrossOrigin
@RestController
public class UserController {
	

	@Autowired
 	private UserService userService;
	
	// 登入
	@PostMapping(value = "user_login")
	public UserResponse login(@RequestBody UserLoginRequest request) {
		return userService.login(request.getUserAccount(), request.getUserPassword());
	}
 	
	// 註冊
	@PostMapping(value = "user_sign_up")
	public UserResponse sighUp(@RequestBody UserSignUpRequest request) {
		return userService.signUp(request.getUserAccount(), request.getUserPassword(), request.getUserName());
	}
	
	// 驗證帳號是否存在
	@PostMapping(value = "is_exist_account")
	public UserResponse isExistAccount(@RequestBody UserSignUpRequest request) {
		return userService.isExistAccount(request.getUserAccount());
	}
	
}
