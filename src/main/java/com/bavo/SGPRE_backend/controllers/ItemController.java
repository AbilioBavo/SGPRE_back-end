package com.bavo.SGPRE_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavo.SGPRE_backend.dto.ItemMinDto;
import com.bavo.SGPRE_backend.services.ItemService;

@RestController
@RequestMapping(value="/itens")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping
	public List<ItemMinDto> findAll(){
		return service.findAll();
	}
}
