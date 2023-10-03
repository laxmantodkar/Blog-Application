package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payLoads.APIResponce;
import com.blog.payLoads.CategoryDto;
import com.blog.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		System.out.println(categoryDto);
		System.out.println("======================");
		return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
	}

	@PutMapping("/update")
	public ResponseEntity<CategoryDto> updateCayegory(@RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(this.categoryService.updateCategory(categoryDto));
	}

	@GetMapping("/get")
	public ResponseEntity<List<CategoryDto>> getcategory() {
		return ResponseEntity.ok(this.categoryService.getCategory());
	}

	@GetMapping("/getsingle/{id}")
	public ResponseEntity<CategoryDto> getSinglecategory(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.categoryService.getSingle(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponce> deleteCategory(@PathVariable("id") int id) {
		this.categoryService.deleteCategory(id);
		APIResponce a = new APIResponce("Delete Successfully", true);
		return new ResponseEntity<APIResponce>(a, HttpStatus.OK);
	}
}
