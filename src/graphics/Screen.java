package graphics;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import essentials.tools.helpers.vectors.Vector2D;
import graphics.sprites.Sprite;

public class Screen {

	private int[] pixels;
	private int width, height;

	private Vector2D offset;

	private int[] bgPixels;
	private Dimension bgSize;

	public Screen(int w, int h) {
		width = w;
		height = h;
		pixels = new int[width * height];
		offset = new Vector2D();
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0xFF000000;
	}

	public void render() {
		for (int y = 0; y < bgSize.height; y++) {
			for (int x = 0; x < bgSize.width; x++) {
				pixels[x + y * width] = bgPixels[x + y * bgSize.width];
			}
		}
	}

	public void renderPlayer(int xa, int ya, Sprite sprite) {
		for (int y = 0; y < sprite.getSIZE(); y++) {
			for (int x = 0; x < sprite.getSIZE(); x++) {
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) break;
				pixels[(xa) + (ya) * width] = sprite.getPixels()[x + y * sprite.getSIZE()];
			}
		}
	}

	public void setOffset(int x, int y) {
		offset.x = x;
		offset.y = y;
	}

	public Vector2D getOffset() {
		return offset;
	}

	public void setBackground(String path) {
		try {
			BufferedImage img = ImageIO.read(Screen.class.getResource(path));
			bgSize = new Dimension(img.getWidth(), img.getHeight());
			bgPixels = new int[bgSize.width * bgSize.height];
			img.getRGB(0, 0, bgSize.width, bgSize.height, bgPixels, 0, bgSize.width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
