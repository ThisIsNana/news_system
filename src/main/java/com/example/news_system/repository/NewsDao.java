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
		       "JOIN n.newsCategory c " +
		       "WHERE (:title IS NULL OR n.newsTitle LIKE %:title%) " +
		       "AND (:startDate IS NULL OR n.newsUpdateDate >= :startDate) " +
		       "AND (:endDate IS NULL OR n.newsUpdateDate <= :endDate)")
		public List<News> searchNews(
		    @Param("title") String title, 
		    @Param("startDate") LocalDate startDate, 
		    @Param("endDate") LocalDate endDate
		);
	
	
	// 搜尋父分類
	public List<News> findAllByCategoryId();
	
	
	
	// 搜尋子分類
	public List<News> findByCategoryIdOrderByNewsCreateDateDesc(int categoryId);

}
