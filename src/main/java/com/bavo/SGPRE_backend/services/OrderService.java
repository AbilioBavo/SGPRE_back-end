package com.bavo.SGPRE_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavo.SGPRE_backend.dto.OrderMinDto;
import com.bavo.SGPRE_backend.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderMinDto> findAll(){
		List<OrderMinDto> dto = repository.findAll().stream().map(x -> new OrderMinDto(x)).collect(Collectors.toList());
		return dto;
	}
}
