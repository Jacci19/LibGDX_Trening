package pl.jacci.screens;

/** splashscreen to obrazek który pojawia się przed właściwą aplikacją
 * https://github.com/JavaDevMatt/tutorialclicker/blob/tut3/core/src/pl/javadevmatt/tutorialclicker/screens/SplashScreen.java
 * */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import pl.jacci.TutorialClickerGame;


public class SplashScreen extends AbstractScreen{

    private Texture splashImg;

    public SplashScreen(final TutorialClickerGame game) {
        super(game);

        Timer.schedule(new Task() {
            @Override
            public void run() {                                 //to wykona się po czasie 1s
                game.setScreen(new GameplayScreen(game));
            }
        }, 1);
    }

    @Override
    protected void init(){
        //TODO implement better assets loading when game grows
        splashImg = new Texture("android/assets/splash.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0, 0);
        spriteBatch.end();
    }
}


































