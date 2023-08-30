package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AllItemDto;
import com.app.dto.InBoundCheck;
import com.app.dto.InboundResponse;
import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;
import com.app.dto.OutBoundRequest;
import com.app.dto.OutBoundResponse;
import com.app.services.ItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/allitem/{warehouseId}")
	public List<AllItemDto> fetchAllItems(@PathVariable Long warehouseId) {
		System.out.println("in fetch all Items");
		return itemService.getAllItems(warehouseId);
	}

	@PostMapping("/transfer")
	public AllItemDto itemTransfer(@RequestBody ItemDto detachedItem){
		System.out.println(detachedItem);
		return itemService.transfer(detachedItem);
	}

	@GetMapping("/allitemidandname/{warehouseId}")
	public ResponseEntity<?> getAllItemIdAndName(@PathVariable Long warehouseId){
		
		List<ItemIdResponse> responseList =itemService.getAllItemIdAndName(warehouseId);
		System.out.println(responseList);
		return ResponseEntity.ok(responseList);
	}

	@PostMapping("/outbound/{warehouseId}")
	public ResponseEntity<?> performOutBound(@RequestBody OutBoundRequest request) {
		if(request.getItemId()==null) {
			return ResponseEntity.badRequest().body("item id is null");
		}
		System.out.println(request.getItemId());
		OutBoundResponse response = itemService.performOutBound(request);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/inbound/check/{warehouseId}")
	public ResponseEntity<?> performInboundCheck(@RequestBody InBoundCheck request, @PathVariable Long warehouseId){

			Boolean check = itemService.performInboundCheck(request,warehouseId);
			if(check==true)
			{
				return ResponseEntity.ok("you can add the provided Item !!"); 
			}
			else 
				return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("you can not add the provided Item !!");
	}
	
	@PostMapping("inbound/checked/{warehouseId}")
	public InboundResponse performInbound(@RequestBody InBoundCheck request, @PathVariable Long warehouseId) {
		return itemService.performInbound(request, warehouseId);
		
	}
	
	
}
