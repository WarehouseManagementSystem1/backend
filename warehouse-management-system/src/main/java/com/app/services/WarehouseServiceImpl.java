package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.WarehouseDto;
import com.app.entities.Owner;
import com.app.entities.User;
import com.app.entities.Warehouse;
import com.app.repository.OwnerRepository;
import com.app.repository.UserRepository;
import com.app.repository.WarehouseRepository;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	@Autowired
	OwnerRepository ownerRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Long addWarehouse(Long ownerId, WarehouseDto warehouseDto) {
		Warehouse newWarehouse = new Warehouse();
		newWarehouse.setName(warehouseDto.getName());
		newWarehouse.setAddress(warehouseDto.getAddress());
		Owner owner = ownerRepository.findById(ownerId).orElseThrow(()->new ResourceNotFoundException("Owner Id is not valid "));
		newWarehouse.setOwner(owner);
		Warehouse savedWarehouse = warehouseRepository.save(newWarehouse);
		User ownerAsUser = userRepository.findByOwnerId(ownerId).orElseThrow(()->new ResourceNotFoundException("Owner is not present as user !!! "));
		ownerAsUser.setWarehouse(savedWarehouse);
		return savedWarehouse.getId();
		
	}

}
