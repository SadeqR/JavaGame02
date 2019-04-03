package com.sadeq.javagame02.level.tile.spawn_level;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.graphics.Sprite;
import com.sadeq.javagame02.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		// converted to pixel precision
		screen.renderTile(x<<4, y<<4, this);
	}

}
