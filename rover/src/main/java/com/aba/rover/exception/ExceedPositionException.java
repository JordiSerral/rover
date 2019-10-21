package com.aba.rover.exception;

import com.aba.rover.domain.model.Position;

/**
 * Exception Exceed Position
 * 
 * 
 * @author Jordi Serral
 * 
 */
public class ExceedPositionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2495097060906311054L;

	public ExceedPositionException(Position position) {
		
		super("Exceed Position: " + position);
	}
}
