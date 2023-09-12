package com.example.news_system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.news_system.constant.RtnCode;
import com.example.news_system.entity.Users;
import com.example.news_system.repository.UserDao;
import com.example.news_system.service.ifs.UserService;
import com.example.news_system.vo.UserResponse;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	// 登入
	@Override
	public UserResponse login(String userAccount, String userPassword) {

		// 防呆
		if(!StringUtils.hasText(userAccount) || !StringUtils.hasText(userPassword)) {
			return new UserResponse(false, RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		// 是否存在
		Optional<Users> resultOp = userDao.findById(userAccount);
		if(!resultOp.isPresent()) {
			return new UserResponse(false, RtnCode.USER_LOGIN_FAILED.getMessage());
		}
		
		// 密碼錯誤
		Users result = resultOp.get();
		if(!result.getUserPassword().equals(userPassword)) {
			return new UserResponse(false, RtnCode.USER_LOGIN_FAILED.getMessage());
		}
		
		// 把密碼不顯示後回傳
		result.setUserPassword("************");
		return new UserResponse(true, result, RtnCode.USER_LOGIN_SUCCESS.getMessage());
	}
	
	

}
