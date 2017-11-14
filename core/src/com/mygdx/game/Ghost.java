package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ghost {
	private Vector2 position;
	private int life;
	private Texture ghostImg;
	private Rectangle body;
	
	public Ghost(int x, int y, int imgWidth, int imgHeight) {
		ghostImg = new Texture("ghost1.png");
		position = new Vector2(x, y);
		this.life = 1;
		this.body = new Rectangle(x, GBusterGame.HEIGHT - (y + imgHeight), imgWidth, imgHeight);
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
	
	public Texture getGhostImg() {
		return ghostImg;
	}
	
	
}
