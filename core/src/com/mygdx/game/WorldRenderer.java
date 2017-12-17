package com.mygdx.game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private GBusterGame gBusterGame;
	
	private World world;
	
	SpriteBatch batch;
	FileReader in = null;

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private Texture background;
	private Texture gameoverImg;
	private Texture arrestedImg;
	private Texture menu;
	
	private BitmapFont font;
	private BitmapFont scoreFont;
	private BitmapFont counterFont;

	public WorldRenderer(GBusterGame gBusterGame, World world) {
		background = new Texture("bg.jpg");
		gameoverImg = new Texture("gameover.png");
		arrestedImg = new Texture("arrested.png");
		menu = new Texture("menu.png");
		
		this.gBusterGame = gBusterGame; 
		
		batch = gBusterGame.batch;
		
		this.world = world;
		
		font = new BitmapFont();
		counterFont = new BitmapFont(Gdx.files.internal("font.fnt"));
		scoreFont = new BitmapFont(Gdx.files.internal("scoreFont.fnt"));
	}
	
	public void render(float delta) {
        batch.begin();
        
        Texture img = background;
        batch.draw(img, 0, 0);
        for (Ghost ghost: world.ghostPack) {
            Vector2 pos = ghost.getPosition();
           
            img = ghost.getGhostImg();
            batch.draw(img, pos.x, pos.y);
            font.draw(batch, "" + ghost.getLife(), pos.x, pos.y);
            if (ghost.getDamage() != -2 && ghost.getDamage() != -1) {
            	font.draw(batch, "" + df2.format(ghost.getDamageTimer()), pos.x + 70, pos.y);
            }
        }
    
        counterFont.draw(batch, "SCORE: " + world.getScore(), 50, GBusterGame.HEIGHT);
        counterFont.draw(batch, "LIFE: " + world.getHealth(), GBusterGame.WIDTH - 170, GBusterGame.HEIGHT);
        //System.out.println(onClick.x + " " + onClick.y);
        batch.end();
	}
	
	public void renderMenu() {
		batch.begin();
		Texture img = menu;
        batch.draw(img, 0, 0);
        batch.end();
	}
	
	public void renderGameover() throws IOException {
        in = new FileReader("score.txt");
        String s = "";
        int c;
        while ((c = in.read()) != -1) {
           s += (char) c;
        }
        
		batch.begin();
		Texture img = gameoverImg;
        batch.draw(img, 0, 0);
        scoreFont.draw(batch, "" + s, GBusterGame.WIDTH - 410, 145);
        batch.end();
	}
	
	public void renderArrested() throws IOException {
		in = new FileReader("score.txt");
        String s = "";
        int c;
        while ((c = in.read()) != -1) {
            s += (char) c;
        }
		
		batch.begin();
		Texture img = arrestedImg;
        batch.draw(img, 0, 0);
        scoreFont.draw(batch, "" + s, GBusterGame.WIDTH - 410, 145);
        batch.end();
	}
}
