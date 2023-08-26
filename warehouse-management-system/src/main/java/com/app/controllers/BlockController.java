package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BlockDto;
import com.app.services.BlockService;
import com.app.services.ItemService;

@RestController
@RequestMapping("/block")
public class BlockController {
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{levelId}/{itemId}")
	public List<BlockDto> getAllRack(@PathVariable Long levelId,@PathVariable Long itemId){
		float itemLength = itemService.findItemLengthById(itemId);
		float itemWidth = itemService.findItemWitdthById(itemId);
		List<BlockDto> responseList = blockService.getAllBlock(levelId,itemLength,itemWidth);
		return responseList;
	}

}
