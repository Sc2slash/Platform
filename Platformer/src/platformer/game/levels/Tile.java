package platformer.game.levels;

import java.awt.Graphics;

import platformer.game.Game;
import platformer.game.utilities.GameException;
import platformer.game.utilities.maths.Rectangle.Rect2f;

public class Tile {
	public Tileset tileset;
	public int id;
	public Rect2f offset;
	public Tile(Tileset tileset, int id, Rect2f offset){
		this.tileset = tileset;
		this.id = id;
		this.offset = offset;
	}
	public void draw(Graphics g, int x, int y){
		int id = this.id;
		g.drawImage(tileset.tileset, x, y, (int)(x+offset.w), (int)(y+offset.h), (int)(offset.x), (int)(offset.y), (int)(offset.x+offset.w), (int)(offset.y+offset.h), null);
	}
}
