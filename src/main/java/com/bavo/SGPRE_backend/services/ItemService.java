package com.bavo.SGPRE_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavo.SGPRE_backend.dto.ItemMinDto;
import com.bavo.SGPRE_backend.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Transactional(readOnly = true)
	public List<ItemMinDto> findAll(){
		List<ItemMinDto> dto = repository.findAll().stream().map(x -> new ItemMinDto(x)).collect(Collectors.toList());
		return dto;
	}
}
