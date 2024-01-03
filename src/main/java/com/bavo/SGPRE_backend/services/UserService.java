package com.bavo.SGPRE_backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bavo.SGPRE_backend.dto.UserMinDto;
import com.bavo.SGPRE_backend.entities.User;
import com.bavo.SGPRE_backend.repositories.UserRepository;
import com.bavo.SGPRE_backend.services.exceptions.DatabaseException;
import com.bavo.SGPRE_backend.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserMinDto> findAll(){
		List<UserMinDto> dto = repository.findAll().stream().map(x -> new UserMinDto(x)).collect(Collectors.toList());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public User create (User user) {
		return repository.save(user);
	}
	
	@Transactional
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	private void updateDate(User entity, User user) {
		entity.setName(user.getName());
		entity.setPhone(user.getPhone());
		entity.setPassword(user.getPassword());
		
	}
	
	@Transactional
	public User update (Long id, User user) {
		try {
			User entity=repository.getReferenceById(id);
			updateDate(entity, user);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
