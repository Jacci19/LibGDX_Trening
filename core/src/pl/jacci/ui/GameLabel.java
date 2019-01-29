package pl.jacci.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameLabel extends Label {

    public GameLabel(){
        super("", prepareLabelStyle());
        init();
    }

    private void init() {
        this.setX(60);
        this.setY(650);
    }

    private static LabelStyle prepareLabelStyle() {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        return labelStyle;
    }
}
