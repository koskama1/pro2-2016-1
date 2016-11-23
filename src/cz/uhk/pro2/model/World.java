package cz.uhk.pro2.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	public static final int SPEED = 100;
	
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
		
		if(bird.isOutOf()){
			worlListener.outOf();
		}
		for(Heart heart : hearts){
			heart.update(deltaTime);
			
			if(bird.collideWith(heart)){
				worldListener.catchHeart(heart);
			}
		}
		for(Tube tube : tubes){
			tube.update(deltaTime);
			
			if(bird.collideWith(tube)){
				tube.setCounted(true)
				worlListener.crashTube(tube);
			} else{
				if(!tube.isCounted && bird.getPositionX() > tube.getMinX() && bird.getPositionX() < tube.getMaxX()){
					bird.addPoint();
				}
			}
		}
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	
	public List<Tube> getTubes() {
		return tubes;
	}

	public Bird getBird() {
		return bird;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

	@Override
	public String toString(){
		return "Bird: " + bird.getName()
		+ "( " + bird.getPositionX()
		+ ";" + bird.getPositionY() + " )\n"
		+ "Tubes: " + tubes.size() + "\n"
		+ "Hearts: " + hearts.size();
	}
	
	
}
