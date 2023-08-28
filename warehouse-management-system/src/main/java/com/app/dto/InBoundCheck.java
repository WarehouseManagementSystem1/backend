package com.app.dto;

public class InBoundCheck {
	private String itemname;
	private int units;
	private float itemheight;
	private float itemlength;
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
