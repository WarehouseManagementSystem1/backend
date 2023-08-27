package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.LogResponse;
import com.app.entities.Log;
import com.app.repository.LogRepository;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	LogRepository logRepository;
	
	@Override
	public List<LogResponse> getAllLogs(Long warehouseId) {
		List<Log> logList = logRepository.findByWarehouseId(warehouseId);
		List<LogResponse> logResponseList = mapLogsToLogResponses(logList);
		return logResponseList;
	}

	private List<LogResponse> mapLogsToLogResponses(List<Log> logList) {
		List<LogResponse> logResponseList = new ArrayList<>();
		for(Log l : logList) {
			logResponseList.add(modelMapper.map(l, LogResponse.class));
		}
		return logResponseList;
	}

}
