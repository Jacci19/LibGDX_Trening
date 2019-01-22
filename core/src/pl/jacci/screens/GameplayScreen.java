package pl.jacci.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.jacci.entities.Player;
import pl.jacci.TutorialClickerGame;


public class GameplayScreen extends AbstractScreen {

    private Player player;
    private Button playerButton;
    private Button resetScoreButton;
    private Label scorelabel;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init(){
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScorelabel();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    private void initPlayerButton() {
        playerButton = new Button(new ButtonStyle());
        playerButton.setWidth(460);
        playerButton.setHeight(360);
        playerButton.setX(10);
        playerButton.setY(170);
        playerButton.setDebug(true);                    //jeśli btn jest niewidoczny, to żeby go było widać (niebieski prostokąt)

        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener(){

            @Override                                                         //touchDown - akcja po kliknięciu
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.reactOnClick();
                game.addPoint();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initResetScoreButton() {
        resetScoreButton = new Button(new ButtonStyle());
        resetScoreButton.setWidth(100);
        resetScoreButton.setHeight(100);
        resetScoreButton.setX(330);
        resetScoreButton.setY(560);
        resetScoreButton.setDebug(true);

        stage.addActor(resetScoreButton);

        resetScoreButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.resetGameScore();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }


    private void initScorelabel() {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        scorelabel = new Label("0", labelStyle);
        scorelabel.setX(20);
        scorelabel.setY(650);
        stage.addActor(scorelabel);
    }



    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        scorelabel.setText("Score: " + game.getPoints());
        stage.act();
    }
}
