package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private GBusterGame gBusterGame;
		
	private Ghost ghost;
	
	private Vector2 onClick;
	
	WorldRenderer worldRenderer;
	
	World world;
	
	public GameScreen(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		onClick = new Vector2();
		
		world = new World(gBusterGame);
		worldRenderer = new WorldRenderer(gBusterGame, world);
	}
	
	private void shoot() {
		if (Gdx.input.justTouched()) {
			onClick.x = Gdx.input.getX();
			onClick.y = Gdx.input.getY();

			if (world.getGhost().getBody().contains(onClick)) {
				world.getGhost().hit();
			}
		}
	}
	
	private void update(float delta) {
		shoot();
	}
	
    @Override
    public void render(float delta) {
    	update(delta);
    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
    }

}

