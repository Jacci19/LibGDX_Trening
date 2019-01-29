package pl.jacci.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.jacci.controllers.FlyingObjectController;
import pl.jacci.entities.Player;
import pl.jacci.TutorialClickerGame;
import pl.jacci.service.PassiveIncomeService;
import pl.jacci.ui.*;


public class GameplayScreen extends AbstractScreen {

    private Image bgImage;
    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private ScoreLabel scorelabel;
    private FlyingObjectController flyingObjectController;
    private PassiveIncomeService passiveIncomeService;

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
        initFlyingObjectController();
        initPassiveIncomeService();
        startTheMusic();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    @Override
    public void pause() {
        super.pause();
        game.getScoreService().saveCurrentGameState();
    }

    private void initPassiveIncomeService() {
        passiveIncomeService = new PassiveIncomeService(game.getScoreService());
        passiveIncomeService.start();
    }

    private void startTheMusic() {
        game.getSoundService().startPlayingMusic(true);
    }

    private void initFlyingObjectController() {
        flyingObjectController = new FlyingObjectController(game, stage);
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
                game.getScoreService().addPoint();
                game.getSoundService().playJumpSound();
            }
        });
        stage.addActor(playerButton);
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().resetGameScore();
            }
        });
        stage.addActor(resetScoreButton);
    }

    private void initScorelabel() {
        scorelabel = new ScoreLabel();
        stage.addActor(scorelabel);
    }

    private void update() {
        scorelabel.setText("Score: " + game.getScoreService().getPoints());
        stage.act();
    }
}
