package com.bavo.SGPRE_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavo.SGPRE_backend.dto.CategoryMinDto;
import com.bavo.SGPRE_backend.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public List<CategoryMinDto> findAll(){
		return service.findAll();
	}
}
