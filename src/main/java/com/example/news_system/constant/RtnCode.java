package com.example.news_system.constant;

public enum RtnCode {
	
//	ニュース
    ADD_NEWS_SUCCESS("200", "V 新增成功"),
    SEARCH_NEWS_SUCCESS("200", "V 搜尋成功"),
    UPDATE_NEWS_SUCCESS("200", "V 更新成功"),
    INACTIVE_NEWS_SUCCESS("200", "V 隱藏消息成功"),
    NEWS_DATE_ERROR("400", "X 日期有誤"),
    NEWS_NOT_FOUND("401", "X 查無相關資料"),
    NEWS_NOT_ACTIVE("401", "X 文章不存在!"),
    
//  使用者
    USER_SIGHUP_SUCCESS("200","V 註冊成功"),
    USER_LOGIN_SUCCESS("200","V 登入成功"),
    USER_SIGNUP_ERROR("400", "X 註冊失敗，帳號或密碼格式錯誤"),
    USER_LOGIN_FAILED("401", "X 登入失敗，帳號或密碼錯誤"),
    USER_SIGHUP_ALREADY_EXIST("401","X 此帳號已存在"),
    USER_SIGHUP_ALLOW("200","V 此帳號可使用"),
    
//  分類
    ADD_CATEGORY_SUCCESS("200","V 新增分類成功"),
    UPDATE_CATEGORY_SUCCESS("200","V 更新分類成功"),
    SEARCH_CATEGORY_SUCCESS("200","V 搜尋分類成功"),
    DELETE_CATEGORY_SUCCESS("200","V 刪除分類成功"),
    CATEGORY_ERROR("400","X 分類有誤"),
    DELETE_CATEGORY_CHILD_EXIST("400","X 刪除時出錯，請檢查是否存在其他子分類!"),
    DELETE_CATEGORY_NEWS_USED("400","X 刪除時出錯，正在被部分文章使用中!"),
    CATEGORY_EXIST("400","X 分類已存在!"),
    CATEGORY_NOT_FOUND("401","X 查無此分類，請先新增"),
    CATEGORY_FATHER_CHILD_SAME("401","X 父層不可與子層名稱相同"),
    
//  共有
    CANNOT_EMPTY("400", "X 請勿空白，請查看欄位"),
    SHOW_SUCCESS("400", "V 成功，已列出所有結果"),
    ;


    private String code;

    private String message;

    private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}