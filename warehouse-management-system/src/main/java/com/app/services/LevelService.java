package com.app.services;

import java.util.List;

import com.app.dto.LevelDto;

public interface LevelService {

	List<LevelDto> getAllLevel(Long rackId, float itemHeight);

}
