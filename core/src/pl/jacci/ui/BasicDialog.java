package pl.jacci.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BasicDialog extends Image {

    private GameLabel label;

    private final static int WIDHT = 340;
    private final static int HEIGHT = 100;

    public BasicDialog(){
        super(new Texture("android/assets/dialog.png"));

        this.setOrigin(WIDHT / 2, HEIGHT / 2);
        this.setSize(WIDHT, HEIGHT);
        this.setPosition(80, 180);

        label = new GameLabel(Color.BROWN);
        label.setPosition(100, 230);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fadeOutDialog();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

//    public void initContent(String text){
//        label.setText(text);
//        this.getStage().addActor(label);
//    }

    public  void showDialog(Stage stage, String text){
        stage.addActor(this);
        label.setText(text);
        this.getStage().addActor(label);
    }

    private void fadeOutDialog() {
        SequenceAction sequence = Actions.sequence();
        sequence.addAction(Actions.fadeOut(0.5f));
        sequence.addAction(new Action() {

            @Override
            public boolean act(float delta) {
                BasicDialog.this.remove();
                label.remove();
                return false;
            }
        });
        this.addAction(sequence);
        label.addAction(Actions.fadeOut(0.5f));

    }
}























