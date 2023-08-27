package com.app.services;

import com.app.dto.WarehouseDto;

public interface WarehouseService {

	Long addWarehouse(Long ownerId, WarehouseDto warehouseDto);

}
