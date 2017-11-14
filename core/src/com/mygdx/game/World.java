package com.mygdx.game;

public class World {
	private Ghost ghost;
	private GBusterGame gBusterGame;
	
	private static int score;
	private static int health;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghost = new Ghost(100, 100, 150, 192);
		
		score = 0;
		
		health = 10;
	}
	Ghost getGhost() {
		return ghost;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getHealth() {
		return health;
	}
	
	public static void increaseScore(int point) {
		score += point;
	}
	
	public static void decreaseHealth(int damage) {
		health -= damage;
	}
}
