package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	ArrayList<Ghost> ghostPack;
	//ArrayList<RedGhost> redGhostPack;
	
	//private Ghost ghost;
	private GBusterGame gBusterGame;
	
	private Vector2 onClick;
	
	private int clock;
	private int timer;
	private final int gap = 1;
	
	private double spawnTimer;
	private final double spawnGap = 0.5;
	
	private static int score;
	private static int health;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghostPack = new ArrayList<Ghost>();
		//redGhostPack = new ArrayList<RedGhost>();
		
		//ghost = new Ghost(100, 100, 150, 192);
		
		score = 0;
		health = 10;
		
		onClick = new Vector2();
		
		clock = timer = 0;
		
		spawnTimer = 0;
	}
	
	private void shoot() {
		if (Gdx.input.justTouched()) {
			onClick.x = Gdx.input.getX();
			onClick.y = Gdx.input.getY();
			
			for (Ghost ghost: ghostPack) {
				if (ghost.getBody().contains(onClick)) {
					ghost.hit();
				}
			}
			
		}
	}
	
	private int random(int min, int max)
	{
		   int range = (max - min) + 1;     
		   return (int)(Math.random() * range) + min;
	}
	
	private void gameOverCheck() {
		if (health <= 0) {
			gBusterGame.setScreen(new RetryScreen(gBusterGame));
		}
	}
	
	private void attack(float delta) {
		for (Ghost ghost: ghostPack) {
			if (ghost.isAttack(delta)) {
				decreaseHealth(ghost.getDamage());
			}
			gameOverCheck();
		}
		/*for (RedGhost redGhost: redGhostPack) {
			if (redGhost.isAttack(delta)) {
				decreaseHealth(redGhost.getDamage());
			}
			gameOverCheck();
		}*/
	}
	
	private void spawn() {
		if (spawnTimer > spawnGap) {
			spawnTimer = 0;
			ghostPack.add(new RedGhost(random(100,GBusterGame.WIDTH - 100), random(128,GBusterGame.HEIGHT - 128), 100, 128));
		}
	}
	
	private void updateGhost() {
		ArrayList<Ghost> removeGhost = new ArrayList<Ghost>();
		for(Ghost ghost: ghostPack){
			if(!ghost.isAilve()) {
				increaseScore(ghost.getPoint());
				removeGhost.add(ghost);
			}
		}
		ghostPack.removeAll(removeGhost);
	}
	
	private void updateClock() {
		if (timer > gap) {
			timer = 0;
			clock++;
		}
	}
	
	void update(float delta) {
		spawnTimer += delta;
		timer += delta;
		updateClock();
		
		attack(delta);
		spawn();
		shoot();
		updateGhost();
		
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
