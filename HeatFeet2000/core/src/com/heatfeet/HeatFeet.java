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
	Texture head;
	Texture trail_blue;
	Texture trail_red;
	ShapeRenderer sr;
	private float width, height;
	Player player;
	Enemy enemy;
	ScreenOn s;

	public HeatFeet(ScreenOn s) {
		this.s = s;
	}
	@Override
	public void create () {
		player = new Player(700,700);
		enemy = new Enemy(400,400,2,2);
		batch = new SpriteBatch();
		img = new Texture("ice.png");
		head = new Texture("trace.png");
		//trail_blue = new Texture("trail_blue.png");
		//trail_red = new Texture("trail_red.png");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		sr = new ShapeRenderer();

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
		/*
		for(int i = 1; i < player.melts.size(); i++){
			batch.draw(trail_blue,player.melts.get(i)._1, player.melts.get(i)._2 ,i/3,i/3);
			batch.draw(trail_blue,(player.melts.get(i)._1 + player.melts.get(i-1)._1)/2, (player.melts.get(i)._2 + player.melts.get(i-1)._2)/2 ,i/3,i/3);
			//batch.draw(trail,(player.melts.get(i)._1 + player.melts.get(i-1)._1)*2/3, (player.melts.get(i)._2 + player.melts.get(i-1)._2)*2/3 ,i/3,i/3);

		}
	*/
		batch.draw(head, player.melts.get(player.melts.size()-1)._1, player.melts.get(player.melts.size()-1)._2, 50,50);
		enemy.draw(batch);

		enemy.move(enemy.x < 0 || enemy.x + enemy.width > width , enemy.y < 0 || enemy.y + enemy.height > height);
		batch.end();


		sr.begin(ShapeRenderer.ShapeType.Filled);

		for(int i = 1; i < player.melts.size(); i++){
			float a = 2f/255f;
			sr.setColor(new Color((i*2)/255f,0,(255-(i*2))/255f,0.5f));
			sr.circle(player.melts.get(i)._1, player.melts.get(i)._2 ,i/4);
			sr.circle((player.melts.get(i)._1 + player.melts.get(i-1)._1)/2, (player.melts.get(i)._2 + player.melts.get(i-1)._2)/2 ,i/4);

			//sr.rectLine(player.melts.get(i-1)._1, player.melts.get(i-1)._2, player.melts.get(i)._1, player.melts.get(i)._2, i/10);
			//sr.el(player.melts.get(i)._1, player.melts.get(i)._2, i/5);
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
