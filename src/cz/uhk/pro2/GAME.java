package cz.uhk.pro2;

import cz.uhk.pro2.gui.ScoreScreen;

import java.io.File;
import java.io.IOException;

import cz.uhk.pro2.gui.HomeScreen;
import cz.uhk.pro2.gui.MainFrame;

public class GAME {
	
	public static final String SCORE_FILE = "scores.csv";

	public static void main(String[] args) {
		
		File file = new File(SCORE_FILE);
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch(IOException e){
				System.out.println("Nejde vytvoøit soubor");
			}
		}
		

		MainFrame mainFrame = new MainFrame();		
		mainFrame.setScreen(new HomeScreen(mainFrame));
		
		
	}

}
