package entity.mob.player;

import main.listeners.Keyboard;
import entity.mob.Mob;
import graphics.Screen;
import graphics.sprites.Sprite;

public class Player extends Mob {

	private Keyboard keys;

	public Player(Keyboard keys) {
		sprite = Sprite.ships[0][0];
		this.keys = keys;
	}

	public Player(Keyboard keys, int x, int y) {
		sprite = Sprite.ships[0][0];
		this.x = x;
		this.y = y;
		this.keys = keys;

	}

	public void update() {
		int xa = 0, ya = 0;

		if (keys.up) ya--;
		if (keys.down) ya++;
		if (keys.left) xa--;
		if (keys.right) xa++;

		if (!collided(xa, ya)) {
			move(xa, ya);
		}
	}

	private boolean collided(int xa, int ya) {
		return false;
	}

	public void render(Screen screen) {
		screen.renderPlayer(x - sprite.getSIZE() / 2, y - sprite.getSIZE() / 2, sprite);
	}

}
