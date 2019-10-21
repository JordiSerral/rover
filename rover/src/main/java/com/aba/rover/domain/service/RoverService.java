package com.aba.rover.domain.service;

import java.util.List;

import com.aba.rover.domain.model.Movement;
import com.aba.rover.domain.model.Position;
import com.aba.rover.exception.InvalidDirectionException;

/**
 * Rover Service Interface
 * @author Jordi Serral
 * 
 */

public interface RoverService {
	
	public Position move(List<Movement> movement) throws InvalidDirectionException;
	
	public void teachText(String text);
}
