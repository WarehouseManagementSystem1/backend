package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InBoundCheck {
	@JsonProperty("itemName")
	private String itemname;
	@JsonProperty("unitsInItem")
	private int units;
	@JsonProperty("itemHeight")
	private float itemheight;
	@JsonProperty("itemLength")
	private float itemlength;
	@JsonProperty("itemWidth")
	private float itemwidth;
	
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public float getItemheight() {
		return itemheight;
	}
	public void setItemheight(float itemheight) {
		this.itemheight = itemheight;
	}
	public float getItemlength() {
		return itemlength;
	}
	public void setItemlength(float itemlength) {
		this.itemlength = itemlength;
	}
	public float getItemwidth() {
		return itemwidth;
	}
	public void setItemwidth(float itemwidth) {
		this.itemwidth = itemwidth;
	}
	public InBoundCheck(String itemname, int units, float itemheight, float itemlength, float itemwidth) {
		super();
		this.itemname = itemname;
		this.units = units;
		this.itemheight = itemheight;
		this.itemlength = itemlength;
		this.itemwidth = itemwidth;
	}
	public InBoundCheck() {
		super();
	}
	
	
}
