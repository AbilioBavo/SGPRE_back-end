package com.bavo.SGPRE_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavo.SGPRE_backend.dto.OrderMinDto;
import com.bavo.SGPRE_backend.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public List<OrderMinDto> findAll(){
		return service.findAll();
	}
}
