package com.aba.rover.exception;

public class InvalidDirectionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5489776777210541216L;

	public InvalidDirectionException(String direction) {
		
		super("Invalid Direction: " + direction);
	}

}
