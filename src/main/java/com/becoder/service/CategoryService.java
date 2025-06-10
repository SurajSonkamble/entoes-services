package com.becoder.service;

import java.util.List;

import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.entities.Category;

public interface CategoryService {
	
	
	
	public Boolean saveCategory(CategoryDto categoryDto);
	
	List<Category> getAllCategory();

	 List<CategoryResponse> getActiveCategorry();

}
