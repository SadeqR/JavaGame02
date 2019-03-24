package com.sadeq.javagame02.level.tile;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		// converted to pixel precision
		screen.renderTile(x<<4, y<<4, this);
	}
	
	public boolean solid() {
		return true;
	}
}
