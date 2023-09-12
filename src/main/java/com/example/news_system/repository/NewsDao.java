package com.example.news_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.news_system.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer>{

//	用JPQL來取代冗長的JPA:)
	@Query("SELECT n FROM News n " +
		       "WHERE (:title IS NULL OR n.newsTitle LIKE %:title%) " +
		       "AND (:startDate IS NULL OR n.newsCreateDate >= :startDate) " +
		       "AND (:endDate IS NULL OR n.newsCreateDate <= :endDate)")
		public List<News> searchNews(
		    @Param("title") String title, 
		    @Param("startDate") LocalDate startDate, 
		    @Param("endDate") LocalDate endDate
		);
	
	
	// 搜尋子分類
	public List<News> findByNewsCategoryIdOrderByNewsCreateDateDesc(int categoryId);
	
	
//	@Query("SELECT n FROM News n ORDER BY n.newsCreateDate DESC")
	public List<News> findAllByOrderByNewsCreateDateDesc();

	//搜尋某使用者發布、編輯的所有文章
	public List<News> findByNewsCreateUserOrNewsUpdateUser(String newsCreareUser, String newsUpdateUser);
	
}
