package com.aba.rover.domain.model;

import java.io.Serializable;

public class Movement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8352150250150125458L;
	
	private String direction;
	private Integer units;
	
	public Movement (String direction, Integer units) {
		
		this.direction = direction;
		this.units = units;
	}
	
	public Movement() {
		
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}
	

	
}
