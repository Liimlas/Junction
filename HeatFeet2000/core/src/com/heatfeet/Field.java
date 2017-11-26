package com.heatfeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Field {
    BitmapFont font;
    private float width, height;
    private int enemyAmount = 0;
    float speedx, speedy;
    //A list of all enemies in the world.
    private ArrayList<Enemy> enemies;
    Player player;
    Sprite background;
    private Random rand;
    int counter = 0;
    int game_state = 0;

    public Field(float width, float height) {
        this.enemies = new ArrayList<Enemy>();
        this.width = width;
        this.height = height;
        this.rand = new Random();
        this.background = new Sprite(new Texture("junction_background.png"));
        this.background.setSize(width, height);
        this.player = new Player((int) (width/2), (int) (height/2), 50f);
        font = new BitmapFont();
        font.getData().setScale(10f);
        font.setColor(255f,0,0, 255f);
    }
    /**
     * Update all instances (e.g. move them)
     */
    void update() {

        this.player.update();

        ArrayList<Enemy> dyingEnemies = new ArrayList<Enemy>();

        for (Enemy enemy: enemies) {
            enemy.update();
            if(enemy.hitArea().overlaps(player.hitArea()) && player.immortalFor == 0){
                player.lives--;
                player.immortalFor = 120;
            }
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
        if(counter % 400 == 0) {
            Enemy enemy = createEnemy();
            enemies.add(enemy);
        }
        counter++;
        /*
        if (enemies.size() < 5) {
            Enemy enemy = createEnemy();
            enemies.add(enemy);
        } else if(enemies.size() < 15){
            Enemy enemy = createEnemy();
            enemies.add(enemy);
        }*/

    }

    void reset(){
        player.lives = 3;
        player.score = 0;
        enemies.clear();
        enemyAmount = 0;
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

        font.draw(batch, String.valueOf(player.lives), this.width - 100f,1900f);
        font.draw(batch, String.valueOf(player.score), 50f,1900f);

    }

    void draw_menu(SpriteBatch batch) {
        this.background.draw(batch);
        font.draw(batch, String.valueOf(player.lives), this.width - 100f,1900f);
        font.draw(batch, String.valueOf(player.score), 50f,1900f);
        if(game_state == 0 || game_state == 2 ){
            font.draw(batch, "Play game", 200f,height/2);
        }else {
            font.draw(batch, "Paused", 300f, height / 2);
        }
    }

    /**
     * Create an enemies at random positions
     */
    Enemy createEnemy() {
        double x,y;

        double middle_x = width / 2;
        double middle_y = height / 2;
        double spawn_radius = middle_x / 2;

        double minX = middle_x - spawn_radius;
        double minY = middle_y - spawn_radius;



        x = minX + rand.nextInt((int) spawn_radius * 2);
        y = minY + rand.nextInt((int) spawn_radius * 2);
        if (enemyAmount < 8) {
            //speedx = (float) rand.nextInt(80) / 80f + 2f;
            //speedy = (float) rand.nextInt(120) / 120f + 1f;
            speedx = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 3;
            speedy = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 3;
        } else if (enemyAmount >= 8 & enemyAmount < 14) {
            //speedx = rand.nextInt(15) / 100f + 2;
            //speedy = rand.nextInt(10) / 120f + 1;
            speedx = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 4;
            speedy = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 4;
        } else {
            //speedx = rand.nextInt(18) / 100f + 2;
            //speedy = rand.nextInt(10) / 120f + 1;
            speedx = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 5;
            speedy = rand.nextFloat()* (float) pow(-1, rand.nextInt(2)) % 1f * 5;
        }
        if(speedy/speedx == 1 || speedy/speedx ==0){
            speedy += 0.4f;
        }

        enemyAmount += 1;
        return new Enemy((int) x, (int) y,speedx,speedy);
    }
    /**
     * Remove an enemy from the enemies list (meaning that it won't exist in the game world anymore)
     * @param enemy
     */
    void removeEnemy(Enemy enemy) {
        player.score += enemy.enemySize;
        enemies.remove(enemies.indexOf(enemy));
        System.out.println("Removed enemy.");
    }
/*
    Boolean collision(Instance insta1, Instance insta2){

        Boolean joo = sqrt(pow(insta1.x -insta2.x, 2)+ pow(insta1.y - insta2.y, 2)) <= (insta1.width/2 + insta2.width/2);
        System.out.println(joo);
        return joo;
    }*/
}