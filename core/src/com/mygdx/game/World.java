package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	
	ArrayList<Ghost> ghostPack;
	
	private final int GHOST = 0;
	private final int REDGHOST = 1;
	private final int GREENGHOST = 2;
	private final int BLUEGHOST = 3;
	private final int KID = 4;
	
	private GBusterGame gBusterGame;
	
	private Vector2 onClick;
	
	private int clock;
	private double timer;
	private static double gap;
	
	private static int roundCounter; 
	private static int gapCounter;
	
	private static int round;
	private static int score;
	private static int health;
	private static boolean isBossDead;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghostPack = new ArrayList<Ghost>();
		
		score = 0;
		health = 10;
		
		onClick = new Vector2();
		
		clock = 0;
		timer = 0;
		gap = 1.5;
		round = 1;
		
		roundCounter = 0;
		gapCounter = 0;
		
		isBossDead = true;
	}
	
	private void shoot() {
		if (Gdx.input.justTouched()) {
			onClick.x = Gdx.input.getX();
			onClick.y = Gdx.input.getY();
			
			for (Ghost ghost: ghostPack) {
				if (ghost.getBody().contains(onClick)) {
					if(ghost.getDamage() == -1) {
						gBusterGame.setScreen(new RetryScreen(gBusterGame,2,this));
					}
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
			gBusterGame.setScreen(new RetryScreen(gBusterGame,1,this));
		}
	}
	
	private void ghostAttack(float delta) {
		ArrayList<Ghost> newGhost = new ArrayList<Ghost>();
		for (Ghost ghost: ghostPack) {
			if (ghost.isAttack(delta)) {
				if (ghost.getDamage() == -1) {
					ghost.hit();
				}
				else {
					if (ghost.getDamage() == -5) {
						for (int i = 0; i < 5; i++) {
							ghostSpawner(GHOST);
					
						}
					}
					decreaseHealth(ghost.getDamage());
				}
			}
			gameOverCheck();
		}
		ghostPack.addAll(newGhost);
	}
	
	private void ghostSpawner(int type) {
		switch(type) {
		case GHOST:
			ghostPack.add(new Ghost(random(100,GBusterGame.WIDTH - 100), random(128,GBusterGame.HEIGHT - 128), 100, 128, this));
			break;
		case REDGHOST:
			ghostPack.add(new RedGhost(random(100,GBusterGame.WIDTH - 100), random(128,GBusterGame.HEIGHT - 128), 100, 128, this));
			break;
		case GREENGHOST:
			ghostPack.add(new GreenGhost(random(100,GBusterGame.WIDTH - 100), random(128,GBusterGame.HEIGHT - 128), 100, 128, this));
			break;
		case BLUEGHOST:
			ghostPack.add(new BlueGhost(random(100,GBusterGame.WIDTH - 100), random(128,GBusterGame.HEIGHT - 128), 100, 128, this));
			break;
		case KID:
			ghostPack.add(new Kid(random(100,GBusterGame.WIDTH - 100), random(195,GBusterGame.HEIGHT - 195), 100, 195, this));
			break;
		}
	}
	
	private void updateGhost() {
		ArrayList<Ghost> removeGhost = new ArrayList<Ghost>();
		for(Ghost ghost: ghostPack){
			
			if(!ghost.isAilve()) {
				if (ghost.getDamage() == 10) {
					nextRound();
				}
				increaseScore(ghost.getPoint());
				removeGhost.add(ghost);
			}
		}
		ghostPack.removeAll(removeGhost);
	}
	
	private void updateClock() {
		if (gapCounter >= 10) {
			gapCounter %= 10;
			if (gap >= 0.5) {
				gap -= 0.1;
			}
		}
		if (timer > gap) {
			timer = 0;
			clock++;
			spawnGhost();
		}
	}
	
	private void spawnGhost() {
		int rand = random(1,10);
		if (clock % 5 == 0) {
			if (rand >= 1 && rand <= 5) {
				ghostSpawner(BLUEGHOST);
			}
			else {
				ghostSpawner(GREENGHOST);
				
			}
		}
		else if (clock % 3 == 0) {
			ghostSpawner(REDGHOST);
		}
		else {
			if (rand >= 1 && rand <= 8) {
				ghostSpawner(GHOST);
			}
			else {
				ghostSpawner(KID);
				
			}
		}
	}
	
	void update(float delta) {
		timer += delta;
		
		ghostAttack(delta);
		if (isBossDead) {
			updateClock();
		}
		spawnBoss();
		shoot();
		updateGhost();
		
    } 
	
	public int getScore() {
		return score;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getRound() {
		return round;
	}
	
	public static void increaseScore(int point) {
		score += point;
		gapCounter += point;
		roundCounter += point;
	}
	
	public static void increaseHealth(int blood) {
		health += blood*round;
	}
	
	public static void decreaseHealth(int damage) {
		health -= damage*round;
	}
	
	public void spawnBoss() {
		if (roundCounter > 150) {
			roundCounter %= 150;
			ghostPack.removeAll(ghostPack);
			ghostPack.add(new Boss(0, 0, 1280, 720, this));
			isBossDead = false;
		}
	}
	
	public static void nextRound() {
		increaseHealth(10);
		gap = 2;
		round++;
		isBossDead = true;
	}
	
	
}
