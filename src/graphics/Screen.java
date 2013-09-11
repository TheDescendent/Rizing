package graphics;

import essentials.tools.helpers.vectors.Vector2D;

public class Screen {

	private int[] pixels;
	private int width, height;

	private Vector2D offset;

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
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

			}
		}
	}

	public void renderPlayer() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

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
}
