package com.app.services;

import java.util.List;

import com.app.dto.RackDto;

public interface RackService {
	List<RackDto> getAllRack(Long areaId);
}
