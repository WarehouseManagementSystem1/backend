package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AllItemDto;
import com.app.dto.BlockDto;
import com.app.dto.InBoundCheck;
import com.app.dto.InboundResponse;
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
	public AllItemDto transfer(ItemDto detachedItem) {
		
		Item updatedItem= updateDetails(detachedItem);
		
		AllItemDto updatedItemDto=mapItemToAllItemDto(updatedItem);
		
		return updatedItemDto;
			
			
		}
	
	private AllItemDto mapItemToAllItemDto(Item updatedItem) {
		return new AllItemDto(updatedItem.getId(), updatedItem.getName(), updatedItem.getUnits(), 
				updatedItem.getBlock().getId(), updatedItem.getBlock().getBlockNumber(), 
				updatedItem.getLevel().getId(), updatedItem.getLevel().getLevelNumber(),
				updatedItem.getRack().getId(), updatedItem.getRack().getRackNumber(), 
				updatedItem.getArea().getId(),updatedItem.getArea().getAreaName(),
				updatedItem.getWarehouse().getId());
		
	}

	public Item updateDetails(ItemDto detachedItem) {
		Item item = itemRepository.findById(detachedItem.getId()).orElseThrow(()->new ResourceNotFoundException("Not a valid Id  "));
		
		//Block block = blockRepository.findById(item.getBlock().getId()).orElseThrow(()->new ResourceNotFoundException("Not a valid Id  "));
		
		Block block = item.getBlock();
		System.out.println(block);
		block.setOccupiedStatus(OccupiedLevel.EMPTY);
		
		Area newArea = areaRepository.findById(detachedItem.getAreaid()).orElse(null);
        Rack newRack = rackRepository.findById(detachedItem.getRackid()).orElse(null);
        Level newLevel = levelRepository.findById(detachedItem.getLevelid()).orElse(null);
        Block newBlock = blockRepository.findById(detachedItem.getBlockid()).orElse(null);
        newBlock.setOccupiedStatus(OccupiedLevel.OCCUPIED);
        logRepository.save(new Log("Audit", detachedItem.getWarehouseid(), item.getName(), item.getId(), item.getArea().getAreaName(), item.getRack().getRackNumber(), item.getLevel().getLevelNumber(), item.getBlock().getBlockNumber(), newArea.getAreaName(), newRack.getRackNumber(), newLevel.getLevelNumber(), newBlock.getBlockNumber()));
        item.setArea(newArea);
        item.setRack(newRack);
        item.setLevel(newLevel);
        item.setBlock(newBlock);
        itemRepository.save(item);
		blockRepository.save(newBlock);
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
	public List<AllItemDto> getAllItems(Long warehouseId) {
		List<Item> items= (List<Item>) itemRepository.findByWarehouseId(warehouseId);
		return mapItemsToAllItemDtos(items);
		
	}
	
	

    private List<AllItemDto> mapItemsToAllItemDtos(List<Item> items) {
		List<AllItemDto> allItemDtoList = new ArrayList<>();
		for(Item i : items) {
			AllItemDto a = new AllItemDto(i.getId(), i.getName(), i.getUnits(),i.getBlock().getId(), i.getBlock().getBlockNumber(), 
					i.getLevel().getId(), i.getLevel().getLevelNumber(), i.getRack().getId(),
					i.getRack().getRackNumber(), i.getArea().getId(), i.getArea().getAreaName(), i.getWarehouse().getId());
			allItemDtoList.add(a);
		}
		return allItemDtoList;
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
		response.setAreaName(item.getArea().getAreaName());
		response.setRackNumber(item.getRack().getRackNumber());
		response.setLevelNumber(item.getLevel().getLevelNumber());
		response.setBlockNumber(item.getBlock().getBlockNumber());
		
		Block block = item.getBlock();
		block.setOccupiedStatus(OccupiedLevel.EMPTY);
		blockRepository.save(block);
		Log log = new Log("Out-Bound", item.getWarehouse().getId(), item.getName(), item.getId(), item.getArea().getAreaName(), item.getRack().getRackNumber(), item.getLevel().getLevelNumber(), item.getBlock().getBlockNumber(), null, null, null, null);
		logRepository.save(log);
		itemRepository.deleteItemById(item.getId());
		itemRepository.flush();
		return response;
	}

	@Override
	public Boolean performInboundCheck(InBoundCheck request,Long warehouseId) {
		List<LevelDto> levelList = levelRepository.findAllLevelByItemHeightAndWarehouseId(request.getItemheight(),warehouseId);
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

	@Override
	public InboundResponse performInbound(InBoundCheck request, Long warehouseId) {
		List<LevelDto> levelList = levelRepository.findAllLevelByItemHeightAndWarehouseId(request.getItemheight(), warehouseId);
		List<BlockDto> blockDtoList = new ArrayList<BlockDto>();
		for(LevelDto l : levelList ) {
			blockDtoList.addAll(blockRepository.findAllBlockByLevelIdAndItemLengthAndWidth(l.getId(), request.getItemwidth(), request.getItemlength()));
		}
		Block block = blockRepository.findById(blockDtoList.get(0).getId()).orElseThrow(()->new ResourceNotFoundException("invalid Block Id "));
		block.setOccupiedStatus(OccupiedLevel.OCCUPIED);
		block = blockRepository.save(block);
		Item item = new Item();
		item.setBlock(block);
		item.setArea(block.getArea());
		item.setItemHeight(request.getItemheight());
		item.setItemLength(request.getItemlength());
		item.setItemWidth(request.getItemwidth());
		item.setLevel(block.getLevel());
		item.setName(request.getItemname());
		item.setRack(block.getRack());
		item.setUnits(request.getUnits());
		item.setWarehouse(block.getWarehouse());
		item= itemRepository.save(item);
		Log log = new Log("In-bound", warehouseId, request.getItemname(), item.getId(), null, null, null, null, item.getArea().getAreaName(), item.getRack().getRackNumber(), item.getLevel().getLevelNumber(), item.getBlock().getBlockNumber());
		log =logRepository.save(log);
		InboundResponse response = mapItemToInboundResponse(item);
		return response;
	}

	private InboundResponse mapItemToInboundResponse(Item item) {
		InboundResponse response = new InboundResponse();
		response.setAreaId(item.getArea().getId());
		response.setItemId(item.getId());
		response.setBlockId(item.getBlock().getId());
		response.setLevelId(item.getLevel().getId());
		response.setRackId(item.getRack().getId());
		return response;
	}
	

}



