package com.heatfeet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class HeatFeet extends ApplicationAdapter {

	private SpriteBatch batch;
	private ShapeRenderer sr;
	private Field field;
	private ScreenOn so;
	private boolean gameOn;

	enum game_state {}

	public HeatFeet(ScreenOn so) {
		this.so = so;
	}

	@Override
	public void create (){
		sr = new ShapeRenderer();
		batch = new SpriteBatch();
		field = new Field(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.so.keepScreenOn(true);
		gameOn = false;
		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				gameOn = !gameOn;

				return true;
			}
		});
	}

	@Override
	public void render () {

		if(gameOn) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			field.draw(batch);
			field.update();
			batch.end();
			sr.begin(ShapeRenderer.ShapeType.Filled);
			field.player.draw_melts(sr);
			sr.end();
		}else{
			batch.begin();
			field.draw_menu(batch);
			batch.end();
		}
	}


	@Override
	public void dispose () {
		batch.dispose();
		field.background.getTexture().dispose();
		sr.dispose();
	}
}
