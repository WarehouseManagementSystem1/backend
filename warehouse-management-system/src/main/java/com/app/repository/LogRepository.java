package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
	List<Log> findByWarehouseId(Long warehouseId);
}
