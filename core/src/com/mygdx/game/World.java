package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {
	ArrayList<Ghost> ghostPack;
	
	//private Ghost ghost;
	private GBusterGame gBusterGame;
	
	private Vector2 onClick;
	
	private double spawnTimer;
	private final double spawnGap = 1;
	
	private static int score;
	private static int health;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghostPack = new ArrayList<Ghost>();
		
		//ghost = new Ghost(100, 100, 150, 192);
		
		score = 0;
		health = 10;
		
		onClick = new Vector2();
		
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
	
	private void attack(float delta) {
		for (Ghost ghost: ghostPack) {
			if (ghost.isAttack(delta)) {
				decreaseHealth(ghost.getDamage());
			}
		}
	}
	
	private void spawn() {
		if (spawnTimer > spawnGap) {
			spawnTimer = 0;
			ghostPack.add(new Ghost(random(150,GBusterGame.WIDTH - 150), random(192,GBusterGame.HEIGHT - 192), 150, 192));
		}
	}
	
	private void updateGhost() {
		ArrayList<Ghost> removeGhost = new ArrayList<Ghost>();
		for(Ghost ghost: ghostPack){
			if(!ghost.isAilve())
				removeGhost.add(ghost);
		}
		ghostPack.removeAll(removeGhost);
	}
	
	void update(float delta) {
		spawnTimer += delta;
		
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
