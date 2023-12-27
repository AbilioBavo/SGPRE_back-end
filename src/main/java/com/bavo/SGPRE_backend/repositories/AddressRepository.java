package com.bavo.SGPRE_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavo.SGPRE_backend.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
