package cz.uhk.pro2.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Heart {

	private float positionX, positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public float getPositionX() {
		return positionX;
	}	
	public float getPositionY() {
		return positionY;
	}
	
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}	
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	
	
	public void paint(Graphics g, BufferedImage imageHeart){
		g.setColor(Color.RED);
		
		Rectangle rectangle = getRectangle();
		
		g.drawImage(imageHeart,
				(int) rectangle.getX(),
				(int) rectangle.getY(),
				(int) rectangle.getWidth(),
				(int) rectangle.getHeight(),
				null);
		  
		 g.fillRect( (int) rectangle.getX(),
		 (int) rectangle.getY()	,
		 (int)rectangle.getWidth(),
		 (int)rectangle.getHeight());
		 }
	
	public void update(float deltaTime){
		 positionX -= World.getSpeed() * deltaTime;	
	}
	
	public Rectangle getRectangle(){
		 return  new Rectangle( (int) getPositionX() - 25,(int) getPositionY() - 2, 50, 50);
	}

	public static float getRandomY(){
		return (new Random().nextFloat() *300) + 200;
	}






	
	
	
}
