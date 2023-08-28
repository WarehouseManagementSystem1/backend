package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AddAreaRequest;
import com.app.dto.AreaDto;
import com.app.entities.Area;
import com.app.entities.Block;
import com.app.entities.Level;
import com.app.entities.OccupiedLevel;
import com.app.entities.Rack;
import com.app.entities.Warehouse;
import com.app.repository.AreaRepository;
import com.app.repository.BlockRepository;
import com.app.repository.LevelRepository;
import com.app.repository.RackRepository;
import com.app.repository.WarehouseRepository;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaRepository areaRepo;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	@Autowired
	RackRepository rackRepository;
	
	@Autowired
	LevelRepository levelRepository;
	
	@Autowired
	BlockRepository blockRepository;
	
	//Area Service method to get a list of all the Area's present in the particular warehouse 
	
	@Override
	public List<AreaDto> getAllArea(Long warehouseId) {
		
		List<Area> areaList = areaRepo.findByWarehouseId(warehouseId);
		
		List<AreaDto> areaDtoList =mapAreaListToAreaDtoList(areaList);
		return areaDtoList;
	}

	//Area Service private method to map list of Area to list of Area Dto
	
	private List<AreaDto> mapAreaListToAreaDtoList(List<Area> areaList) {
		List<AreaDto> areaDtoList =new ArrayList<>();
		for(Area a : areaList) {
			areaDtoList.add(mapAreaToAreaDto(a));
		}
		return areaDtoList;
	}
	
	//Area Service private method to map Area object to Area Dto object
	
	private AreaDto mapAreaToAreaDto(Area area){
		return new AreaDto(area.getId(), area.getAreaName());
	}

	//Area Service method to add area to the data base
	
	@Override
	public Long addArea(Long warehouseId,AddAreaRequest request) throws ResourceNotFoundException{
		try {
			Area newArea = new Area();
			Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(()->new ResourceNotFoundException("Invalid warehouse Id ") );
			newArea.setAreaName(request.getAreaname());
			newArea.setWarehouse(warehouse);
			Area savedArea = areaRepo.save(newArea);
			for(int i = 1; i<= request.getNumberofrack();i++) {
				//creating new area 
				Rack newRack = createNewRack(i, savedArea, request);
				//saving the creating area
				Rack savedRack = rackRepository.save(newRack);
				for(int j=1;j<=request.getNumberoflevelperrack();j++) {
					//creating new level
					Level newLevel = createNewLevel(j, savedRack, request);
					//saving the created level
					Level savedLevel = levelRepository.save(newLevel);
					for(int k=1;k<=request.getNumberofblockperlevel();k++) {
						//creating new block
						Block newBlock = createNewBlock(k, savedArea, savedRack, savedLevel, warehouse,request);
						//saving the created block
						Block savedBlock = blockRepository.save(newBlock);
					}
					
				}
			}
			
			return savedArea.getId();
		}catch(RuntimeException e) {
			System.out.println(e);
			throw e;
		}
	}
	
	//Area service private method to create new Rack
	
	private Rack createNewRack(int i,Area savedArea,AddAreaRequest request) {
		Rack newRack = new Rack();
		newRack.setRackNumber(i);
		newRack.setArea(savedArea);
		return newRack;
	}
	
	
	//Area service private method to create new level
	
	private Level createNewLevel(int j,Rack savedRack,AddAreaRequest request) {
		Level newLevel = new Level();
		newLevel.setLevelNumber(j);
		newLevel.setLevelHeight(request.getHeightofeachlevel());
		newLevel.setRack(savedRack);
		return newLevel;
	}
	
	//Area service private method to create new block 
	
	private Block createNewBlock(int k,Area savedArea,Rack savedRack,Level savedLevel,Warehouse warehouse,AddAreaRequest request ) {
		Block newBlock = new Block();
		newBlock.setBlockNumber(k);
		newBlock.setBlockLength(request.getLengthofeachblock());
		newBlock.setBlockWidth(request.getWidthofeachblock());
		newBlock.setArea(savedArea);
		newBlock.setOccupiedStatus(OccupiedLevel.EMPTY);
		newBlock.setRack(savedRack);
		newBlock.setLevel(savedLevel);
		newBlock.setWarehouse(warehouse);
		return newBlock;
	}
	
	
}
