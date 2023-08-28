package com.app.services;

import java.util.List;

import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;
import com.app.dto.OutBoundRequest;
import com.app.dto.OutBoundResponse;

public interface ItemService {
	ItemDto transfer(ItemDto detachedItem);
	List<ItemDto> getAllItems(Long warehouseId);
	List<ItemIdResponse>getAllItemIdAndName(Long warehouseId);
	float findItemHeightById(Long itemId);
	float findItemLengthById(Long itemId);
	float findItemWitdthById(Long itemId);
	OutBoundResponse performOutBound(OutBoundRequest request);
	
}