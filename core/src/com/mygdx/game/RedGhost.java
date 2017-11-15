package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RedGhost extends Ghost {
	
	public RedGhost(int x, int y, int imgWidth, int imgHeight) {
		super(x, y, imgWidth, imgHeight);
		
		super.ghostImg = new Texture("redGhost.png");
		
		super.life = 2;
		super.point = 2;
		super.damage = 1;
		
		super.damageTimer = 0;
		super.damageGap = 1;
	}

}
