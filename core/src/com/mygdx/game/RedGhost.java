package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RedGhost extends Ghost {
	
	public RedGhost(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("redGhost.png");
		
		super.life = 2*world.getRound();
		super.point = 2;
		super.damage = 1;
		
		super.damageGap = 1;
		super.damageTimer = this.damageGap;
	}

}
