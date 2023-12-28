package com.bavo.SGPRE_backend.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.bavo.SGPRE_backend.entities.User;

public class UserMinDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private Long phone;
	
	public UserMinDto () {
	}
	
	public UserMinDto(User entity) {
		BeanUtils.copyProperties(entity, this);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
