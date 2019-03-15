package com.sadeq.javagame02.entity.mob;

import com.sadeq.javagame02.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void update() {
		if(input.up) y--;
		if(input.down) y++;
		if(input.left) x--;
		if(input.right) x++;
	}
	
	public void render() {
		
	}
}
