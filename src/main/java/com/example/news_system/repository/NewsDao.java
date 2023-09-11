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
	@Query("SELECT n FROM News n WHERE " +
		       "(:title IS NULL OR n.newsTitle LIKE %:title%) AND " +
		       "(:category IS NULL OR n.newsCategory LIKE %:category%) AND " +
		       "(:startDate IS NULL OR n.newsUpdateDate >= :startDate) AND " +
		       "(:endDate IS NULL OR n.newsUpdateDate <= :endDate)")
		List<News> searchNews(
		    @Param("title") String title, 
		    @Param("category") String category, 
		    @Param("startDate") LocalDate startDate, 
		    @Param("endDate") LocalDate endDate
		);
	
}
