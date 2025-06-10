package com.becoder.service.Impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.entities.Category;
import com.becoder.service.CategoryService;
import com.becoder.service.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {

		Category category = mapper.map(categoryDto, Category.class);

		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());

		Category saveCategory = categoryRepo.save(category);

		if (ObjectUtils.isEmpty(saveCategory)) {

			return false;
		}

		return true;
	}

	@Override
	public List<Category> getAllCategory() {

		List<Category> categories = categoryRepo.findAll();

		return categories;
	}

	@Override
	public List<CategoryResponse> getActiveCategorry() {
		
		List<Category> categories = categoryRepo.findByIsActiveTrue();
		
		List<CategoryResponse> categoryList = categories.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
		
		return categoryList;
	}
	
	

}
