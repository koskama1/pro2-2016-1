package cz.uhk.pro2.gui;

import cz.uhk.pro2.model.Heart;	
import cz.uhk.pro2.model.Tube;

public interface WorldListener {

	public void crashTube(Tube tube);
	 
	public void catchHeart(Heart heart);
	 	
	public void outOF();
	
}
