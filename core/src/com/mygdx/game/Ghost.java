package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ghost {
	private Vector2 position;
	private int life;
	private Texture ghostImg;
	private Texture ghostAttack;
	private Rectangle body;
	private int point;
	private int damage;
	private double damageTimer;
	private double damageGap; 
	
	public Ghost(int x, int y, int imgWidth, int imgHeight) {
		ghostImg = new Texture("ghost1.png");
		ghostAttack = new Texture("ghost1_attack.png");
		position = new Vector2(x, y);
		this.life = 1;
		this.point = 1;
		this.damage = 1;
		this.body = new Rectangle(x, GBusterGame.HEIGHT - (y + imgHeight), imgWidth, imgHeight);
		
		this.damageTimer = 0;
		this.damageGap = 1.5;
	}
	
	public void hit() {
		this.life--;
		World.increaseScore(point);
	}
	
	public boolean isAilve() {
		return this.life > 0;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBody() {
		return body;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public boolean isAttack(float delta) {
		damageTimer += delta;
		if (damageTimer > damageGap) {
			damageTimer = 0;
			return true;
		}
		else return false;
	}
	
	public double getDamageGap() {
		return damageGap;
	}
	
	public Texture getGhostImg() {
		return ghostImg;
	}
	
	public Texture getGhostAttack() {
		return ghostAttack;
	}
	
	
}
