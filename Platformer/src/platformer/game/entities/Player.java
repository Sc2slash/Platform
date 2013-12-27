package platformer.game.entities;

import java.awt.image.BufferedImage;

import platformer.game.Game;
import platformer.game.levels.Level;
import platformer.game.utilities.maths.Rectangle.Rect2f;
import platformer.game.utilities.maths.Vector.Vec2f;

public class Player extends Entity{
	int j = 0;
	Level curLevel;
	boolean moving;
	double timeAnimation;
	boolean jumping;
	public Vec2f cameraLocation;
	public Player(Game game, BufferedImage spritesheet, Rect2f box, Vec2f speed) {
		super(game, spritesheet, box);
		this.curLevel = game.curLevel;
		this.speed = speed;
		this.cameraLocation = new Vec2f(box.x-game.window.getWidth()/2, box.y-game.window.getHeight()/2);
		if(this.speed.x > 0 || this.speed.y > 0) moving = true;
	}

	Vec2f speed;
	
	public void update(double time){

		if(speed.y < curLevel.lvlGravity) addSpeed(new Vec2f((float)0.0, (float)(curLevel.lvlGravity*time)));
		box.x += time*speed.x;
		if(checkCollision()){
			box.x -= time*speed.x;
			speed.x = 0;
		}
		box.y += time*speed.y;	
		if(checkCollision()){
			box.y -= time*speed.y;
			speed.y = 0;
			jumping = false;
		}
		if( box.y < 0){
			box.y -= time*speed.y;
			speed.y = 0;
		}
		setCamera(new Vec2f(box.x-game.window.getWidth()/2, box.y-game.window.getHeight()/2));
	}
	public void addSpeed(Vec2f speed){
		this.speed.x += speed.x;
		this.speed.y += speed.y;
	}
	public void setSpeed(Vec2f speed){
		this.speed = speed;
	}
	public boolean checkCollision(){
		if(curLevel.getTile((int)box.x, (int)box.y).id != 0) return true;
		if(curLevel.getTile((int)(box.x+box.w), (int)box.y).id != 0) return true;
		if(curLevel.getTile((int)box.x, (int)(box.y+box.h)).id != 0) return true;
		if(curLevel.getTile((int)(box.x+box.w), (int)(box.y+box.h)).id != 0) return true;
		return false;
	}
	public void setXSpeed(float speedX){
		this.speed.x = speedX;
	}

	public void setYSpeed(float speedY){
		this.speed.y = speedY;
	}
	public void jump(){
		if(!jumping){
			setYSpeed(-200);
			jumping = true;
		}
	}
	public void stop(){
		
	}
	public void setCamera(Vec2f cameraLocation){
		this.cameraLocation = cameraLocation;
		if(this.cameraLocation.x < 0){
			cameraLocation.x = 0;
		}
		if(this.cameraLocation.y < 0){
			cameraLocation.y = 0;
		}
	}
}
