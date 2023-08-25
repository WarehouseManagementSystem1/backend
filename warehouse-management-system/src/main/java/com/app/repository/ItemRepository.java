package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByWarehouseId(Long warehouseId);

}
