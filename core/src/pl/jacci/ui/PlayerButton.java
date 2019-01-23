package pl.jacci.ui;

/** Ta klasa ma na celu przeniesienie deklaracji parametrów buttona z klasy GamePlayScreen, tak żeby była ona bardziej czytelna*/

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayerButton extends Button {

    public PlayerButton(final IClickCallback callback){
        super (new ButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(460);
        this.setHeight(360);
        this.setX(10);
        this.setY(170);
        this.setDebug(true);                    //jeśli btn jest niewidoczny, to żeby go było widać (niebieski prostokąt)

        this.addListener(new ClickListener(){
            @Override                                                         //touchDown - akcja po kliknięciu
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

}
