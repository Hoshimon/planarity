package com.planarity.hoshi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenu implements Screen {

    Planarity game;

    private Texture menuScreen;
    private Texture playButton;
    private Rectangle button;
    Vector3 touchPos;


    public MainMenu(Planarity game) {
      this.game = game;
    }

    @Override
    public void show() {

        menuScreen = new Texture(Gdx.files.internal("menu.png"));
        playButton = new Texture(Gdx.files.internal("playbutton.png"));
        button = new Rectangle(graphics.getWidth()/2 - 150, 200, 300, 100);

        touchPos = new Vector3(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 0);

    }

    @Override
    public void render(float delta) {

        touchPos = new Vector3(Gdx.input.getX(), graphics.getHeight() - Gdx.input.getY(), 0);

        game.batch.begin();
        game.batch.draw(menuScreen, 0, 0, 600, 600);
        game.batch.draw(playButton, graphics.getWidth()/2 - 150, 200);
        game.batch.end();

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if(button.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new Tutorial(game));
            }
        }

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
