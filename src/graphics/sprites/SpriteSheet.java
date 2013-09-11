package graphics.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int[] pixels;
	private final int SIZE;
	private String path;

	public SpriteSheet(int size, String path) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.path = path;

		load();
	}

	private void load() {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			img.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getSIZE() {
		return SIZE;
	}

}
