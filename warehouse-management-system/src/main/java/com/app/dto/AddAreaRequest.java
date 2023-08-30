package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAreaRequest {
	@JsonProperty("areaname")
	private String areaname;
	@JsonProperty("numracks")
	private int numberofrack;
	@JsonProperty("numLevelsperrack")
	private int numberoflevelperrack;
	@JsonProperty("levelheight")
	private float heightofeachlevel;
	@JsonProperty("numblocksperlevel")
	private int numberofblockperlevel;
	@JsonProperty("blocklength")
	private float lengthofeachblock;
	@JsonProperty("blockwidth")
	private float widthofeachblock;
	
	
	public AddAreaRequest(String areaname, int numberofrack, int numberoflevelperrack, float heightofeachlevel,
			int numberofblockperlevel, float lengthofeachblock, float widthofeachblock) {
		super();
		this.areaname = areaname;
		this.numberofrack = numberofrack;
		this.numberoflevelperrack = numberoflevelperrack;
		this.heightofeachlevel = heightofeachlevel;
		this.numberofblockperlevel = numberofblockperlevel;
		this.lengthofeachblock = lengthofeachblock;
		this.widthofeachblock = widthofeachblock;
	}
	public AddAreaRequest() {
		super();
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public int getNumberofrack() {
		return numberofrack;
	}
	public void setNumberofrack(int numberofrack) {
		this.numberofrack = numberofrack;
	}
	public int getNumberoflevelperrack() {
		return numberoflevelperrack;
	}
	public void setNumberoflevelperrack(int numberoflevelperrack) {
		this.numberoflevelperrack = numberoflevelperrack;
	}
	public float getHeightofeachlevel() {
		return heightofeachlevel;
	}
	public void setHeightofeachlevel(float heightofeachlevel) {
		this.heightofeachlevel = heightofeachlevel;
	}
	public int getNumberofblockperlevel() {
		return numberofblockperlevel;
	}
	public void setNumberofblockperlevel(int numberofblockperlevel) {
		this.numberofblockperlevel = numberofblockperlevel;
	}
	public float getLengthofeachblock() {
		return lengthofeachblock;
	}
	public void setLengthofeachblock(float lengthofeachblock) {
		this.lengthofeachblock = lengthofeachblock;
	}
	public float getWidthofeachblock() {
		return widthofeachblock;
	}
	public void setWidthofeachblock(float widthofeachblock) {
		this.widthofeachblock = widthofeachblock;
	}
	
	
	
}
