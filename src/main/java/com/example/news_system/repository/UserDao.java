package com.example.news_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.news_system.entity.Users;

@Repository
public interface UserDao extends JpaRepository<Users, String> {

	
	
}
