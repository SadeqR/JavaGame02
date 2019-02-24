package com.sadeq.javagame02.level.tile;

import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
}
