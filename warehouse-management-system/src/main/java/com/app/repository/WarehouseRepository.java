package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
	Optional<Warehouse> findById(Long Id);
}
