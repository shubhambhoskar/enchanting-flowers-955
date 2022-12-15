package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.User;
@Repository
public interface UserDao  extends JpaRepository<User, Integer>{

	//public User findByUsername(String username);
}
