package com.sadeq.javagame02.level;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		genereateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	protected void genereateLevel() {
	}
	
	private void loadLevel(String path) {
	}
	
	//entities updated here
	public void update() {
	}
	
	private void time() {
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		// >>4 same as /16; we do this to work with whole tiles not pixels
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
	}
	
	public Tile getTile(int x, int y) {
		if(tiles[x+y*width] == 0 ) return Tile.grass;
		return Tile.voidTile;
	}
	
}
