package cz.uhk.pro2.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.pro2.ScoreManager;
import cz.uhk.pro2.model.World;


public class FinishScreen extends Screen {
	JLabel scoreLabel;
	JButton jButtonReplay,jButtonMenu;
	
	public FinishScreen(MainFrame mainFrame, World world){
		super(mainFrame);
		
		scoreLabel = new JLabel("Your score is " + world.getBird().getScore() + "!");
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		scoreLabel.setBounds(20, 20, 500, 50);
		
		jButtonReplay = new JButton("Replay");
		jButtonMenu = new JButton("Menu");
		
		jButtonReplay.setBounds(20, 700, 100, 50);
		jButtonMenu.setBounds(360, 700, 100, 50);
		
		add(scoreLabel);
		add(jButtonReplay);
		add(jButtonMenu);
		
		jButtonReplay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
	}
}
