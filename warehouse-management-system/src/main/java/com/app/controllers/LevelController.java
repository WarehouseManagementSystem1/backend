package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LevelDto;
import com.app.services.ItemService;
import com.app.services.LevelService;

@RestController
@RequestMapping("/level")
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{rackId}/{itemId}")
	public List<LevelDto> getAllRack(@PathVariable Long rackId,@PathVariable Long itemId){
		float itemHeight = itemService.findItemHeightById(itemId);
		List<LevelDto> responseList = levelService.getAllLevel(rackId,itemHeight);
		return responseList;
	}

}
