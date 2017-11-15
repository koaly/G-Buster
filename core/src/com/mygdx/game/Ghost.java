package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ghost {
	private Vector2 position;
	private Rectangle body;
	protected int life;
	protected Texture ghostImg;
	private Texture ghostAttack;
	protected int point;
	protected int damage;
	protected double damageTimer;
	protected double damageGap; 
	
	public Ghost(int x, int y, int imgWidth, int imgHeight) {
		this.body = new Rectangle(x, GBusterGame.HEIGHT - (y + imgHeight), imgWidth, imgHeight);
		position = new Vector2(x, y);
		
		this.ghostImg = new Texture("ghost.png");
		
		this.life = 1;
		this.point = 1;
		this.damage = 1;
		
		this.damageTimer = 0;
		this.damageGap = 1;
	}
	
	public void hit() {
		this.life--;
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
	
	public int getPoint() {
		return point;
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
