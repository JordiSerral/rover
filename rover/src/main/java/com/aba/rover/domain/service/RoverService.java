package com.aba.rover.domain.service;

import java.util.List;

import com.aba.rover.domain.model.Movement;
import com.aba.rover.domain.model.Position;
import com.aba.rover.exception.InvalidDirectionException;

/**
 * @author Jordi Serral
 * 
 */

public interface RoverService {
	
	/*
	 * Move Rover with a Movement
	 */
	
	public static final Position iniPosition = new Position();
	
	
	public Position move(List<Movement> movement) throws InvalidDirectionException;
	
	public void teachText(String text);
}
