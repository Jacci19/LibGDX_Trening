package pl.jacci.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ResetScoreButton extends Button {

    public ResetScoreButton(final IClickCallback callback){
        super (prepareResetButtonStyle());
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(60);
        this.setHeight(20);
        this.setX(410);
        this.setY(650);
        //this.setDebug(true);                          //niebieski prostokąt

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static ButtonStyle prepareResetButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("android/assets/ui-red.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_02");
        buttonStyle.down = skin.getDrawable("button_03");

        return buttonStyle;
    }

}
