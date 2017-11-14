package com.mygdx.game;

public class World {
	private Ghost ghost;
	private GBusterGame gBusterGame;
	
	private static int score;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghost = new Ghost(100, 100, 150, 192);
		
		score = 0;
	}
	Ghost getGhost() {
		return ghost;
	}
	
	public int getScore() {
		return score;
	}
	
	public static void increaseScore(int point) {
		score += point;
	}
}
