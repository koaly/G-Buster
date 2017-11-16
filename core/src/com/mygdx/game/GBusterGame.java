package com.mygdx.game;

import java.io.IOException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GBusterGame extends Game {
	public SpriteBatch batch;
	
	public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		try {
			setScreen(new MenuScreen(this));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
