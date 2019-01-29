package pl.jacci.screens;

/** splashscreen to obrazek który pojawia się przed właściwą aplikacją
 * https://github.com/JavaDevMatt/tutorialclicker/blob/tut3/core/src/pl/javadevmatt/tutorialclicker/screens/SplashScreen.java
 * */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import pl.jacci.TutorialClickerGame;
import pl.jacci.ui.IRequestCallback;


public class SplashScreen extends AbstractScreen{

    private Texture splashImg, noInternetImg;
    private boolean showError = false;

    public SplashScreen(final TutorialClickerGame game) {
        super(game);

//        Timer.schedule(new Task() {
//            @Override
//            public void run() {                                 //to wykona się po czasie 1s
//                game.setScreen(new GameplayScreen(game));
//            }
//        }, 1);
    }

    @Override
    protected void init(){
        //TODO implement better assets loading when game grows
        splashImg = new Texture("android/assets/splash.png");
        noInternetImg = new Texture("android/assets/nointernet.png");


        game.getFeatureFlagService().makeFeatureFlagsRequest(new IRequestCallback() {
            @Override
            public void onSucceed() {
                showError = false;

                game.getBalanceService().makeBalanceServiceRequest(new IRequestCallback() {

                    @Override
                    public void onSucceed() {
                        Gdx.app.postRunnable(new Runnable() {                                       //jest, aby uniknąć błędu: No OpenGL context found in the current thread.
                            @Override                                                               //https://youtu.be/ntVzGRIOvl4?list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P&t=1525
                            public void run() {
                                game.setScreen(new GameplayScreen(game));
                            }
                        });
                    }

                    @Override
                    public void onError() {
                        showError = true;
                    }
                });
            }

            @Override
            public void onError() {
                // TODO make some error message
                showError = true;
                System.out.println("!!!  Błąd połączenia z internetem   !!!");
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        if(showError){
            spriteBatch.draw(noInternetImg, 0, 0);                  //jak nie ma internetu to wyświetli się odwrócona sowa i gra nie rozpocznie się
        } else {
            spriteBatch.draw(splashImg, 0, 0);
        }
        spriteBatch.end();
    }
}


































