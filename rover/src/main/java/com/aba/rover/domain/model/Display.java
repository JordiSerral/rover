package com.aba.rover.domain.model;

public class Display {

	private String text;

	
	public Display(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void teach() {
		
		System.out.println("Display:" + this.text);
	}
	
}
