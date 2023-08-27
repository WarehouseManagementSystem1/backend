package com.app.services;

import java.util.List;

import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;

public interface ItemService {
	ItemDto transfer(ItemDto detachedItem);
	List<ItemDto> getAllItems(Long warehouseId);
	List<ItemIdResponse>getAllItemIdAndName(Long warehouseId);
	float findItemHeightById(Long itemId);
	float findItemLengthById(Long itemId);
	float findItemWitdthById(Long itemId);
	
}