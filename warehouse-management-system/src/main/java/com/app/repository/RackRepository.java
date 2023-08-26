package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Rack;

public interface RackRepository extends JpaRepository<Rack, Long> {
	List<Rack> findByAreaId(Long areaId);
}
