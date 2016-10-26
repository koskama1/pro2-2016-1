package cz.uhk.pro2.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Screen extends JPanel {
	
	protected MainFrame mainframe;
	
	public Screen(MainFrame mainFrame){
		this.mainframe = mainFrame;
		

	}

}
