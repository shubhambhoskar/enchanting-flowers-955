package com.project.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.module.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	public Admin findByAdminUsername(String adminUsername);
}
