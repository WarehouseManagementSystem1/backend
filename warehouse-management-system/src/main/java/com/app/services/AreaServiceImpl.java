package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AreaDto;
import com.app.entities.Area;
import com.app.repository.AreaRepository;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaRepository areaRepo;
	
	@Autowired
	ModelMapper modelmapper;
	
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
	
	
}
