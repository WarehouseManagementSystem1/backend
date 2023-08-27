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
	
	@Override
	public List<AreaDto> getAllArea(Long warehouseId) {
		
		List<Area> areaList = areaRepo.findByWarehouseId(warehouseId);
		
		List<AreaDto> areaDtoList =mapAreaListToAreaDtoList(areaList);
		return areaDtoList;
	}

	private List<AreaDto> mapAreaListToAreaDtoList(List<Area> areaList) {
		List<AreaDto> areaDtoList =new ArrayList<>();
		for(Area a : areaList) {
			areaDtoList.add(new AreaDto(a.getId(), a.getAreaName()));
		}
		return areaDtoList;
	}

	@Override
	public void addArea(Long warehouseId,AddAreaRequest request) {
		
		Area newArea = new Area();
		newArea.setAreaName(request.getAreaname());
		Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(()->new ResourceNotFoundException("Invalid warehouse Id ") );
		newArea.setWarehouse(warehouse);
		Area savedArea = areaRepo.save(newArea);
		for(int i = 1; i<= request.getNumberofrack();i++) {
			Rack newRack = new Rack();
			newRack.setRackNumber(i);
			newRack.setArea(savedArea);
			Rack savedRack = rackRepository.save(newRack);
			for(int j=1;j<=request.getNumberoflevelperrack();j++) {
				Level newLevel = new Level();
				newLevel.setLevelNumber(j);
				newLevel.setLevelHeight(request.getHeightofeachlevel());
				newLevel.setRack(savedRack);
				Level savedLevel = levelRepository.save(newLevel);
				for(int k=1;k<=request.getNumberofblockperlevel();k++) {
					Block newBlock = new Block();
					newBlock.setBlockNumber(k);
					newBlock.setBlockLength(request.getLengthofeachblock());
					newBlock.setBlockWidth(request.getWidthofeachblock());
					newBlock.setArea(savedArea);
					newBlock.setOccupiedStatus(OccupiedLevel.EMPTY);
					newBlock.setRack(savedRack);
					newBlock.setLevel(savedLevel);
					newBlock.setWarehouse(warehouse);
					Block savedBlock = blockRepository.save(newBlock);
				}
				
			}
		}
	}
	
	
	
}
