package cz.uhk.pro2.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class ScoreItem extends JPanel {

	JLabel jLabelName = new JLabel();
	JLabel jLabelPosition;
	JLabel jLabelScore;
	
	public ScoreItem (int position, int score) {
		jLabelPosition = new JLabel(position + ".");
		jLabelPosition.setFont(new Font("Arial", Font.PLAIN, 40));
		jLabelPosition.setBounds(0, 0, 100, 50);
		
		jLabelName = new JLabel(String.valueOf(score));
		jLabelName.setFont(new Font("Arial", Font.PLAIN, 40));
		jLabelName.setBounds(120, 0, 200, 50);
		
		add(jLabelName);
		add(jLabelPosition);
	}
	
}
