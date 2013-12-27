package platformer.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import platformer.game.Game;
import platformer.game.utilities.maths.Rectangle.Rect2f;
import platformer.game.utilities.maths.Rectangle.Rect2i;

public class Entity {
	Game game;
	BufferedImage spritesheet;
	Rect2f box;
	Rect2i[] animations;
	int animation;
	public Entity(Game game, BufferedImage spritesheet, Rect2f box){
		this.game = game;
		this.spritesheet = spritesheet;
		this.box = box;
		animations = new Rect2i[30];
		this.animation = 0;
		int i = 0;
		for(int y = 0; y < spritesheet.getHeight(); y+=box.h)
			for(int x = 0; x < spritesheet.getWidth(); x+=box.w){
			animations[i] = new Rect2i(x, y, x+box.w, y+box.h);
			i++;
		}
	}
	public void draw(Graphics g){
		g.drawImage(spritesheet, (int)(box.x-game.cameraLocation.x), (int)(box.y-game.cameraLocation.y), (int)(box.x-game.cameraLocation.x+box.w), (int)(box.y-game.cameraLocation.y+box.h), animations[animation].x, animations[animation].y, animations[animation].x+animations[animation].w, animations[animation].y+animations[animation].h, null);
	}
}
