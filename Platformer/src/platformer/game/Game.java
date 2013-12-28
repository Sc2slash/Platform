package platformer.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import platformer.game.entities.Player;
import platformer.game.levels.Level;
import platformer.game.levels.Tileset;
import platformer.game.resources.Resources;
import platformer.game.utilities.FPSTimer;
import platformer.game.utilities.maths.Rectangle.Rect2f;
import platformer.game.utilities.maths.Vector.Vec2f;

public class Game{
	int a = 1;
	public Window window;
	public InputHandler inputHandler;
	public Resources resources;
	public boolean running;
	public boolean debugMode;
	public Level curLevel;
	public FPSTimer mainTimer;
	public Vec2f cameraLocation;
	public Player testEntity;
	public Game(){
		resources = new Resources();
		window = new Window("Plaftormer", 1200,900, 1, false, null);
		running = false;
		debugMode = false;
		mainTimer = new FPSTimer();
//		curLevel = new Level(new Tileset(resources.tileset, 70, 70, 2), "Resources/Levels/map.txt", this, 120);
//		cameraLocation = new Vec2f(0,0);
//		testEntity = new Player(this, resources.character, new Rect2f(200,0,70,96), new Vec2f(0,0));
		inputHandler = new InputHandler(this);
		start();
	}
	public void start(){
		running = true;
		window.launchWindow();
		mainTimer.startTimer();
		run();
	}
	public void run(){
		while(running){
			render();
			update();
		}
	}
	public void render(){
		BufferStrategy bs = window.getBufferStrategy();
		if(bs == null){
			window.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, window.getWidth(), window.getHeight());
		
//		//Draw Stuff
//		curLevel.draw(g);
//		testEntity.draw(g);
		g.dispose();
		bs.show();
	}
	public void update(){
		double time = mainTimer.getTimeS();
		testEntity.update(time);
		mainTimer.checkTime();
	}
	public static void main(String args[]){
		Game game = new Game();
	}
}
