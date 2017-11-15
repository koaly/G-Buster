package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private GBusterGame gBusterGame;
	
	private World world;
	
	SpriteBatch batch;
	
	private Texture background;
	private Texture gameoverImg;
	private Texture arrestedImg;
	private Texture menu;
	
	private BitmapFont font;

	public WorldRenderer(GBusterGame gBusterGame, World world) {
		background = new Texture("bg.jpg");
		gameoverImg = new Texture("gameover.png");
		arrestedImg = new Texture("arrested.png");
		menu = new Texture("menu.png");
		
		this.gBusterGame = gBusterGame; 
		
		batch = gBusterGame.batch;
		
		this.world = world;
		
		font = new BitmapFont();
	}
	
	public void render(float delta) {
        batch.begin();
        
        Texture img = background;
        batch.draw(img, 0, 0);
        for (Ghost ghost: world.ghostPack) {
            Vector2 pos = ghost.getPosition();
           
            img = ghost.getGhostImg();
            batch.draw(img, pos.x, pos.y);
        }
    
        font.draw(batch, "" + world.getScore(), 50, GBusterGame.HEIGHT - 50);
        font.draw(batch, "" + world.getHealth(), GBusterGame.WIDTH - 50, GBusterGame.HEIGHT - 50);
        //System.out.println(onClick.x + " " + onClick.y);
        batch.end();
	}
	
	public void renderMenu() {
		batch.begin();
		Texture img = menu;
        batch.draw(img, 0, 0);
        batch.end();
	}
	
	public void renderGameover() {
		batch.begin();
		Texture img = gameoverImg;
        batch.draw(img, 0, 0);
        batch.end();
	}
	
	public void renderArrested() {
		batch.begin();
		Texture img = arrestedImg;
        batch.draw(img, 0, 0);
        batch.end();
	}
}
