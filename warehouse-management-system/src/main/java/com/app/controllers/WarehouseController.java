package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddWarehouseResponse;
import com.app.dto.WarehouseDto;
import com.app.services.WarehouseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@Autowired
	WarehouseService warehouseService;

	@PostMapping("/addwarehouse/{ownerId}")
	public ResponseEntity<?> addwarehouse(@PathVariable Long ownerId, @RequestBody WarehouseDto warehouseDto ){
		try {
			
			Long warehouseId = warehouseService.addWarehouse(ownerId,warehouseDto);
			
			AddWarehouseResponse response = new AddWarehouseResponse("WareHouse Successfully Added !!",warehouseId);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
