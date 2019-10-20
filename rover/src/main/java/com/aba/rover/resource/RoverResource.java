package com.aba.rover.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aba.rover.domain.model.Movement;
import com.aba.rover.domain.service.RoverService;
import com.aba.rover.exception.InvalidDirectionException;

@RestController
@RequestMapping("/rovers")
public class RoverResource {

	
	@Autowired
	private RoverService roverService;
	
	
	@GetMapping("/position")
	public ResponseEntity<String> moveRover(@RequestBody List<Movement> movement) {
		
		try {
			return ResponseEntity.ok(String.valueOf(roverService.move(movement)));
		}catch (InvalidDirectionException excInv) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.valueOf(excInv));
		}
	}
	
	@GetMapping("/english")
	public ResponseEntity<String>teachEnglish(@RequestBody String englishText){
		
		roverService.teachText(englishText);
		return ResponseEntity.ok("Rover is displaying the message on his display:" + englishText);
	}
	
}