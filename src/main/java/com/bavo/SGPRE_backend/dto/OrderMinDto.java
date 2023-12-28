package com.bavo.SGPRE_backend.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.beans.BeanUtils;

import com.bavo.SGPRE_backend.entities.Order;

public class OrderMinDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant momente;
	private String userName;
	
	public OrderMinDto () {
	}
	
	public OrderMinDto(Order entity) {
		BeanUtils.copyProperties(entity, this);
		this.userName=entity.getUser().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomente() {
		return momente;
	}

	public void setMomente(Instant momente) {
		this.momente = momente;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
