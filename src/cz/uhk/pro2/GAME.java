package cz.uhk.pro2;

import cz.uhk.pro2.gui.GameScreen;
import cz.uhk.pro2.gui.HomeScreen;
import cz.uhk.pro2.gui.MainFrame;

public class GAME {

	public static void main(String[] args) {

		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setScreen(new HomeScreen(mainFrame));
		
		
	}

}
