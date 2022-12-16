package com.project.Service;

import java.util.List;

import com.project.Exceptions.AdminException;
import com.project.Exceptions.LoginException;
import com.project.module.Admin;

public interface AdminService {
	public Admin saveUser(Admin user) throws AdminException;

	public Admin updateUser(Admin user, String key) throws AdminException,LoginException;

	public Admin deleteUser(String adminUsername) throws AdminException;

	public Admin findByAdminId(Integer adminId) throws AdminException;

	public Admin findByUserName(String adminUserName) throws AdminException;

	public List<Admin> findAllUsers() throws AdminException;
}
