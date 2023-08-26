package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AreaDto;
import com.app.services.AreaService;

@RestController
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/{warehouseId}")
	public List<AreaDto> getAllArea(@PathVariable Long warehouseId){
		List<AreaDto> responseList = areaService.getAllArea(warehouseId);
		return responseList;
	}

}
