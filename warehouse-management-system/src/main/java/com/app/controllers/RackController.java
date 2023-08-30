package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RackDto;
import com.app.services.RackService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rack")
public class RackController {
	
	@Autowired
	private RackService rackService;
	
	@GetMapping("/{areaId}")
	public List<RackDto> getAllRack(@PathVariable Long areaId){
		List<RackDto> responseList = rackService.getAllRack(areaId);
		return responseList;
	}

}
