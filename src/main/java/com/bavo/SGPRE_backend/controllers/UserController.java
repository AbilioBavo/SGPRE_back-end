package com.bavo.SGPRE_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bavo.SGPRE_backend.dto.UserMinDto;
import com.bavo.SGPRE_backend.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserMinDto> findAll(){
		return service.findAll();
	}
}
