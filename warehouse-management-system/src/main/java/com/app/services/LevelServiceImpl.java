package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.LevelDto;
import com.app.repository.LevelRepository;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {

	@Autowired
	LevelRepository levelRepository;
	
	@Override
	public List<LevelDto> getAllLevel(Long rackId, float itemHeight) {
		return levelRepository.findAllLevelByRackIdAndItemHeight(rackId, itemHeight);
	}

}
