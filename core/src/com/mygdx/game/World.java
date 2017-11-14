package com.mygdx.game;

public class World {
	private Ghost ghost;
	private GBusterGame gBusterGame;
	
	World(GBusterGame gBusterGame) {
		this.gBusterGame = gBusterGame;
		
		ghost = new Ghost(100, 100, 150, 192);
	}
	Ghost getGhost() {
		return ghost;
	}
}
