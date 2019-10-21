package com.aba.rover.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aba.rover.domain.model.Display;
import com.aba.rover.domain.model.Movement;
import com.aba.rover.domain.model.Position;
import com.aba.rover.exception.*;

/**
 * Rover Service Implementation
 * 
 * @author Jordi Serral
 * 
 */
@Service
public class RoverServiceImpl implements RoverService {

	@Override
	public Position move(List<Movement> movement) throws InvalidDirectionException{
		
		boolean invalidDirection = false;
		
		Position position = new Position();
		
		for (Movement mov: movement) {
			Integer units = mov.getUnits();
			
			switch(mov.getDirection()) {
			
				case "N": moveLongitude(position, units, true); break;
				case "S": moveLongitude(position, units, false); break;
				case "W": moveLatitude(position, units, false); break;
				case "E": moveLatitude(position, units, true); break;
				default: invalidDirection = true;
			}
			
			
			if(invalidDirection) {
				throw new InvalidDirectionException(mov.getDirection());
			}
			if(position.validatePosition()){
				throw new ExceedPositionException(position);
			}
		}
		return position;
	
	}
	
	
	@Override
	public void teachText(String text) {
		
		Display display = new Display(text);
		
		display.teach();
	}
	
	
	private void moveLongitude(Position position, Integer units, boolean advance) {
		
		if(!advance)
			position.setLongitude(position.getLongitude() - units);
		else
			position.setLongitude(position.getLongitude() + units);
		
	}
	
	private void moveLatitude(Position position, Integer units, boolean advance) {
		
		
		if(!advance)
			position.setLatitude(position.getLatitude() - units);
		else
			position.setLatitude(position.getLatitude() + units);
	}

}
