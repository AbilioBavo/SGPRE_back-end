package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
