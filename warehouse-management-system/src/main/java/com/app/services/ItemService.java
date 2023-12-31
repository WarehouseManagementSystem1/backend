package com.app.services;

import java.util.List;

import com.app.dto.AllItemDto;
import com.app.dto.InBoundCheck;
import com.app.dto.InboundResponse;
import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;
import com.app.dto.OutBoundRequest;
import com.app.dto.OutBoundResponse;

public interface ItemService {
	AllItemDto transfer(ItemDto detachedItem);
	List<AllItemDto> getAllItems(Long warehouseId);
	List<ItemIdResponse>getAllItemIdAndName(Long warehouseId);
	float findItemHeightById(Long itemId);
	float findItemLengthById(Long itemId);
	float findItemWitdthById(Long itemId);
	OutBoundResponse performOutBound(OutBoundRequest request);
	Boolean performInboundCheck(InBoundCheck request, Long warehouseId);
	InboundResponse performInbound(InBoundCheck request, Long warehouseId);
	
}