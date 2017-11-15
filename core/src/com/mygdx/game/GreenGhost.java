package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GreenGhost extends Ghost {
	
	public GreenGhost(int x, int y, int imgWidth, int imgHeight) {
		super(x, y, imgWidth, imgHeight);
		
		super.ghostImg = new Texture("greenGhost.png");
		
		super.life = 5;
		super.point = 5;
		super.damage = 5;
		
		super.damageTimer = 0;
		super.damageGap = 2;
	}

}
