package com.bavo.SGPRE_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavo.SGPRE_backend.dto.CategoryMinDto;
import com.bavo.SGPRE_backend.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryMinDto> findAll(){
		List<CategoryMinDto> dto = repository.findAll().stream().map(x -> new CategoryMinDto(x)).collect(Collectors.toList());
		return dto;
	}
}
