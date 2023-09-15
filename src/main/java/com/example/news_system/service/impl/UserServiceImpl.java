package com.example.news_system.service.impl;

import java.util.Optional;
import java.util.regex.Pattern;

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
	

	// 防呆用
	private boolean hasString(String str) {
		boolean result = StringUtils.hasText(str);
		return result;
	}
	
	// 登入
	@Override
	public UserResponse login(String userAccount, String userPassword) {

		// 防呆
		if(!hasString(userAccount) || !hasString(userPassword)) {
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

	@Override
	public UserResponse signUp(String userAccount, String userPassword, String userName) {

		//防呆
		if(!hasString(userAccount)||!hasString(userPassword)||!hasString(userName)) {
			return new UserResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		// 帳密規則(正則)
		// 帳號：6-12位，必須包含至少一個英文+數字
		// 密碼：8-20位，必須包含至少一個英文+數字
		String accRegex = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{6,12}$";
        String pwdRegex = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$";
        
        if(!Pattern.matches(accRegex, userAccount)||Pattern.matches(pwdRegex, userPassword)) {
        	return new UserResponse(RtnCode.USER_SIGNUP_ERROR.getMessage());
        }

        Users user = new Users();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
		return new UserResponse(RtnCode.USER_SIGHUP_SUCCESS.getMessage());
	}

	
	// 測試存在帳號
	@Override
	public UserResponse isExistAccount(String userAccount) {
		
		if(!hasString(userAccount)){
			return new UserResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		
		// 帳號已存在就回true
		Optional<Users> resultOp = userDao.findById(userAccount);
		if(resultOp.isPresent()) {
			return new UserResponse(true, RtnCode.USER_SIGHUP_ALREADY_EXIST.getMessage());
		}
		
		// 帳號不存在就回false
		return new UserResponse(false, RtnCode.USER_SIGHUP_ALLOW.getMessage());
	}


}
