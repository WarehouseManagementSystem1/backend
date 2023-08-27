package com.app.services;

import java.util.List;

import com.app.dto.LogResponse;

public interface LogService {

	List<LogResponse> getAllLogs(Long warehouseId);

}
