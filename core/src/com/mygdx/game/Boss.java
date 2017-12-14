package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Boss extends Ghost {
	
	public Boss(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("boss.png");
		
		super.life = 50*world.getRound();
		super.point = 0;
		super.damage = 10;
		
		super.damageGap = 10;
		super.damageTimer = this.damageGap;
	}

}
