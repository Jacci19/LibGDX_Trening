package pl.jacci.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {                                     //image z kolei dziedziczy po actor
    private final static int WIDTH = 77;
    private final static int HEIGHT = 152;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 300;

    public Player(){
        super(new Texture("android/assets/badlogic.jpg"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);                  //Origin - punkt odniesienia (tu: środek)
        this.setSize(WIDTH, HEIGHT);

        // starting position
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public void reactOnClick() {
        //Action testAction = Actions.moveBy(10,10);                            //proste przykładowe akcje
        //Action testAction = Actions.sizeBy(50,1);
        //this.addAction(testAction);

        int xMoveAmmount = MathUtils.random(-130, 130);         //losowa liczba z podanego zakresu
        int yMoveAmmount = 10;
        float moveActionTime = 0.30f;                           //0.3 sekundy
        Action moveAction = Actions.sequence(                                                                       //sekwencja akcji
                Actions.moveBy(xMoveAmmount, yMoveAmmount, moveActionTime, Interpolation.circleOut),
                Actions.moveBy(-xMoveAmmount, -yMoveAmmount, moveActionTime, Interpolation.circle)
        );

        int xGrowAmmount = MathUtils.random(-30, 100);
        int yGrowAmmount = 20;
        float growActionTime = 0.2f;
        Action growAction =  Actions.sequence(
                Actions.sizeBy(xGrowAmmount, yGrowAmmount, growActionTime, Interpolation.circleOut),
                Actions.sizeBy(-xGrowAmmount, -yGrowAmmount, growActionTime, Interpolation.circle)
        );

        this.addAction(moveAction);
        this.addAction(growAction);

        if(this.getHeight() > 170){
            this.addAction(Actions.rotateBy(MathUtils.randomSign() * 360, 0.4f));
        }
    }
}
