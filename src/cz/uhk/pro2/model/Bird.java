package cz.uhk.pro2.model;

import java.awt.Color;
import java.awt.Graphics;

public class Bird {

	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;

	private static final int JUMP = 500;
	private static final int GRAVITY = 300;
	
	
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private int score;
	
	public Bird(String name, float positionX, float positionY){
		super();
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		speed = JUMP / 2;
		lives = DEFAULT_LIVES;
		score = DEFAULT_SCORE;
	}
	public void update(float deltaTime) {
		 positionY -= speed * deltaTime;
		 positionY += GRAVITY * deltaTime;
		 speed -= speed * deltaTime;
		  	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		
	
	Rectangle rectangle = getRectangle();	
	 g.fillRect( (int) getPositionX() - 25,(int) getPositionY() - 2, 50, 50);

	 public Rectangle getRectangle(){
	 return  new Rectangle( (int) getPositionX() - 25,(int) getPositionY() - 2, 50, 50);
	 }
	 public boolean collideWith(Tube tube){
	 Rectangle rectangle = getRectangle();
	 return rectangle.intersects(tube.getTop()) || rectangle.intersects(tube.getBottom());	
	 }
	 public boolean collideWith(Heart heart){
	 return getRectangle().intersects(heart.getRectangle());
	 }
	 public boolean isOutOf(){
	 Rectangle rectangle = getRectangle();
	 return rectangle.getMaxY() > MainFrame.HEIGHT || rectangle.getMinY() < 0;
	 }
	
	 public void goUp(){
	 speed = JUMP;			
	  	}
	
	public void update(float deltaTime){
		positionX += World.SPEED * deltaTime;
		positionY -= speed * deltaTime;
		 positionY += GRAVITY * deltaTime;
		 speed -= speed * deltaTime;
	}
	
	public void goUp(){
		speed=JUMP;
	}
	public void catchHeart(){
		lives++;
	}

	public void removeLive(){
		lives--;
	}
	public void addPoint(){
		score++;
	}
	
	public boolean isALive(){
		return lives > 0;
	}
	
	
	
	public int getScore() {
		return score;
	}

	public String getJmeno(){
		return name;
	}
	public float getPositionX(){
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lifes) {
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	

	
}
