package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
