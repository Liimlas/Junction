package com.heatfeet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HeatFeet extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private float width, height;
	Player player;

	ScreenOn s;

	public HeatFeet(ScreenOn s) {
		this.s = s;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ice.png");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		player = new Player(10,10);
		this.s.keepScreenOn(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0, width, height);

		player.draw(batch);
		player.move();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
