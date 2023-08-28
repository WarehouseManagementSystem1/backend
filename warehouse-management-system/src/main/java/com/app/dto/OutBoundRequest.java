package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutBoundRequest {
	
	@JsonProperty("ItemId")
	private Long ItemId;

	public Long getItemId() {
		return ItemId;
	}

	public void setItemId(Long itemId) {
		ItemId = itemId;
	}

	public OutBoundRequest(Long itemId) {
		super();
		ItemId = itemId;
	}

	public OutBoundRequest() {
		super();
		
	}
	
	

}
