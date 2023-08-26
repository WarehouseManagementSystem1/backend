package com.app.services;

import java.util.List;

import com.app.dto.AreaDto;

public interface AreaService {
	List<AreaDto> getAllArea(Long warehouseId);
}
