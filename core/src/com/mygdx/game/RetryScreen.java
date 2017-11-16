package com.mygdx.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RetryScreen extends ScreenAdapter {

private GBusterGame gBusterGame;
	
	WorldRenderer worldRenderer;
	
	World world;
	
	private int mode;
	
	public RetryScreen(GBusterGame gBusterGame, int mode, World world) {
		this.gBusterGame = gBusterGame;
		this.mode = mode;
		
		this.world = world;
		worldRenderer = new WorldRenderer(gBusterGame, world);
	}
	
    @Override
    public void render(float delta) {    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyPressed(Keys.ENTER)){
	    	try {
				gBusterGame.setScreen(new MenuScreen(gBusterGame));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
        if (mode == 1) {
        	worldRenderer.renderGameover();
        }
        else {
        	worldRenderer.renderArrested();
        }
    }
    
}