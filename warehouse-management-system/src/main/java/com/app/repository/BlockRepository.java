package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.BlockDto;
import com.app.entities.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
	
	@Query("SELECT new com.app.dto.BlockDto(b.id, b.blockNumber) FROM Block b WHERE b.level.id = :levelId and b.blockWidth >= :itemWidth and b.blockLength >= :itemLength and b.occupiedStatus=OccupiedLevel.EMPTY")
    List<BlockDto> findAllBlockByLevelIdAndItemLengthAndWidth(Long levelId,float itemWidth,float itemLength);

}
