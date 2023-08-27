package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LogResponse;
import com.app.services.LogService;

@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	LogService logService;
	
	@GetMapping("/{warehouseId}")
	public List<LogResponse> getAllArea(@PathVariable Long warehouseId){
		List<LogResponse> responseList = logService.getAllLogs(warehouseId);
		return responseList;
	}

}
