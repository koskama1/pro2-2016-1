package cz.uhk.pro2.model;

import java.awt.Color;

public class Ground {

	public Ground(float height, Color color) {
		super();
		this.height = height;
		this.color = color;
	}
	
	private float height;
	private Color color;
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
