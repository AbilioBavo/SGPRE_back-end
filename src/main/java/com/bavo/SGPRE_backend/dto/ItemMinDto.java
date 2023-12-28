package com.bavo.SGPRE_backend.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.bavo.SGPRE_backend.entities.Item;

public class ItemMinDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String shortDescription;
	private Double price;
	private String imgUrl;
	private String categoryName;
	
	public ItemMinDto() {
	}

	public ItemMinDto(Item entity) {
		BeanUtils.copyProperties(entity, this);
		categoryName=entity.getCategory().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
