package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddAreaRequest;
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
	
	@PostMapping("/addarea/{warehouseId}")
	public ResponseEntity<?> addArea(@PathVariable Long warehouseId,@RequestBody AddAreaRequest request){
		
		try {
			
			areaService.addArea(warehouseId,request);
			return ResponseEntity.ok("area , racks, levels, blocks added successfully !!");
			
		}
		catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
		
	}
	
}
