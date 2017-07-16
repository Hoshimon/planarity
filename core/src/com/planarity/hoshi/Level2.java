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

public class Level2 implements Screen {

    Planarity game;

    public Level2(Planarity game) {
        this.game = game;
    }


    Texture img;
    Texture nextlvl;
    private Texture circleTexture;
    private Texture lineTexture;
    private Sprite circle;
    private Sprite circle2;
    private Sprite circle3;
    private Sprite circle4;
    private Sprite circle5;
    private Sprite circle6;
    private Rectangle circleRectangle;
    private Rectangle circle2Rectangle;
    private Rectangle circle3Rectangle;
    private Rectangle circle4Rectangle;
    private Rectangle circle5Rectangle;
    private Rectangle circle6Rectangle;
    private Rectangle buttonNext;

    float posX;
    float posY;
    float pos2X;
    float pos2Y;
    float pos3X;
    float pos3Y;
    float pos4X;
    float pos4Y;
    float pos5X;
    float pos5Y;
    float pos6X;
    float pos6Y;
    Vector3 touchPos;

    Vector2 p1;
    Vector2 p2;
    Vector2 p3;
    Vector2 p4;
    Vector2 p5;
    Vector2 p6;

    ShapeRenderer shapeRenderer;

    @Override
    public void show() {

        img = new Texture("badlogic.jpg");
        circleTexture = new Texture(Gdx.files.internal("circle_25p.png"));
        lineTexture = new Texture(Gdx.files.internal("line.png"));
        nextlvl = new Texture(Gdx.files.internal("nextlvl.png"));

        shapeRenderer = new ShapeRenderer();

        circle = new Sprite(circleTexture);
        circle.setPosition(Gdx.graphics.getWidth()/4 - circle.getWidth()/2, Gdx.graphics.getHeight()/4*3 - circle.getHeight()/2);
        circle2 = new Sprite(circleTexture);
        circle2.setPosition(Gdx.graphics.getWidth()/4*3 - circle.getWidth()/2, Gdx.graphics.getHeight()/4*3 - circle.getHeight()/2);
        circle3 = new Sprite(circleTexture);
        circle3.setPosition(150 - circle.getWidth()/4 - circle.getWidth()/2, Gdx.graphics.getHeight()/4 - circle.getHeight()/2);
        circle4 = new Sprite(circleTexture);
        circle4.setPosition(Gdx.graphics.getWidth()/4*3 - circle.getWidth()/2, Gdx.graphics.getHeight()/4 - circle.getHeight()/2);
        circle5 = new Sprite(circleTexture);
        circle5.setPosition(Gdx.graphics.getWidth()/4 - circle.getWidth()/2 - 100, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);
        circle6 = new Sprite(circleTexture);
        circle6.setPosition(Gdx.graphics.getWidth()/4*3 - circle.getWidth()/2 + 100, Gdx.graphics.getHeight()/2 - circle.getHeight()/2);

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

        posX = circle.getX();
        posY = circle.getY();

        pos2X = circle2.getX();
        pos2Y = circle2.getY();

        pos3X = circle3.getX();
        pos3Y = circle3.getY();

        pos4X = circle4.getX();
        pos4Y = circle4.getY();

        pos5X = circle5.getX();
        pos5Y = circle5.getY();

        pos6X = circle6.getX();
        pos6Y = circle6.getY();

        p1 = new Vector2(posX, posY);
        p2 = new Vector2(pos2X, pos2Y);
        p3 = new Vector2(pos3X, pos3Y);
        p4 = new Vector2(pos4X, pos4Y);
        p5 = new Vector2(pos5X, pos5Y);
        p6 = new Vector2(pos6X, pos6Y);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        circleRectangle = new Rectangle(posX, posY, 50, 50);
        circle2Rectangle = new Rectangle(pos2X, pos2Y, 50,50);
        circle3Rectangle = new Rectangle(pos3X, pos3Y, 50,50);
        circle4Rectangle = new Rectangle(pos4X, pos4Y, 50,50);
        circle5Rectangle = new Rectangle(pos5X, pos5Y, 50,50);
        circle6Rectangle = new Rectangle(pos6X, pos6Y, 50,50);
        buttonNext = new Rectangle(400, 50, 200, 50);

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

        if(circleRectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }
        if(circle2Rectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle2.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }
        if(circle3Rectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle3.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }
        if(circle4Rectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle4.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }
        if(circle5Rectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle5.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }
        if(circle6Rectangle.contains(touchPos.x, touchPos.y)) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle6.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
            }
        }

        posX = circle.getX();
        posY = circle.getY();
        pos2X = circle2.getX();
        pos2Y = circle2.getY();
        pos3X = circle3.getX();
        pos3Y = circle3.getY();
        pos4X = circle4.getX();
        pos4Y = circle4.getY();
        pos5X = circle5.getX();
        pos5Y = circle5.getY();
        pos6X = circle6.getX();
        pos6Y = circle6.getY();
        p1.set(posX, posY);
        p2.set(pos2X, pos2Y);
        p3.set(pos3X, pos3Y);
        p4.set(pos4X, pos4Y);
        p5.set(pos5X, pos5Y);
        p6.set(pos6X, pos6Y);

        if(Intersector.intersectSegments(p1, p3, p2, p5, null) ||
                Intersector.intersectSegments(p1, p3, p4, p5, null) ||

                Intersector.intersectSegments(p1, p2, p3, p4, null) ||
                Intersector.intersectSegments(p1, p2, p3, p6, null) ||
                Intersector.intersectSegments(p1, p2, p4, p5, null) ||

                Intersector.intersectSegments(p3, p4, p1, p2, null) ||
                Intersector.intersectSegments(p3, p4, p1, p5, null) ||
                Intersector.intersectSegments(p3, p4, p1, p6, null) ||
                Intersector.intersectSegments(p3, p4, p2, p5, null) ||

                Intersector.intersectSegments(p3, p6, p1, p2, null) ||
                Intersector.intersectSegments(p3, p6, p1, p5, null) ||
                Intersector.intersectSegments(p3, p6, p2, p5, null) ||
                Intersector.intersectSegments(p3, p6, p4, p5, null) ||

                Intersector.intersectSegments(p1, p6, p2, p5, null) ||
                Intersector.intersectSegments(p1, p6, p4, p5, null) ||

                Intersector.intersectSegments(p3, p5, p1, p6, null)) {
            Gdx.gl.glClearColor(1, 1, 1, 1);
        }
        // 1 - 3; 1 - 2; 3 - 4; 3 - 6; 1 - 5; 1 - 6; 2 - 5; 4 - 5;
        else {
            Gdx.gl.glClearColor(0, 1, 0, 1);
            game.batch.draw(nextlvl, 400, 0);
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                if(buttonNext.contains(touchPos.x, touchPos.y)) {

                }
            }
        }

        game.batch.draw(circle, circle.getX(), circle.getY());
        game.batch.draw(circle2, circle2.getX(), circle2.getY());
        game.batch.draw(circle3, circle3.getX(), circle3.getY());
        game.batch.draw(circle4, circle4.getX(), circle4.getY());
        game.batch.draw(circle5, circle5.getX(), circle5.getY());
        game.batch.draw(circle6, circle6.getX(), circle6.getY());

        game.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.line(posX + 12, posY + 12, pos3X + 12, pos3Y + 12);
        shapeRenderer.line(posX + 12, posY + 12, pos2X + 12, pos2Y + 12);
        shapeRenderer.line(pos3X + 12, pos3Y + 12, pos4X + 12, pos4Y + 12);
        shapeRenderer.line(pos3X + 12, pos3Y + 12, pos6X + 12, pos6Y + 12);
        shapeRenderer.line(posX + 12, posY + 12, pos5X + 12, pos5Y + 12);
        shapeRenderer.line(posX + 12, posY + 12, pos6X + 12, pos6Y + 12);
        shapeRenderer.line(pos2X + 12, pos2Y + 12, pos5X + 12, pos5Y + 12);
        shapeRenderer.line(pos4X + 12, pos4Y + 12, pos5X + 12, pos5Y + 12);
        shapeRenderer.end();



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
