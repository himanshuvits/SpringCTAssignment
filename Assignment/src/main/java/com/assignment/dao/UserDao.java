package com.assignment.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.dto.User;

public interface UserDao extends JpaRepository<User, Integer>{
	List<User> findAll();
	User findByUserId(Integer userId);
}
