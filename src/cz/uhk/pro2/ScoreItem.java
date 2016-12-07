package cz.uhk.pro2;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {

	JLabel jLabelIndex, jLabelScore;
	
	public ScoreItem(int index, int score) {
		jLabelIndex = new JLabel(index + ".");
		jLabelIndex.setFont(new Font("Arial", Font.BOLD, 40));
		jLabelIndex.setBounds(0, 0, 100, 50);
		
		jLabelScore = new JLabel(String.valueOf(score));
		jLabelScore.setFont(new Font("Arial", Font.BOLD, 40));
		jLabelScore.setBounds(120, 0, 200, 50);
		
		add(jLabelIndex);
		add(jLabelScore);
	}
	
}
