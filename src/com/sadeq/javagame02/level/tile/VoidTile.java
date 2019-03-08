package com.sadeq.javagame02.level.tile;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);
	}

}
