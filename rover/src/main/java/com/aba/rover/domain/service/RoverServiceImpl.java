package com.aba.rover.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aba.rover.domain.model.Display;
import com.aba.rover.domain.model.Movement;
import com.aba.rover.domain.model.Position;
import com.aba.rover.exception.*;

@Service
public class RoverServiceImpl implements RoverService {

	
	@Override
	public Position move(List<Movement> movement) throws InvalidDirectionException{
		
		boolean invalidDirection = false;
		Position position = iniPosition;
		
		for (Movement mov: movement) {
			Integer units = mov.getUnits();
			
			//validamovimient();
			switch(mov.getDirection()) {
			
				case "N": moveLongitude(position, units, false); break;
				case "S": moveLongitude(position, units, true); break;
				case "W": moveLatitude(position, units, true); break;
				case "E": moveLatitude(position, units, false); break;
				default: invalidDirection = true;
			}
			
			
			if(invalidDirection) {
				throw new InvalidDirectionException(mov.getDirection());
			}
			if(position.validatePosition()){
				throw new InvalidDirectionException(mov.getDirection());
			}
		}
		return position;
	
	}
	
	
	@Override
	public void teachText(String text) {
		
		Display display = new Display(text);
		
		display.teach();
	}
	
	
	/*private boolean validatePosition(Position position) {
		
		return (position.getLatitude() < Position.MINLAT
				|| position.getLatitude() > Position.MAXLAT
				|| position.getLongitude() < Position.MINLONG
				|| position.getLongitude() > Position.MAXLONG);
	}*/
	
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
