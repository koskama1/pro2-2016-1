package cz.uhk.pro2.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.pro2.gui.WorldListener;

public class World {
	
	public World(Bird bird, WorldListener worldListener) {
  		this.bird = bird;
  		tubes = new ArrayList<>();
  		hearts = new ArrayList<>();
  		this.worldListener = worldListener;
 		
  	}

	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	
	public static final int SPEED = 100;
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEART = 450;
	private boolean generated;
	
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime){
		if(generated){
			regenerate();
		}
		
		bird.update(deltaTime);
		
		if(bird.isOutOf()){
			this.worldListener.outOF();
		
		for(Tube tube : tubes){
			tube.update(deltaTime);
			
			if(bird.collideWith(tube)){
				tube.setPrulet(true)
				worldListener.crashTube(tube);
				
			} else{
				if(bird.getPositionX() > tube.getMaxX() && tube.isPrulet() == false){
					bird.addPoint();
					tube.setPrulet(true);
				}
			}
		}
		
		for(Heart heart : hearts){
			heart.update(deltaTime);
			
			if(bird.collideWith(heart))
				worldListener.catchHeart(heart);
			}
		}
	}
	
	public void generateRandom(){
		for(int i = 0; i<3; i++){
			addTube(new Tube(500 + i * SPACE_BETWEEN_TUBES, Tube.getRandomHeight(), Color.green));
		}
		
		addHeart(new Heart(500 + SPACE_BETWEEN_HEART, Heart.getRandomY()));
		generated = true;
	}
	
	private void regenerate(){
		for(Tube tube : tubes){
			if(tube.getPositionX() < -100){
				
				tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setPrulet(false);
				
			}
		}
		
		for(Heart heart : hearts){
			if(heart.getPositionX() < -100){
				heart.setPositionX(heart.getPositionX() + (hearts.size() + 3) * SPACE_BETWEEN_HEART);
				heart.setPositionY(Heart.getRandomY());
			}
		}
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	@Override
	public String toString(){
		return "Bird: " + bird.toString()
						+ "\nTubes: " + tubes.size()
						+ "\nHearts: " + hearts.size();
	}
	
	public Bird getBird() {
		return bird;
	}
	public void setBird(Bird bird) {
		this.bird = bird;
	}
	
	public List<Tube> getTubes() {
		return tubes;
	}
	public void setTubes(List<Tube> tubes) {
		this.tubes = tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}
	public void setHearts(List<Heart> hearts) {
		this.hearts = hearts;
	}

	public static float getSpeed() {
		return SPEED;
	}
	
	
}
