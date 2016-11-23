package cz.uhk.pro2.gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.pro2.model.Bird;
import cz.uhk.pro2.model.Heart;
import cz.uhk.pro2.model.Tube;
import cz.uhk.pro2.model.World;

public class GameScreen extends Screen {
	
	private long lastTimeMillis;
	
	private Timer timer; 
	
	private Bird bird;
	
	private JLabel jLabelScore, jLabelLives;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));				
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()){
					timer.stop();
				}else{
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
					
				}
				

			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonPause.setBounds(20, 90, 60, 60);
		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 8));
		jButtonBack.setForeground(Color.RED);
		jButtonPause.setFont(new Font("Arial", Font.PLAIN, 8));
		jButtonPause.setForeground(Color.RED);
		
		add(jButtonBack);
		add(jButtonPause);
		
		jLabelLives = new JLabel("Lives: " + Bird.DEFAULT_LIVES);
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		
		jLabelLives.setBounds(260, 20, 12, 60);
		jLabelScore.setBounds(100, 20, 120, 60);
		
		add(jLabelLives);
		add(jLabelScore);
		
		
		
		//World
		Bird bird = new Bird("Bird1", 240, 400);
		World world = new World(bird);
		world.addTube(new Tube(400, 400, Color.GREEN));
		world.addTube(new Tube(600, 300, Color.GREEN));
		world.addTube(new Tube(800, 500, Color.GREEN));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		GameCanvas gameCanvas = new GameCanvas(world);
		gameCanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		add(gameCanvas);
		
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis)/1000f;
				System.out.println(delta);
				world.update(delta);
				
				jLabelLives.setText("Lives: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());
				
				if(!bird.isALive()){
					timer.stop();
				}
				
				gameCanvas.repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
		
		@Override
		public void crashTube(Tube tube) {
			bird.removeLive();
			bird.setPositionY(tube.getCenterY());
		}
		
		@Override
		public void catchHeart(Heart heart) {
			heart.setPositionY(-100);
			bird.catchHeart();
		}
		
		@Override
		public void outOf() {
			bird.setPositionY(MainFrame.HEIGHT / 2);
			bird.setSpeed(Bird.JUMP / 2);
			
			bird.removeLive();
			
		}
		
		
	}

}
