package cz.uhk.pro2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ScoreManager {
	
	private List<Integer> scoreList;
	private static ScoreManager instance;
	
	private ScoreManager() {
		this.scoreList = new ArrayList<>();
		}
	
	public void addScore(int score) {
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter(GAME.SCORE_FILE);
			
			fileWrite.append(String.valueOf(score));
			fileWrite.append(";");
			fileWrite.append(new Date().toGMTString());
			fileWrite.append("\n");
			
			fileWrite.flush();
			fileWrite.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		scoreList.add(score);
	}
	
	public List<Integer> getAll() {
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(GAME.SCORE_FILE);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] values = line.split(";");
				scoreList.add(Integer.valueOf(values[0]));
				}		
		} catch (IOException e) {
			System.out.println("Chyba pøi naèítání");
		}
		
		return scoreList;
	}
	
	
	public static ScoreManager getInstance() {
		if(instance == null) {
			instance = new ScoreManager();
		}
		return instance;
	}
	
	public static void putScore(int score) {
		getInstance().addScore(score);
	}
	
	public static List<Integer> getList() {
		return getInstance().getAll();
		
	}
}
