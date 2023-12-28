package com.bavo.SGPRE_backend.dto;

import java.io.Serializable;

import com.bavo.SGPRE_backend.entities.Category;

public class CategoryMinDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public CategoryMinDto () {
	}
	
	public CategoryMinDto(Category entity) {
		id=entity.getId();
		name=entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
