package platformer.game.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import platformer.game.Game;
import platformer.game.utilities.GameException;
import platformer.game.utilities.maths.Vector.Vec2f;

public class Level {
	BufferedImage background;
	Tileset tileset;
	Game game;
	Tile[][] terrainMap;
	Tile[][] terrainObjectMap;
	int width, height;
	public int lvlGravity;
	public Level(Tileset tileset, String mapName, Game game, int gravity){
		this.tileset = tileset;
		this.game = game;
		lvlGravity = gravity;
		loadLevel(mapName);
	}
	private void loadLevel(String filename){
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner == null) throw new GameException("Game map not found");
		
		width = scanner.nextInt();
		height = scanner.nextInt();
		terrainMap = new Tile[height][width];
		scanner.useDelimiter(",");
		for(int y = 0; y < height; y++){
			scanner.nextLine();
			for(int x = 0; x < width; x++)
			{
				terrainMap[y][x] = tileset.tiles[scanner.nextInt()];
			}
		}
	}
	public void draw(Graphics g){
		Vec2f cameraLocation = game.testEntity.cameraLocation;
		int tileHeight = tileset.tileHeight, tileWidth = tileset.tileWidth;
		for(int yLoc = (int) -cameraLocation.y%tileHeight, y = (int) ((yLoc+cameraLocation.y)/tileHeight); yLoc < game.window.getHeight(); yLoc+=tileHeight, y++)
			for(int xLoc = (int) -cameraLocation.x%tileWidth, x = (int) ((xLoc+cameraLocation.x)/tileWidth); xLoc < game.window.getWidth(); xLoc+=tileWidth, x++){
				if(terrainMap[y][x].id != 0)
					terrainMap[y][x].draw(g, xLoc, yLoc);
			}
	}
	public Tile getTile(int x, int y){
		return terrainMap[y/tileset.tileHeight][x/tileset.tileWidth];
	}
}
