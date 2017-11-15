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
	
	WorldRenderer worldRenderer;
	
	World world;
	
	public GameScreen(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		world = new World(gBusterGame);
		worldRenderer = new WorldRenderer(gBusterGame, world);
	}
	
    @Override
    public void render(float delta) {
    	world.update(delta);
    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
    }

}

