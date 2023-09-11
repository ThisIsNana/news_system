package com.example.news_system.constant;

public enum RtnCode {
	
//	ニュース
    CREATE_NEWS_SUCCESS("200", "新增成功"),
    SEARCH_NEWS_SUCCESS("200", "搜尋成功"),
    UPDATE_NEWS_SUCCESS("200", "更新成功"),
    INACTIVE_NEWS_SUCCESS("200", "刪除成功"),
    NEWS_DATE_ERROR("400", "日期有誤"),
    CATEGORY_ERROR("400", "分類數量有誤"),
    NOT_FOUND("401", "查無相關資料"),
    NOT_ACTIVE("401", "文章不存在!"),
//  使用者
    ADD_USER_SUCCESS("200","新增使用者成功"),
    USER_ACCOUNT_ERROR("400", "帳號格式錯誤!"),
    USER_PASSWORD_ERROR("400", "密碼格式錯誤!"),
    USER_ALREADY_EXIST("400", "使用者已存在"),
    LOGIN_SUCCESS("200","登入成功"),
    LOGIN_FAILED("400", "登入失敗"),
//  共有
    CANNOT_EMPTY("400", "請勿空白"),
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