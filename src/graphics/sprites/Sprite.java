package graphics.sprites;

public class Sprite {

	private int[] pixels;
	private final int SIZE;
	private final SpriteSheet sheet;
	private int x, y;

	private static Sprite ship0_0 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship0_1 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship0_2 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);

	private static Sprite ship1_0 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship1_1 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship1_2 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);

	private static Sprite ship2_0 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship2_1 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);
	private static Sprite ship2_2 = new Sprite(32, 0, 0, SpriteSheet.shipSheet);

	public static Sprite[][] ships = { { ship0_0, ship0_1, ship0_2 }, { ship1_0, ship1_1, ship1_2 },
			{ ship2_0, ship2_1, ship2_2 } };

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getSIZE()];
			}
		}
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getPixel(int i) {
		return pixels[i];
	}

	public int getSIZE() {
		return SIZE;
	}

}
