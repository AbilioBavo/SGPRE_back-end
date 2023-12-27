package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
