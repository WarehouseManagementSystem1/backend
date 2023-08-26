package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.RackDto;
import com.app.entities.Rack;
import com.app.repository.RackRepository;


@Service
@Transactional
public class RackServiceImpl implements RackService {

	@Autowired
	RackRepository rackRepo;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public List<RackDto> getAllRack(Long areaId) {
		
		List<Rack> rackList = rackRepo.findByAreaId(areaId);
		
		List<RackDto> rackDtoList =mapRackListToRackDtoList(rackList);
		return rackDtoList;
	}

	private List<RackDto> mapRackListToRackDtoList(List<Rack> rackList) {
		List<RackDto> rackDtoList =new ArrayList<>();
		for(Rack a : rackList) {
			rackDtoList.add(new RackDto(a.getId(), a.getRackNumber()));
		}
		return rackDtoList;
	}

}
