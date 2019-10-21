package com.aba.rover;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.aba.rover.domain.model.Movement;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RoverApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private static final String URLMOVE = "/rovers/position";
	private static final String URLDISPLAY = "/rovers/english";
	
	@Test
	public void testMovementWest() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("W",10));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("Position [Latitude=-10, Longitude=0]", result.getBody());
	}
	
	@Test
	public void testMovementEast() throws Exception{
	
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("E",10));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("Position [Latitude=10, Longitude=0]", result.getBody());
	}
	
	@Test
	public void testMovementNorth() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("N",10));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("Position [Latitude=0, Longitude=10]", result.getBody());
	}
	
	@Test
	public void testMovementSouth() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("S",10));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("Position [Latitude=0, Longitude=-10]", result.getBody());
	}
	
	@Test
	public void testDiferentsMovement() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("S",10));
		listMovements.add(new Movement("W",50));
		listMovements.add(new Movement("N",2));
		listMovements.add(new Movement("E",1));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("Position [Latitude=-49, Longitude=-8]", result.getBody());
	}
	
	@Test
	public void testExcedPosition() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("S",10));
		listMovements.add(new Movement("W",250));
		listMovements.add(new Movement("N",2));
		listMovements.add(new Movement("E",1));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		Assert.assertTrue(result.getBody().contains("ExceedPositionException: Exceed Position:"));
	}
	
	@Test
	public void testExcedPositionSum() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("S",10));
		listMovements.add(new Movement("W",95));
		listMovements.add(new Movement("N",2));
		listMovements.add(new Movement("E",1));
		listMovements.add(new Movement("W",10));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		Assert.assertTrue(result.getBody().contains("ExceedPositionException: Exceed Position:"));
	}
	
	@Test
	public void testInvalidDirection() throws Exception{
		
		ArrayList<Movement> listMovements = new ArrayList<Movement>();
		
		listMovements.add(new Movement("S",10));
		listMovements.add(new Movement("A",10));
		listMovements.add(new Movement("N",2));
		listMovements.add(new Movement("E",1));
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLMOVE,listMovements,String.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		Assert.assertTrue(result.getBody().contains("InvalidDirectionException: Invalid Direction:"));
	}
	
	@Test
	public void testDisplay() throws Exception{
		
		String english = "Hello Aliens, I'm ABA Rover";
		
		ResponseEntity<String> result = this.restTemplate.postForEntity(URLDISPLAY,english,String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assert.assertTrue(result.getBody().contains("Rover is displaying the message on his display:"));
	}
	
}