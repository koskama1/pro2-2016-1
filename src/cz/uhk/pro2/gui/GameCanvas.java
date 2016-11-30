package cz.uhk.pro2.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import cz.uhk.pro2.model.Bird;
import cz.uhk.pro2.model.Heart;
import cz.uhk.pro2.model.Tube;
import cz.uhk.pro2.model.World;

public class GameCanvas extends Canvas {
	private World world;
	
	public static int UP_DOWN = 100;
	public static int UP_BOUND = 70;
	
	public GameCanvas(World world){
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		Bird bird = world.getBird();
		bird.paint(g);
		
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts){
			heart.paint(g);
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes){
			tube.paint(g);
		}	
		
		g.setColor(Color.orange);
		g.fillRect(0, 0, MainFrame.WIDTH, UP_BOUND);
		
		g.setColor(Color.black);
		g.fillRect(0, MainFrame.HEIGHT - DOWN_BOUND, MainFrame.WIDTH, DOWN_BOUND);
	}
}
