package day04_rpg;

import java.util.ArrayList;

public class LevelUp {

	static ArrayList <LevelUp> levelUp = new ArrayList<LevelUp>();
	
	int level;
	
	private LevelUp(int level) {
		this.level = level;
	}

	LevelUp() {
		int cnt = 1;
		int level = 0;
		for(int i = 0 ; i<10 ; i ++) {
			level= 100*cnt;
			cnt++;
			this.levelUp.add(new LevelUp(level));
		}
	}
}
