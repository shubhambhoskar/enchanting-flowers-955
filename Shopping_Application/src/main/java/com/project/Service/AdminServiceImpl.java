package com.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.AdminDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Exceptions.AdminException;
import com.project.Exceptions.LoginException;
import com.project.module.Admin;
import com.project.module.CurrentUserSession;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private CurrentUserSessionDao csdao;

	@Override
	public Admin saveUser(Admin user) throws AdminException {
		Admin existingUserName = adminDao.findByAdminUsername(user.getAdminUsername());

		if (existingUserName != null)
			throw new AdminException("Username already exists " + user.getAdminUsername());

		return adminDao.save(user);
	}

	@Override
	public Admin updateUser(Admin user, String key) throws AdminException, LoginException {

		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Please provide a valid key to update a customer");
		}

		if (user.getAdminId() == loggedInUser.getUserId()) {
			return adminDao.save(user);
		} else
			throw new AdminException("Invalid Admin Details, please login first");
	}

	@Override
	public Admin deleteUser(String adminUsername) throws AdminException {
		Admin existingUser = adminDao.findByAdminUsername(adminUsername);

		if (existingUser == null)
			throw new AdminException("Admin does not exists with this username " + adminUsername);

		adminDao.delete(existingUser);

		return existingUser;
	}

	@Override
	public Admin findByAdminId(Integer adminId) throws AdminException {
		Optional<Admin> existingUser = adminDao.findById(adminId);

		if (existingUser.isPresent())
			return existingUser.get();
		else
			throw new AdminException("Admin does not exists with this adminId " + adminId);
	}

	@Override
	public Admin findByUserName(String adminUserName) throws AdminException {
		Admin existingUser = adminDao.findByAdminUsername(adminUserName);

		if (existingUser != null)
			return existingUser;
		else
			throw new AdminException("Admin does not exists with this userName " + adminUserName);
	}

	@Override
	public List<Admin> findAllUsers() throws AdminException {
		List<Admin> users = adminDao.findAll();

		if (users.isEmpty())
			throw new AdminException("No Admins Found");

		return users;
	}

	
}
