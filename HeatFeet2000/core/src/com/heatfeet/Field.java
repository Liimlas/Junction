package com.heatfeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Field {

    private float width, height;
    //A list of all enemies in the world.
    private ArrayList<Enemy> enemies;
    Player player;
    Sprite background;
    private Random rand;

    public Field(float width, float height) {
        this.enemies = new ArrayList<Enemy>();
        this.width = width;
        this.height = height;
        this.rand = new Random();
        this.background = new Sprite(new Texture("junction_background.png"));
        this.background.setSize(width, height);
        this.player = new Player((int) (width/2), (int) (height/2), (float) 0.07 * width);
    }
    /**
     * Update all instances (e.g. move them)
     */
    void update() {

        this.player.update();

        ArrayList<Enemy> dyingEnemies = new ArrayList<Enemy>();

        for (Enemy enemy: enemies) {
            enemy.update();
            for (MeltParticle particle : this.player.melts) {
                if (enemy.hitArea().overlaps(particle.hitArea())) {
                    enemy.takeDamage(particle.damage);
                }
            }
            if (enemy.dying) {
                dyingEnemies.add(enemy);
            }

        }
        for(Enemy enemy: dyingEnemies) {
            removeEnemy(enemy);
        }


        if (enemies.size() < 10) {
            Enemy enemy = createEnemy();
            enemies.add(enemy);
        }

    }

    /**
     * Draw all instances (player + enemies)
     * @param batch
     */
    void draw(SpriteBatch batch) {
        this.background.draw(batch);


        for(Enemy enemy : enemies) {
            enemy.draw(batch);
        }
        this.player.draw(batch);
    }

    /**
     * Create an enemies at random positions
     */
    Enemy createEnemy() {

        float x,y;
        //sivuille
        if (rand.nextInt(2) == 0) {

            x = rand.nextInt(2) == 0 ? + 150 : width + 50;
            y = rand.nextInt((int) height);
        } else {
            x = rand.nextInt((int) width);
            y = rand.nextInt(2) == 0 ? + 150 : height + 50;
        }

        return new Enemy((int) x, (int) y,1.5f,2.2f);
    }
    /**
     * Remove an enemy from the enemies list (meaning that it won't exist in the game world anymore)
     * @param enemy
     */
    void removeEnemy(Enemy enemy) {
        enemies.remove(enemies.indexOf(enemy));
        System.out.println("Removed enemy.");
    }

}