package platformer.game.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utilities {
	public static BufferedImage loadImage(String filename){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(image == null) throw new GameException("Failed to load image: " + filename);
		return image;
	}
}
