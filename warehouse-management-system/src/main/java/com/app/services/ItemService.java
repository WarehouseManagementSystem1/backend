package com.app.services;

import java.util.List;

import com.app.dto.ItemDto;

public interface ItemService {
	ItemDto transfer(ItemDto detachedItem);
	List<ItemDto> getAllItems(Long warehouseId);
}
