package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.User;

public interface UserDao  extends JpaRepository<User, Integer>{

}
