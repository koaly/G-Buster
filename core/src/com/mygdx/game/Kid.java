package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Kid extends Ghost {
	
	public Kid(int x, int y, int imgWidth, int imgHeight, World world) {
		super(x, y, imgWidth, imgHeight, world);
		
		super.ghostImg = new Texture("kid.png");
		
		super.life = 1;
		super.point = 0;
		super.damage = -1;
		
		super.damageGap = 1;
		super.damageTimer = this.damageGap;
	}

}
