package cz.uhk.pro2.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import cz.uhk.pro2.model.World;

public class GameCanvas extends Canvas {
	private World world;
	
	public GameCanvas(World world){
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.red);
		g.fillRect(400, 400, 50, 50);
	}
}
