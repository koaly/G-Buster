package com.mygdx.game;

import java.sql.Time;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundFx {

	Sound gunShot;
	Sound bite;
	Sound scream;
	Sound gameover;
	
	public SoundFx() {
		gunShot = Gdx.audio.newSound(Gdx.files.internal("gunshot.mp3"));
		bite = Gdx.audio.newSound(Gdx.files.internal("bite.mp3"));
		scream = Gdx.audio.newSound(Gdx.files.internal("scream.mp3"));
		gameover = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));
	}

	public void playGunShot() {
		gunShot.play();
	}
	
	public void playBite() {
		bite.play();
	}
	
	public void playScream() {
		scream.play();
	}
	
	public void playGameOver() {
		gameover.play();
	}
	
}
