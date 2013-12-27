package platformer.game.resources;

import java.awt.image.BufferedImage;
import java.util.List;

import platformer.game.utilities.Utilities;

public class Resources {
	public BufferedImage icon;
	public BufferedImage tileset;
	public Sound test;
	public BufferedImage character;
	public Resources(){
		icon = Utilities.loadImage("Resources/Graphics/HUD/icon.png");
		tileset = Utilities.loadImage("Resources/Graphics/Tilesets/normalworld.png");

		character = Utilities.loadImage("Resources/Graphics/Characters/p1_spritesheet.png");
		test = new Sound("Resources/Audio/game_ready.wav");
		
	}
}
