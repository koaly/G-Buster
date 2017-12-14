package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BlueGhost extends Ghost {
	
	public BlueGhost(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("blueGhost.png");
		
		super.life = 2*world.getRound();
		super.point = 2;
		super.damage = -5;
		
		super.damageGap = 3;
		super.damageTimer = this.damageGap;
	}

}
