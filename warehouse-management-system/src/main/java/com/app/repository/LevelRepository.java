package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.LevelDto;
import com.app.entities.Level;

public interface LevelRepository extends JpaRepository<Level, Long> {

	@Query("SELECT new com.app.dto.LevelDto(l.id, l.levelNumber) FROM Level l WHERE l.rack.id = :rackId and l.levelHeight >= :itemHeight")
    List<LevelDto> findAllLevelByRackIdAndItemHeight(Long rackId,float itemHeight);
	
	@Query("SELECT new com.app.dto.LevelDto(l.id, l.levelNumber) FROM Level l WHERE l.levelHeight >= :itemHeight")
    List<LevelDto> findAllLevelByItemHeight(float itemHeight);
}
