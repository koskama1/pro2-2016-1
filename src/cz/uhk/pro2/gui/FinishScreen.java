package cz.uhk.pro2.gui;

import java.awt.Font;

import javax.swing.JLabel;

import cz.uhk.pro2.ScoreManager;
import cz.uhk.pro2.model.World;


public class FinishScreen extends Screen {
	JLabel scoreLabel;
	
	
	
	public FinishScreen(MainFrame mainFrame, World world){
		super(mainFrame);
		
		int score = world.getBird().getScore();
		
		ScoreManager.addScore(score);
		
		scoreLabel = new JLabel(score + "!");
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
		scoreLabel.setBounds(100, 400, 280, 50);
		
		add(scoreLabel);
		
	}
}
