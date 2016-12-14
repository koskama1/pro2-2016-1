package cz.uhk.pro2.gui;

import java.awt.Color;	
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cz.uhk.pro2.gui.WorldListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.pro2.model.Bird;
import cz.uhk.pro2.model.Heart;
import cz.uhk.pro2.model.Tube;
import cz.uhk.pro2.model.World;

public class GameScreen extends Screen implements WorldListener {
	
	private long lastTimeMillis;	
	private Timer timer; 	
	private Bird bird;
	
	private JLabel jLabelScore, jLabelLives;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonPause.setBounds(20, 90, 60, 60);
		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 8));
		jButtonBack.setForeground(Color.RED);
		jButtonPause.setFont(new Font("Arial", Font.PLAIN, 8));
		jButtonPause.setForeground(Color.RED);
		
		JLabel jLabelLives = new JLabel("Lives: " + Bird.DEFAULT_LIVES);
		JLabel jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		
		jLabelLives.setBounds(100, 20, 80, 50);
		jLabelScore.setBounds(240, 20, 80, 50);
		
		add(jButtonBack);
		add(jButtonPause);
		add(jLabelLives);
		add(jLabelScore);
		
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));	
				timer.stop();
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning())
					timer.stop();
				else{
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
					
				}	
			}
		});
		

		
		//World
		Bird bird = new Bird("Bird1", 240, 400);
		World world = new World(bird, this);
		
		/*world.addTube(new Tube(400, 400, Color.GREEN));
		world.addTube(new Tube(600, 300, Color.GREEN));
		world.addTube(new Tube(800, 500, Color.GREEN));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));*/
		
		world.generateRandom();
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		gameCanvas.addMouseListener(new MouseAdapter(){
		
			 public void mousePressed(MouseEvent e) {
				 super.mousePressed(e);
				 bird.goUp();
			 	}
			 });
		
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis) / 1000f;
				world.update(delta);
				
				jLabelLives.setText("Lives: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());
				
				if(bird.isALive()==false){
					timer.stop();
					FinishScreen finishScreen = new FinishScreen(mainFrame,world);
					mainFrame.setScreen(finishScreen);	
					}
				
				gameCanvas.repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}
		
		@Override
		public void crashTube(Tube tube) {
			bird.removeLive();
			bird.setPositionY(tube.getCenterY());
			bird.setSpeed(400);
			
		}

		@Override
		public void outOF() {
			bird.setSpeed(bird.JUMP);
			bird.setPositionY(MainFrame.HEIGHT / 2);
			bird.removeLive();
		}
		
		@Override
		public void catchHeart(Heart heart) {
			heart.setPositionY(-100);
			bird.catchHeart();
			bird.addLive();
		}
		
		
	

}
