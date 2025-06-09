package com.becoder.service;

import java.util.List;

import com.becoder.entities.Category;

public interface CategoryService {
	
	
	
	public Boolean saveCategory(Category category);
	
	List<Category> getAllCategory();

}
