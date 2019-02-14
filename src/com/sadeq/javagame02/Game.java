package com.sadeq.javagame02;

public class Game implements Runnable {
	public static int width = 300;
	public static int height = width / 16* 9;
	public static int scale = 3;
	
	private Thread thread;
	
	//synch. prevents thread interferences and memory inconsistency errors
	public synchronized void start() {
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	//call method to stop applet
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
