package com.esspl.backend.dao;

import java.util.List;

import com.esspl.backend.model.Category;


public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	public boolean add(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	
}
