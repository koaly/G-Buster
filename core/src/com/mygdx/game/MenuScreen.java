package com.mygdx.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MenuScreen extends ScreenAdapter {

	private GBusterGame gBusterGame;

	private Rectangle toGameScreen;
	private Vector2 onClick;
	
	WorldRenderer worldRenderer;
	
	World world;
	
	public MenuScreen(GBusterGame gBusterGame) throws IOException {
		this.gBusterGame = gBusterGame;
		
		world = new World(gBusterGame);
		worldRenderer = new WorldRenderer(gBusterGame, world);
		
		this.toGameScreen = new Rectangle(0, 720, 1280, 720);
		this.onClick = new Vector2();
	}
	
    @Override
    public void render(float delta) {    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.justTouched()) {
			onClick.x = Gdx.input.getX();
			onClick.y = Gdx.input.getY();
			
			try {
				gBusterGame.setScreen(new GameScreen(gBusterGame));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
			
			
		}
        if(Gdx.input.isKeyPressed(Keys.ENTER)){
	   
	    	try {
				gBusterGame.setScreen(new GameScreen(gBusterGame));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
        }
        worldRenderer.renderMenu();
    }
}