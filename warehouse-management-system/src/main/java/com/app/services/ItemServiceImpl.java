package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.BlockDto;
import com.app.dto.InBoundCheck;
import com.app.dto.ItemDto;
import com.app.dto.ItemIdResponse;
import com.app.dto.LevelDto;
import com.app.dto.OutBoundRequest;
import com.app.dto.OutBoundResponse;
import com.app.entities.Area;
import com.app.entities.Block;
import com.app.entities.Item;
import com.app.entities.Level;
import com.app.entities.Log;
import com.app.entities.OccupiedLevel;
import com.app.entities.Rack;
import com.app.repository.AreaRepository;
import com.app.repository.BlockRepository;
import com.app.repository.ItemRepository;
import com.app.repository.LevelRepository;
import com.app.repository.LogRepository;
import com.app.repository.RackRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private RackRepository rackRepository;
	
	@Autowired
	private LevelRepository levelRepository;

	@Autowired
    private BlockRepository blockRepository;
	
	@Autowired
	private LogRepository logRepository;
	
	@Override
	public ItemDto transfer(ItemDto detachedItem) {
		
		Item updatedItem= updateDetails(detachedItem);
		
		ItemDto updatedItemDto=mapItemToItemDto(updatedItem);
		
		return updatedItemDto;
			
			
		}
	
	public Item updateDetails(ItemDto detachedItem) {
		Item item = itemRepository.findById(detachedItem.getId()).orElseThrow(()->new ResourceNotFoundException("Not a valid Id  "));
		
		//Block block = blockRepository.findById(item.getBlock().getId()).orElseThrow(()->new ResourceNotFoundException("Not a valid Id  "));
		
		Block block = item.getBlock();
		System.out.println(block);
		block.setOccupiedStatus(OccupiedLevel.EMPTY);
		
		logRepository.save(new Log("Audit", detachedItem.getWarehouseid(), item.getName(), detachedItem.getId(), item.getArea().getId(), item.getRack().getId(), item.getLevel().getId(), item.getBlock().getId(), detachedItem.getAreaid(), detachedItem.getRackid(), detachedItem.getLevelid(), detachedItem.getBlockid()));
		
		Area newArea = areaRepository.findById(detachedItem.getAreaid()).orElse(null);
        item.setArea(newArea);
        
        Rack newRack = rackRepository.findById(detachedItem.getRackid()).orElse(null);
        item.setRack(newRack);
        
        Level newLevel = levelRepository.findById(detachedItem.getLevelid()).orElse(null);
        item.setLevel(newLevel);
        
        Block newBlock = blockRepository.findById(detachedItem.getBlockid()).orElse(null);
        item.setBlock(newBlock);
        
        newBlock.setOccupiedStatus(OccupiedLevel.OCCUPIED);
        
		return item;
	}
	
	
	public ItemDto mapItemToItemDto(Item item) {
        ItemDto responseItem = new ItemDto();
        responseItem.setId(item.getId());

        if (item.getWarehouse() != null) {
            responseItem.setWarehouseid(item.getWarehouse().getId());
        }
        
        if (item.getArea() != null) {
            responseItem.setAreaid(item.getArea().getId());
        }
        
        if (item.getRack() != null) {
            responseItem.setRackid(item.getRack().getId());
        }
        
        if (item.getLevel() != null) {
            responseItem.setLevelid(item.getLevel().getId());
        }
        
        if (item.getBlock() != null) {
            responseItem.setBlockid(item.getBlock().getId());
        }
        

        return responseItem;
    }

	@Override
	public List<ItemDto> getAllItems(Long warehouseId) {
		List<Item> items= (List<Item>) itemRepository.findByWarehouseId(warehouseId);
		return mapItemsToItemDtos(items);
		
	}
	
	

    public List<ItemDto> mapItemsToItemDtos(List<Item> items) {
        return items.stream()
            .map(this::mapItemToItemDto)
            .collect(Collectors.toList());
    }

	@Override
	public List<ItemIdResponse> getAllItemIdAndName(Long warehouseId) {
		List<ItemIdResponse> itemList = itemRepository.findItemIdsAndNamesByWarehouseId(warehouseId);
		System.out.println(itemList);
		return itemList;
	}

	@Override
	public float findItemHeightById(Long itemId) {
	    Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("invalid item id "));
	   
	        return item.getItemHeight();
	 
	}

	@Override
	public float findItemLengthById(Long itemId) {
		 Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("invalid item id "));
		   
	        return item.getItemLength();
	}

	@Override
	public float findItemWitdthById(Long itemId) {
		
		 Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("invalid item id "));
		   
	        return item.getItemWidth();
	}

	@Override
	public OutBoundResponse performOutBound(OutBoundRequest request) {
		OutBoundResponse response = new OutBoundResponse();
		Item item = itemRepository.findById(request.getItemId()).orElseThrow(()->new ResourceNotFoundException("Invalid item id "));
		response.setAreaId(item.getArea().getId());
		response.setRackId(item.getRack().getId());
		response.setLevelId(item.getLevel().getId());
		response.setBlockId(item.getBlock().getId());
		
		Block block = item.getBlock();
		block.setOccupiedStatus(OccupiedLevel.EMPTY);
		blockRepository.save(block);
		Log log = new Log("Out-Bound", item.getWarehouse().getId(), item.getName(), item.getId(), item.getArea().getId(), item.getRack().getId(), item.getLevel().getId(), item.getBlock().getId(), null, null, null, null);
		logRepository.save(log);
		itemRepository.deleteItemById(item.getId());
		itemRepository.flush();
		return response;
	}

	@Override
	public Boolean performInboundCheck(InBoundCheck request) {
		List<LevelDto> levelList = levelRepository.findAllLevelByItemHeight(request.getItemheight());
		if(levelList.isEmpty()) {
			return false;
		}
		List<BlockDto> blockList = new ArrayList<>();
		for(LevelDto l : levelList) {
			blockList.addAll(blockRepository.findAllBlockByLevelIdAndItemLengthAndWidth(l.getId(), request.getItemwidth(), request.getItemlength()));
		}
		if(blockList.isEmpty()) {
			return false;
		}
		return true;
	}


}



