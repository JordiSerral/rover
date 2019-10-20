package com.aba.rover.domain.model;

import java.util.Objects;

public class Position {
	
	private Integer latitude;
	private Integer longitude;
	
	public static final Integer MAXLAT = 100;
	public static final Integer MAXLONG = 100;
	
	
	public Position() {
		this.latitude = 0;
		this.longitude = 0;
	}
	
	public Position(Integer latitude, Integer longitude) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		
	}


	public Integer getLatitude() {
		return latitude;
	}


	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}


	public Integer getLongitude() {
		return longitude;
	}


	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}


	@Override
	public String toString() {
		return "Position [Latitude=" + latitude + ", Longitude=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude,longitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || (getClass() != obj.getClass()))
			return false;
		Position pos = (Position) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(pos.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(pos.longitude))
			return false;
		return true;
	}

}
