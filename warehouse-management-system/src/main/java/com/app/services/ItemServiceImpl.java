package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ItemDto;
import com.app.entities.Area;
import com.app.entities.Block;
import com.app.entities.Item;
import com.app.entities.Level;
import com.app.entities.Rack;
import com.app.entities.Warehouse;
import com.app.repository.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;

	@Override
	public ItemDto transfer(ItemDto detachedItem) {
		
		
			return mapItemToItemDto(itemRepository.save(mapItemDtoToItem(detachedItem)));
		}
	
	public Item mapItemDtoToItem(ItemDto itemDto) {
		
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setUnits(itemDto.getUnits());
        // Assuming you have the appropriate constructors or setter methods for references
        if (itemDto.getWarehouseId() != null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(itemDto.getWarehouseId());
            item.setWarehouse(warehouse);
        }

        if (itemDto.getAreaId() != null) {
            Area area = new Area();
            area.setId(itemDto.getAreaId());
            item.setArea(area);
        }

        if (itemDto.getRackId() != null) {
            Rack rack = new Rack();
            rack.setId(itemDto.getRackId());
            item.setRack(rack);
        }

        if (itemDto.getLevelId() != null) {
            Level level = new Level();
            level.setId(itemDto.getLevelId());
            item.setLevel(level);
        }

        if (itemDto.getBlockId() != null) {
            Block block = new Block();
            block.setId(itemDto.getBlockId());
            item.setBlock(block);
        }

       
        item.setStatus(itemDto.getStatus());
 

        return item;
    }


	@Override
	public List<ItemDto> getAllItems(Long warehouseId) {
		ArrayList<Item> items= (ArrayList<Item>) itemRepository.findByWarehouseId(warehouseId);
		return mapItemsToItemDtos(items);
		
	}
	
	public ItemDto mapItemToItemDto(Item item) {
        ItemDto responseItem = new ItemDto();
        responseItem.setId(item.getId());

        if (item.getWarehouse() != null) {
            responseItem.setWarehouseId(item.getWarehouse().getId());
        }
        
        if (item.getArea() != null) {
            responseItem.setAreaId(item.getArea().getId());
        }
        
        if (item.getRack() != null) {
            responseItem.setRackId(item.getRack().getId());
        }
        
        if (item.getLevel() != null) {
            responseItem.setLevelId(item.getLevel().getId());
        }
        
        if (item.getBlock() != null) {
            responseItem.setBlockId(item.getBlock().getId());
        }
        
        responseItem.setStatus(item.getStatus().toString());
        
        responseItem.setUnits(item.getUnits());

        return responseItem;
    }

    public List<ItemDto> mapItemsToItemDtos(List<Item> items) {
        return items.stream()
            .map(this::mapItemToItemDto)
            .collect(Collectors.toList());
    }
}



