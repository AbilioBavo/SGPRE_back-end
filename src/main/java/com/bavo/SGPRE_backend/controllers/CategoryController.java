package com.bavo.SGPRE_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavo.SGPRE_backend.dto.CategoryMinDto;
import com.bavo.SGPRE_backend.entities.Category;
import com.bavo.SGPRE_backend.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryMinDto>> findAll(){
		return ResponseEntity.ok(service.findAll());//.body(service.findAll());
	}
	
//	@PostMapping
//	public ResponseEntity<Category> findAll(Category category){
//		
//		return ResponseEntity.ok(service.findAll());//.body(service.findAll());
//	}
}
