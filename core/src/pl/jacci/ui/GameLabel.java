package pl.jacci.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


public class GameLabel extends Label {


    public GameLabel(Color color){
        super("", prepareLabelStyle(color));
        init();
    }

    private void init() {
        this.setX(50);
        this.setY(650);
    }

    private static LabelStyle prepareLabelStyle(Color color) {

        /** Aby działały takie fonty trzeba w build.gradle dopisać odpowiednie linie */

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("android/assets/fonts/tahoma.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.color = color;
        BitmapFont myFont = generator.generateFont(parameter);


        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = myFont;

        return labelStyle;
    }
}
