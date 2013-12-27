package platformer.game.levels;

import java.awt.image.BufferedImage;

import platformer.game.utilities.maths.Rectangle.Rect2f;

public class Tileset {
	BufferedImage tileset;
	public Tile[] tiles;
	int tileWidth, tileHeight, spacing;
	public Tileset(BufferedImage tileset, int width, int height, int spacing){
		this.tileset = tileset;
		this.tileWidth = width;
		this.tileHeight = height;
		tiles = new Tile[256];
		tiles[0] = new Tile(this, 0, new Rect2f(-123, -123, tileWidth, tileHeight));
		int i = 1;
		for(int y = 0; y < tileset.getHeight(); y += (height+spacing))
			for(int x = 0; x < tileset.getWidth(); x += (width+spacing)){
				tiles[i] = new Tile(this, i, new Rect2f(x, y, tileWidth, tileHeight));
				i++;
			}
	}
}
