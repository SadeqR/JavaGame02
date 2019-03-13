package com.sadeq.javagame02.entity.mob;

import com.sadeq.javagame02.entity.Entity;
import com.sadeq.javagame02.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move() {
		
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}
	
}
