package pl.jacci.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import pl.jacci.TutorialClickerGame;

public abstract class AbstractScreen implements Screen {

    protected TutorialClickerGame game;
    protected Stage stage;
    private OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    public AbstractScreen (TutorialClickerGame game){                                                                //constructor
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT, camera));      //https://github.com/libgdx/libgdx/wiki/Viewports        (dopasowanie do ekranu)
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {                                                   //to będzie sie działo w każdej klatce
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override                                                                           //gdy gra się pojawia po raz pierwszy (inicjalizacje)
    public void show() {

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);                            //ekran czyszczony jest kolorem czarnym
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {                                                                 //jak się wejdzie na grę z tła (z innego okna na pulpicie)
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void hide() {}

    @Override                                                                               //wyrzucamy game gdy aplikaja się zamknie, zwalnianie pamięci
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

}
