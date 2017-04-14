
package com.bundem.game;

import com.badlogic.gdx.Game;
import com.bundem.screens.GameScreen;
import com.bundem.screens.Menu;

public class MyGame extends Game {

	private GameScreen game;
	private Menu menu;

	@Override
	public void create () {
		System.out.println("started intialize Main");
		game = new GameScreen(this);
		menu = new Menu(this);
		//setScreen(game);
		setScreen(menu);
	}

	@Override
	public void resize(int width, int height) {

	}
}

