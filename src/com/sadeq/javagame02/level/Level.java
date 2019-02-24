package com.sadeq.javagame02.level;

import com.sadeq.javagame02.graphics.Screen;

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
	}
	
}
