package pl.jacci.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.jacci.entities.Player;
import pl.jacci.TutorialClickerGame;


public class GameplayScreen extends AbstractScreen {

    private Player player;
    private Button playerButton;

    public GameplayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void init(){
        initPlayer();
        initPlayerButton();
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


    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        System.out.println("Points: " + game.getPoints());

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
