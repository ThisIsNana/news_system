package com.example.news_system.service.ifs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;

import com.example.news_system.vo.NewsResponse;

public interface NewsService {
	
	// ��ܩҦ�����
	public NewsResponse showAllNews();
	
	
	// ��ܳ�@����
	public NewsResponse showOneNews(int newsId);
	
	
	// �s�W����
	public NewsResponse addNews(String newsTitle, LocalDateTime newsCreateDate, String newsCreateUser, 
			int newsCategoryId, String newsDescription);

	
	// ��s����
	public NewsResponse updateNews(int newsId, String newsTitle, LocalDateTime newsUpdateDate, String newsUpdateUser,
			int newsCategoryId, String newsDescription);
	

	// ����ܮ���
	public NewsResponse inactiveNews(int newsId);
	
	
	
	// ��s�\����
	public NewsResponse updateReadingCount(int newsId);
	
	
	// �j�M����(���D�B�_���ɶ�)
	public NewsResponse searchNews(String title, LocalDate startDate, LocalDate endDate);
	
	
	// �j�M����(by����)
	public NewsResponse searchNewsByCategoryFatherOrChild(String categoryFather, String categoryChild);
	
	
	// �j�M�ϥΪ̴��g�o���B�s�誺�峹
	public NewsResponse searchNewsByUser(String userAccount);
	
	
}
