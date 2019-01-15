package pl.screens;

import com.badlogic.gdx.graphics.Texture;
import pl.jacci.TutorialClickerGame;


public class SplashScreen extends AbstractScreen{

    private Texture splashImg;

    public SplashScreen(TutorialClickerGame game) {
        super(game);
        init();
    }

    private void init(){
        //TODO implement better assets loading when game grows
        splashImg = new Texture("android/assets/badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0, 0);
        spriteBatch.end();
    }
}
