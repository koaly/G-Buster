package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class YellowGhost extends Ghost {
	
	public YellowGhost(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("yellowGhost.png");
		
		super.life = 1*world.getRound();
		super.point = 0;
		super.damage = -2;
		
		super.damageGap = 0;
		super.damageTimer = this.damageGap;
	}

}
