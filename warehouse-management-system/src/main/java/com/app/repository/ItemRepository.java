package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ItemIdResponse;
import com.app.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByWarehouseId(Long warehouseId);
	
	@Query("SELECT new com.app.dto.ItemIdResponse(i.id, i.name, i.units) FROM Item i WHERE i.warehouse.id = :warehouseId")
    List<ItemIdResponse> findItemIdsAndNamesByWarehouseId(Long warehouseId);
	
	
//	@Query("SELECT i FROM Item i WHERE i.itemId = :itemId")
//    Item findItemById(Long itemId);
}