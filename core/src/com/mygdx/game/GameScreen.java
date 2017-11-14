package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private GBusterGame gBusterGame;
	
	private Texture ghost1Img;
	
	public GameScreen(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghost1Img = new Texture("ghost1.png");
	}
	
    @Override
    public void render(float delta) {
        SpriteBatch batch = gBusterGame.batch;
        batch.begin();
        batch.draw(ghost1Img, 100, 100);
        batch.end();

    }

}

