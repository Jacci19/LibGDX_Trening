package pl.jacci.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.jacci.entities.Player;
import pl.jacci.TutorialClickerGame;
import pl.jacci.ui.*;


public class GameplayScreen extends AbstractScreen {

    private Image bgImage;
    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private ScoreLabel scorelabel;
    private FlyingObject flyingObject1;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init(){
        initBg();
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScorelabel();
        initFlyingObjects();
    }

    private void initFlyingObjects() {
        flyingObject1 = new FlyingObject(FlyingObject.MONEY);
        stage.addActor(flyingObject1);
        flyingObject1.fly();
    }

    private void initBg() {
        bgImage = new Image(new Texture("android/assets/bg.png"));
        stage.addActor(bgImage);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
            }
        });
        stage.addActor(playerButton);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }

    private void initScorelabel() {
        scorelabel = new ScoreLabel();
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
