package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private GBusterGame gBusterGame;
	
	private World world;
	
	SpriteBatch batch;
	
	private BitmapFont font;

	public WorldRenderer(GBusterGame gBusterGame, World world) {
		this.gBusterGame = gBusterGame; 
		
		batch = gBusterGame.batch;
		
		this.world = world;
		
		font = new BitmapFont();
	}
	
	public void render(float delta) {
        batch.begin();
        if (world.getGhost().isAilve()) {
        	Vector2 pos = world.getGhost().getPosition();
        	Texture img = world.getGhost().getGhostImg();
        	batch.draw(img, pos.x, pos.y);
        }
        font.draw(batch, "" + world.getScore(), 50, GBusterGame.HEIGHT - 50);
        //System.out.println(onClick.x + " " + onClick.y);
        batch.end();
	}
}
