package com.sadeq.javagame02.level;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		//genereateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		genereateLevel();
	}

	protected void genereateLevel() {
	}
	
	protected void loadLevel(String path) {
	}
	
	//entities updated here
	public void update() {
	}
	
	private void time() {
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		// >>4 same as /16; we do this to work with whole tiles not pixels
		int x0 = xScroll >> 4;
		// + 16 to get rid of black edges
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x , y).render(x, y, screen);
				
			}
		}
	}
	
	// grass = 0xFF00FF00
	// flower = 0xFFFFFF00
	// rock = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height ) return Tile.voidTile;
		System.out.println("Good");
		if(tiles[x+y*width] == Tile.col_spawn_floor ) return Tile.spawn_floor;
		if(tiles[x+y*width] == Tile.col_spawn_grass ) return Tile.spawn_grass;
		if(tiles[x+y*width] == Tile.col_spawn_hedge ) return Tile.spawn_hedge;
		if(tiles[x+y*width] == Tile.col_spawn_wall1 ) return Tile.spawn_wall1;
		if(tiles[x+y*width] == Tile.col_spawn_wall2 ) return Tile.spawn_wall2;
		if(tiles[x+y*width] == Tile.col_spawn_water ) return Tile.spawn_water;
		return Tile.voidTile;
	}
	
}
