package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
