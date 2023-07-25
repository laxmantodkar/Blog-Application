package com.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.blog.entites.Category;
import com.blog.payLoads.CategoryDto;
import com.blog.repository.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	// Save Category
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(savedCategory, CategoryDto.class);

	}

	// Update Category

	public CategoryDto updateCategory(CategoryDto categoryDto) {
		Category category = this.categoryRepo.findById(categoryDto.getCategoryId());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category c = this.categoryRepo.save(category);
		return this.modelMapper.map(c, CategoryDto.class);

	}

	// delete Category
	public void deleteCategory(int id) {
		this.categoryRepo.deleteById(id);
	}

	// get Allcategory
	public ArrayList<CategoryDto> getCategory() {
		java.util.List<Category> cat = this.categoryRepo.findAll();
		ArrayList<CategoryDto> list = new ArrayList<>();
		for (Category category : cat) {
			list.add(this.modelMapper.map(category, CategoryDto.class));
		}
		return list;
	}

	// get single Category
	public CategoryDto getSingle(int id) {
		Category cate = this.categoryRepo.findById(id);
		return this.modelMapper.map(cate, CategoryDto.class);
	}
}
