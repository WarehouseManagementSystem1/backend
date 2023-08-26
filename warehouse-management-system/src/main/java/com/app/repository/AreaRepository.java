package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {

	List<Area> findByWarehouseId(Long warehouseId);
}
