package com.app.services;

import java.util.List;

import com.app.dto.BlockDto;

public interface BlockService {

	List<BlockDto> getAllBlock(Long levelId, float itemLength, float itemWidth);

}
