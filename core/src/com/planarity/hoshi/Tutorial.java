package com.planarity.hoshi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Tutorial implements Screen {

    Planarity game;

    public Tutorial(Planarity game) {
        this.game = game;
    }


    Texture img;
    Texture tutorial1;
    Texture tutorial2;
    Texture nextlvl;
    private Texture circleTexture;
    private Texture retry;
    private Sprite circle;
    private Sprite circle2;
    private Sprite circle3;
    private Sprite circle4;
    private Rectangle circleRectangle;
    private Rectangle circle2Rectangle;
    private Rectangle circle3Rectangle;
    private Rectangle circle4Rectangle;
    private Rectangle buttonNext;
    private Rectangle buttonRetry;

    float posX;
    float posY;
    float pos2X;
    float pos2Y;
    float pos3X;
    float pos3Y;
    float pos4X;
    float pos4Y;
    Vector3 touchPos;

    boolean active1;
    boolean active2;
    boolean active3;
    boolean active4;

    Vector2 p1;
    Vector2 p2;
    Vector2 p3;
    Vector2 p4;

    ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        circleTexture = new Texture(Gdx.files.internal("circle25.png"));
        retry = new Texture(Gdx.files.internal("retry.png"));
        tutorial1 = new Texture(Gdx.files.internal("tutorial1.png"));
        tutorial2 = new Texture(Gdx.files.internal("tutorial2.png"));
        nextlvl = new Texture(Gdx.files.internal("nextlvl.png"));

        active1 = false;
        active2 = false;
        active3 = false;
        active4 = false;

        shapeRenderer = new ShapeRenderer();

        circle = new Sprite(circleTexture);
        circle.setPosition(Gdx.graphics.getWidth()/2 - circle.getWidth()/2, 500 - circle.getHeight()/2);
        circle2 = new Sprite(circleTexture);
        circle2.setPosition(Gdx.graphics.getWidth()/2 - circle.getWidth()/2, 100 - circle.getHeight()/2);
        circle3 = new Sprite(circleTexture);
        circle3.setPosition(150 - circle.getWidth()/2, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);
        circle4 = new Sprite(circleTexture);
        circle4.setPosition(450 - circle.getWidth()/2, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

        posX = circle.getX();
        posY = circle.getY();

        pos2X = circle2.getX();
        pos2Y = circle2.getY();

        pos3X = circle3.getX();
        pos3Y = circle3.getY();

        pos4X = circle4.getX();
        pos4Y = circle4.getY();

        p1 = new Vector2(posX, posY);
        p2 = new Vector2(pos2X, pos2Y);
        p3 = new Vector2(pos3X, pos3Y);
        p4 = new Vector2(pos4X, pos4Y);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        circleRectangle = new Rectangle(posX - 75, posY - 75, 150, 150);
        circle2Rectangle = new Rectangle(pos2X - 75, pos2Y - 75, 150,150);
        circle3Rectangle = new Rectangle(pos3X - 75, pos3Y - 75, 150,150);
        circle4Rectangle = new Rectangle(pos4X - 75, pos4Y - 75, 150,150);
        buttonNext = new Rectangle(400, 0, 200, 50);
        buttonRetry = new Rectangle(10, 10, 50, 50);

        game.batch.draw(circle, circle.getX(), circle.getY());
        game.batch.draw(circle2, circle2.getX(), circle2.getY());
        game.batch.draw(circle3, circle3.getX(), circle3.getY());
        game.batch.draw(circle4, circle4.getX(), circle4.getY());
        game.batch.draw(retry, 10, 10, 50, 50);

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if(buttonRetry.contains(touchPos.x, touchPos.y)) {
                circle.setPosition(Gdx.graphics.getWidth()/2 - circle.getWidth()/2, 500 - circle.getHeight()/2);
                circle2.setPosition(Gdx.graphics.getWidth()/2 - circle.getWidth()/2, 100 - circle.getHeight()/2);
                circle3.setPosition(150 - circle.getWidth()/2, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);
                circle4.setPosition(450 - circle.getWidth()/2, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);
            }
        }

        if(Intersector.intersectSegments(p1, p2, p3, p4, null)) {
            Gdx.gl.glClearColor(1, 1, 1, 1);
            game.batch.draw(tutorial1, 0, 400);
        }
        if(!Intersector.intersectSegments(p1, p2, p3, p4, null)) {
            Gdx.gl.glClearColor(0, 1, 0, 1);
            game.batch.draw(tutorial2, 0, 400);
            game.batch.draw(nextlvl, 400, 0);
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if(buttonNext.contains(touchPos.x, touchPos.y)) {
                    game.setScreen(new Level1(game));
                }
            }
        }

        game.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.line(posX + 12, posY + 12, pos2X + 12, pos2Y + 12);
        shapeRenderer.line(pos3X + 12, pos3Y + 12, pos4X + 12, pos4Y + 12);
        shapeRenderer.end();

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

        if(circleRectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active1 = true;
            } else { active1 = false; }
        }
        if(circle2Rectangle.contains(touchPos.x, touchPos.y) &&
                !active1 && !active3 && !active4) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle2.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active2 = true;
            }  else { active2 = false; }
        }
        if(circle3Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active1 && !active4) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle3.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active3 = true;
            } else { active3 = false; }
        }
        if(circle4Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active1) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle4.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active4 = true;
            } else { active4 = false; }
        }

        posX = circle.getX();
        posY = circle.getY();
        pos2X = circle2.getX();
        pos2Y = circle2.getY();
        pos3X = circle3.getX();
        pos3Y = circle3.getY();
        pos4X = circle4.getX();
        pos4Y = circle4.getY();
        p1.set(posX, posY);
        p2.set(pos2X, pos2Y);
        p3.set(pos3X, pos3Y);
        p4.set(pos4X, pos4Y);


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
