package com.heatfeet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HeatFeet extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Player player;
	ShapeRenderer sr;
	private float width, height;

	@Override
	public void create () {
		player = new Player(200,200);
		batch = new SpriteBatch();
		img = new Texture("ice.png");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		sr = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(img, 0, 0, width, height);
		player.move();

		batch.draw(player.sprite, player.x, player.y, player.width, player.height);

		batch.end();
		sr.setColor(Color.RED);
		sr.begin(ShapeRenderer.ShapeType.Line);

		for(int i = 1; i < player.melts.size(); i++){
			sr.rectLine(player.melts.get(i)._1, player.melts.get(i)._2, player.melts.get(i-1)._1, player.melts.get(i-1)._2, i/5);
			//sr.rectLine(20+i*2,20+i*2,200,200, i/5);
		}
		sr.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
