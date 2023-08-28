package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InBoundCheck;
import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;
import com.app.dto.OutBoundRequest;
import com.app.dto.OutBoundResponse;
import com.app.services.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/allitem/{warehouseId}")
	public List<ItemDto> fetchAllItems(@PathVariable Long warehouseId) {
		System.out.println("in fetch all Items");
		return itemService.getAllItems(warehouseId);
	}

	@PostMapping("/transfer")
	public ItemDto itemTransfer(@RequestBody ItemDto detachedItem){
		System.out.println(detachedItem);
		return itemService.transfer(detachedItem);
	}

	@GetMapping("/allitemidandname/{warehouseId}")
	public List<ItemIdResponse> getAllItemIdAndName(@PathVariable Long warehouseId){
		
		List<ItemIdResponse> responseList =itemService.getAllItemIdAndName(warehouseId);
		System.out.println(responseList);
		return responseList;
	}

	@PostMapping("/outbound/{warehouseId}")
	public OutBoundResponse performOutBound(@RequestBody OutBoundRequest request) {
		OutBoundResponse response = itemService.performOutBound(request);
		return response;
	}
	
	@PostMapping("/inbound/check/{warehouseId}")
	public ResponseEntity<?> performInboundCheck(@RequestBody InBoundCheck request){

			Boolean check = itemService.performInboundCheck(request);
			if(check==true)
			{
				return ResponseEntity.ok("you can add the provided Item !!"); 
			}
			else 
				return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("you can not add the provided Item !!");
	}
	
}
