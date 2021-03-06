package com.sadeq.javagame02;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.sadeq.javagame02.entity.mob.Player;
import com.sadeq.javagame02.graphics.Screen;
import com.sadeq.javagame02.input.Keyboard;
import com.sadeq.javagame02.level.Level;
import com.sadeq.javagame02.level.SpawnLevel;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static String title = "JavaeGame02";
	public static int width = 300;
	public static int height = width / 16* 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Keyboard key;
	private Screen screen;
	private Level level;
	private Player player;
	
	//an image to draw things onto
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	//allows us to draw things onto the above image - to access the image
	//getRaster gets the array of pixels that make the image
	//getDataBuffer get the data buffer that handles the raster - data buffer we can modify
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		player = new Player(6 * 16, 4 * 16, key);
		
		addKeyListener(key);
	}
	
	//synch. prevents thread interferences and memory inconsistency errors
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	//call method to stop applet
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		//window no longer requires to be clicked upon loading
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	//int x=0, y=0;
	
	public void update() {
		key.update();
		player.update();
	/*	if(key.up) y--;
		if(key.down) y++;
		if(key.left) x--;
		if(key.right) x++;
	*/	
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear(); //clearing previous rendered frame
		int xScroll = player.x-screen.width /2;
		int yScroll = player.y-screen.height /2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i=0; i<pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
//		g.drawString("X: " + player.x + ", Y: " + player.y, 450, 400);
		g.dispose(); //remove the frame after rendering every frame
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("JavaGame02");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null); //centres window
		game.frame.setVisible(true);
		
		game.start();
	}
	
}
