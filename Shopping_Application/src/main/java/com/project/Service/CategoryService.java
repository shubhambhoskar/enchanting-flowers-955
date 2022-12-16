package com.project.Service;

import com.project.Exceptions.AdminException;
import com.project.Exceptions.CategoryException;
import com.project.Exceptions.LoginException;
import com.project.module.Category;

public interface CategoryService {
	
	public Category addCategory(Category category, String key) throws CategoryException, AdminException, LoginException;

	public Category updateCategory(Category category, String key) throws CategoryException, AdminException, LoginException;

	public Category deleteCategory(Integer categoryId, String key) throws CategoryException, AdminException, LoginException;
	
}
