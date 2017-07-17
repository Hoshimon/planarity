package com.planarity.hoshi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Planarity extends Game {
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
