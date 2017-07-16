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
    private Sprite circle7;
    private Sprite circle8;
    private Sprite circle9;
    private Sprite circle10;
    private Rectangle circleRectangle;
    private Rectangle circle2Rectangle;
    private Rectangle circle3Rectangle;
    private Rectangle circle4Rectangle;
    private Rectangle circle5Rectangle;
    private Rectangle circle6Rectangle;
    private Rectangle circle7Rectangle;
    private Rectangle circle8Rectangle;
    private Rectangle circle9Rectangle;
    private Rectangle circle10Rectangle;
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
    float pos7X;
    float pos7Y;
    float pos8X;
    float pos8Y;
    float pos9X;
    float pos9Y;
    float pos10X;
    float pos10Y;
    Vector3 touchPos;

    boolean active1;
    boolean active2;
    boolean active3;
    boolean active4;
    boolean active5;
    boolean active6;
    boolean active7;
    boolean active8;
    boolean active9;
    boolean active10;

    Vector2 p1;
    Vector2 p2;
    Vector2 p3;
    Vector2 p4;
    Vector2 p5;
    Vector2 p6;
    Vector2 p7;
    Vector2 p8;
    Vector2 p9;
    Vector2 p10;

    ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        circleTexture = new Texture(Gdx.files.internal("circle25.png"));
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
        circle7 = new Sprite(circleTexture);
        circle7.setPosition(Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight() - 50 - circle.getHeight()/2);
        circle8 = new Sprite(circleTexture);
        circle8.setPosition(Gdx.graphics.getWidth()/2 + 50, Gdx.graphics.getHeight() - 50 - circle.getHeight()/2);
        circle9 = new Sprite(circleTexture);
        circle9.setPosition(Gdx.graphics.getWidth()/2 - 50, 50 - circle.getHeight()/2);
        circle10 = new Sprite(circleTexture);
        circle10.setPosition(Gdx.graphics.getWidth()/2 + 50, 50 - circle.getHeight()/2);

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

        pos7X = circle7.getX();
        pos7Y = circle7.getY();

        pos8X = circle8.getX();
        pos8Y = circle8.getY();

        pos9X = circle9.getX();
        pos9Y = circle9.getY();

        pos10X = circle10.getX();
        pos10Y = circle10.getY();

        p1 = new Vector2(posX, posY);
        p2 = new Vector2(pos2X, pos2Y);
        p3 = new Vector2(pos3X, pos3Y);
        p4 = new Vector2(pos4X, pos4Y);
        p5 = new Vector2(pos5X, pos5Y);
        p6 = new Vector2(pos6X, pos6Y);
        p7 = new Vector2(pos7X, pos7Y);
        p8 = new Vector2(pos8X, pos8Y);
        p9 = new Vector2(pos9X, pos9Y);
        p10 = new Vector2(pos10X, pos10Y);

        active1 = false;
        active2 = false;
        active3 = false;
        active4 = false;
        active5 = false;
        active6 = false;
        active7 = false;
        active8 = false;
        active9 = false;
        active10 = false;
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        circleRectangle = new Rectangle(posX - 75, posY - 75, 150, 150);
        circle2Rectangle = new Rectangle(pos2X - 75, pos2Y - 75, 150, 150);
        circle3Rectangle = new Rectangle(pos3X - 75, pos3Y - 75, 150, 150);
        circle4Rectangle = new Rectangle(pos4X - 75, pos4Y - 75, 150, 150);
        circle5Rectangle = new Rectangle(pos5X - 75, pos5Y - 75, 150, 150);
        circle6Rectangle = new Rectangle(pos6X - 75, pos6Y - 75, 150, 150);
        circle7Rectangle = new Rectangle(pos7X - 75, pos7Y - 75, 150, 150);
        circle8Rectangle = new Rectangle(pos8X - 75, pos8Y - 75, 150, 150);
        circle9Rectangle = new Rectangle(pos9X - 75, pos9Y - 75, 150, 150);
        circle10Rectangle = new Rectangle(pos10X - 75, pos10Y - 75, 150, 150);
        buttonNext = new Rectangle(400, 50, 200, 50);

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

        if(circleRectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active6 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active1 = true;
            } else { active1 = false; }
        }
        if(circle2Rectangle.contains(touchPos.x, touchPos.y) &&
                !active1 && !active3 && !active4 &&!active4 && !active5 && !active6 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle2.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active2 = true;
            }  else { active2 = false; }
        }
        if(circle3Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active1 && !active4 && !active4 && !active5 && !active6 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle3.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active3 = true;
            } else { active3 = false; }
        }
        if(circle4Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active1 && !active4 && !active5 && !active6 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle4.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active4 = true;
            } else { active4 = false; }
        }
        if(circle5Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active1 && !active6 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle5.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active5 = true;
            } else { active5 = false; }
        }
        if(circle6Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active1 && !active7 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle6.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active6 = true;
            }  else { active6 = false; }
        }
        if(circle7Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active6 && !active1 && !active8 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle7.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active7 = true;
            } else { active7 = false; }
        }
        if(circle8Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active6 && !active7 && !active1 && !active9 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle8.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active8 = true;
            } else { active8 = false; }
        }
        if(circle9Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active6 && !active7 && !active8 && !active1 && !active10) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle9.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active9 = true;
            } else { active9 = false; }
        }
        if(circle10Rectangle.contains(touchPos.x, touchPos.y) &&
                !active2 && !active3 && !active4 && !active4 && !active5 && !active6 && !active7 && !active8 && !active9 && !active1) {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                circle10.setPosition(Gdx.input.getX() - 12, Gdx.graphics.getHeight() - Gdx.input.getY() - 12);
                active10 = true;
            } else { active10 = false; }
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
        pos7X = circle7.getX();
        pos7Y = circle7.getY();
        pos8X = circle8.getX();
        pos8Y = circle8.getY();
        pos9X = circle9.getX();
        pos9Y = circle9.getY();
        pos10X = circle10.getX();
        pos10Y = circle10.getY();
        p1.set(posX, posY);
        p2.set(pos2X, pos2Y);
        p3.set(pos3X, pos3Y);
        p4.set(pos4X, pos4Y);
        p5.set(pos5X, pos5Y);
        p6.set(pos6X, pos6Y);
        p7.set(pos7X, pos7Y);
        p8.set(pos8X, pos8Y);
        p9.set(pos9X, pos9Y);
        p10.set(pos10X, pos10Y);

        if(Intersector.intersectSegments(p1, p5, p10, p6, null) ||
                Intersector.intersectSegments(p1, p5, p3, p6, null) ||
                Intersector.intersectSegments(p1, p5, p3, p7, null) ||
                Intersector.intersectSegments(p1, p5, p2, p7, null) ||
                Intersector.intersectSegments(p1, p5, p7, p8, null) ||
                Intersector.intersectSegments(p1, p5, p7, p10, null) ||
                Intersector.intersectSegments(p1, p5, p9, p10, null) ||
                Intersector.intersectSegments(p1, p5, p8, p9, null) ||
                Intersector.intersectSegments(p1, p5, p4, p8, null) ||
                Intersector.intersectSegments(p1, p5, p4, p9, null) ||

                Intersector.intersectSegments(p1, p9, p5, p10, null) ||
                Intersector.intersectSegments(p1, p9, p5, p6, null) ||
                Intersector.intersectSegments(p1, p9, p10, p6, null) ||
                Intersector.intersectSegments(p1, p9, p3, p6, null) ||
                Intersector.intersectSegments(p1, p9, p3, p7, null) ||
                Intersector.intersectSegments(p1, p9, p2, p7, null) ||
                Intersector.intersectSegments(p1, p9, p7, p8, null) ||
                Intersector.intersectSegments(p1, p9, p7, p10, null) ||
                Intersector.intersectSegments(p1, p9, p9, p10, null) ||
                Intersector.intersectSegments(p1, p9, p4, p8, null) ||

                Intersector.intersectSegments(p5, p10, p5, p6, null) ||
                Intersector.intersectSegments(p5, p10, p3, p6, null) ||
                Intersector.intersectSegments(p5, p10, p3, p7, null) ||
                Intersector.intersectSegments(p5, p10, p2, p7, null) ||
                Intersector.intersectSegments(p5, p10, p7, p8, null) ||
                Intersector.intersectSegments(p5, p10, p8, p9, null) ||
                Intersector.intersectSegments(p5, p10, p4, p8, null) ||
                Intersector.intersectSegments(p5, p10, p4, p9, null) ||

                Intersector.intersectSegments(p5, p6, p3, p7, null) ||
                Intersector.intersectSegments(p5, p6, p2, p7, null) ||
                Intersector.intersectSegments(p5, p6, p7, p8, null) ||
                Intersector.intersectSegments(p5, p6, p7, p10, null) ||
                Intersector.intersectSegments(p5, p6, p9, p10, null) ||
                Intersector.intersectSegments(p5, p6, p8, p9, null) ||
                Intersector.intersectSegments(p5, p6, p4, p8, null) ||
                Intersector.intersectSegments(p5, p6, p4, p9, null) ||

                Intersector.intersectSegments(p10, p6, p3, p7, null) ||
                Intersector.intersectSegments(p10, p6, p2, p7, null) ||
                Intersector.intersectSegments(p10, p6, p7, p8, null) ||
                Intersector.intersectSegments(p10, p6, p8, p9, null) ||
                Intersector.intersectSegments(p10, p6, p4, p8, null) ||
                Intersector.intersectSegments(p10, p6, p4, p9, null) ||

                Intersector.intersectSegments(p3, p6, p3, p7, null) ||
                Intersector.intersectSegments(p3, p6, p2, p7, null) ||
                Intersector.intersectSegments(p3, p6, p7, p8, null) ||
                Intersector.intersectSegments(p3, p6, p7, p10, null) ||
                Intersector.intersectSegments(p3, p6, p8, p10, null) ||
                Intersector.intersectSegments(p3, p6, p7, p9, null) ||
                Intersector.intersectSegments(p3, p6, p4, p9, null) ||
                Intersector.intersectSegments(p3, p6, p4, p8, null) ||

                Intersector.intersectSegments(p3, p7, p9, p10, null) ||
                Intersector.intersectSegments(p3, p7, p8, p9, null) ||
                Intersector.intersectSegments(p3, p7, p4, p8, null) ||
                Intersector.intersectSegments(p3, p7, p4, p9, null) ||

                Intersector.intersectSegments(p2, p7, p9, p10, null) ||
                Intersector.intersectSegments(p2, p7, p8, p9, null) ||
                Intersector.intersectSegments(p2, p7, p4, p8, null) ||
                Intersector.intersectSegments(p2, p7, p4, p9, null) ||

                Intersector.intersectSegments(p7, p8, p9, p10, null) ||
                Intersector.intersectSegments(p7, p8, p4, p9, null) ||

                Intersector.intersectSegments(p2, p8, p1, p5, null) ||
                Intersector.intersectSegments(p2, p8, p1, p9, null) ||
                Intersector.intersectSegments(p2, p8, p5, p10, null) ||
                Intersector.intersectSegments(p2, p8, p10, p6, null) ||
                Intersector.intersectSegments(p2, p8, p3, p6, null) ||
                Intersector.intersectSegments(p2, p8, p3, p7, null) ||
                Intersector.intersectSegments(p2, p8, p2, p7, null) ||
                Intersector.intersectSegments(p2, p8, p7, p10, null) ||
                Intersector.intersectSegments(p2, p8, p9, p10, null) ||
                Intersector.intersectSegments(p2, p8, p4, p9, null) ||

                Intersector.intersectSegments(p9, p10, p4, p8, null)) {
            Gdx.gl.glClearColor(1, 1, 1, 1);
        }
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
        game.batch.draw(circle7, circle7.getX(), circle7.getY());
        game.batch.draw(circle8, circle8.getX(), circle8.getY());
        game.batch.draw(circle9, circle9.getX(), circle9.getY());
        game.batch.draw(circle10, circle10.getX(), circle10.getY());


        game.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.line(posX + 12, posY + 12, pos5X + 12, pos5Y + 12);
        shapeRenderer.line(posX + 12, posY + 12, pos9X + 12, pos9Y + 12);
        shapeRenderer.line(pos5X + 12, pos5Y + 12, pos10X + 12, pos10Y + 12);
        shapeRenderer.line(pos5X + 12, pos5Y + 12, pos6X + 12, pos6Y + 12);
        shapeRenderer.line(pos10X + 12, pos10Y + 12, pos6X + 12, pos6Y + 12);
        shapeRenderer.line(pos3X + 12, pos3Y + 12, pos6X + 12, pos6Y + 12);
        shapeRenderer.line(pos3X + 12, pos3Y + 12, pos7X + 12, pos7Y + 12);
        shapeRenderer.line(pos2X + 12, pos2Y + 12, pos7X + 12, pos7Y + 12);
        shapeRenderer.line(pos7X + 12, pos7Y + 12, pos8X + 12, pos8Y + 12);
        shapeRenderer.line(pos7X + 12, pos7Y + 12, pos10X + 12, pos10Y + 12);
        shapeRenderer.line(pos9X + 12, pos9Y + 12, pos10X + 12, pos10Y + 12);
        shapeRenderer.line(pos8X + 12, pos8Y + 12, pos9X + 12, pos9Y + 12);
        shapeRenderer.line(pos4X + 12, pos4Y + 12, pos8X + 12, pos8Y + 12);
        shapeRenderer.line(pos4X + 12, pos4Y + 12, pos9X + 12, pos9Y + 12);
        shapeRenderer.line(pos2X + 12, pos2Y + 12, pos8X + 12, pos8Y + 12);
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
