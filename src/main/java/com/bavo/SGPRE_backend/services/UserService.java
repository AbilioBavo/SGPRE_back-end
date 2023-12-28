package com.bavo.SGPRE_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavo.SGPRE_backend.dto.UserMinDto;
import com.bavo.SGPRE_backend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserMinDto> findAll(){
		List<UserMinDto> dto = repository.findAll().stream().map(x -> new UserMinDto(x)).collect(Collectors.toList());
		return dto;
	}
}
