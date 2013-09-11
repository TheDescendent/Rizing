package entity.mob;

import entity.Entity;
import graphics.sprites.Sprite;

public abstract class Mob extends Entity {
	
	public Sprite sprite;
	public double angle = 0;

	public void move(int xa, int ya) {
		x += xa;
		y += ya;
		ya = xa = 0;
		
	}

	public void rotate(double angle) {
		final double radians = Math.toRadians(angle), cos = Math.cos(radians), sin = Math.sin(radians);
		final int[] pixels2 = new int[sprite.getPixels().length];
		for (int x = 0; x < sprite.getSIZE(); x++)
			for (int y = 0; y < sprite.getSIZE(); y++) {
				final int centerx = sprite.getSIZE() / 2, centery = sprite.getSIZE() / 2, m = x - centerx, n = y
						- centery, j = ((int) (m * cos + n * sin)) + centerx, k = ((int) (n * cos - m * sin)) + centery;
				if (j >= 0 && j < sprite.getSIZE() && k >= 0 && k < sprite.getSIZE()) pixels2[(y * sprite.getSIZE() + x)] = sprite
						.getPixels()[(k * sprite.getSIZE() + j)];
			}
		arrayCopy(pixels2, sprite.getPixels());

	}

	private void arrayCopy(int[] pixels2, int[] pixels) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = pixels2[i];
		}
	}

}
