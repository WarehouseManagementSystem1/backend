package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BlockDto;
import com.app.repository.BlockRepository;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {
	
	@Autowired
	BlockRepository blockRepository;

	@Override
	public List<BlockDto> getAllBlock(Long levelId, float itemLength, float itemWidth) {
		return blockRepository.findAllBlockByLevelIdAndItemLengthAndWidth(levelId, itemWidth, itemLength);
	}

}
