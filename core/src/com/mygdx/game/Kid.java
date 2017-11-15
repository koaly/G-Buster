package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Kid extends Ghost {
	
	public Kid(int x, int y, int imgWidth, int imgHeight) {
		super(x, y, imgWidth, imgHeight);
		
		super.ghostImg = new Texture("kid.png");
		
		super.life = 1;
		super.point = 0;
		super.damage = -1;
		
		super.damageTimer = 0;
		super.damageGap = 1;
	}

}
