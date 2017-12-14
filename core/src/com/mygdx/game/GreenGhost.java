package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GreenGhost extends Ghost {
	
	public GreenGhost(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("greenGhost.png");
		
		super.life = 5*world.getRound();
		super.point = 5;
		super.damage = 5;
		
		super.damageGap = 3;
		super.damageTimer = this.damageGap;
	}

}
