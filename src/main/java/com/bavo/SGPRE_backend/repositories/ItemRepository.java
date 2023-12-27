package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
