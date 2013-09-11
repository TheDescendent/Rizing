package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import main.listeners.Keyboard;
import essentials.frameworks.game.GameBase;
import graphics.Screen;

public class Game extends GameBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Screen screen;
	Keyboard keys;

	public Game() {
		title = "Rizing";
		width = 250;
		height = width / 5 * 3;
		scale = 3;
		construct(width, height, scale);

		screen = new Screen(width, height);

		keys = new Keyboard();
		addKeyListener(keys);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		keys.update();
	}

	@Override
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, size.width, size.height, null);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		running();
	}

	@Override
	public void start() {
		startGameThread(this, null);
	}

	@Override
	public void stop() {
		stopGameThread();

	}

	public static void main(String[] args) {
		Game main = new Game();
		main.frame.init(main, main.title);

		main.start();
	}

}
