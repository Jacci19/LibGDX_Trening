package pl.jacci.controllers;

/** co 5 sekund losujemy czy ma wystąpic event, jeśli tak to losujemy jeden z trzech eventów */

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import pl.jacci.TutorialClickerGame;
import pl.jacci.ui.BasicDialog;

public class RandomEventController {

    private static final int RANDOM_TICK_INTERVAL = 5; // TODO: change after initial implementation to bigger number

    private TutorialClickerGame game;
    private Stage stage;

    public RandomEventController(TutorialClickerGame game, Stage stage){
        this.game = game;
        this.stage = stage;
        init();
    }
    private void init(){

        Timer.schedule(new Task() {

            @Override
            public void run() {
                if(MathUtils.randomBoolean()){
                    triggerRandomEvent();
                }
            }
        }, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
    }

    private void triggerRandomEvent() {
        int randomNumber = MathUtils.random(1, 3);
        switch (randomNumber) {
            case 1:
                gainMoneyEvent();
                break;
            case 2:
                loseMoneyEvent();
                break;
            case 3:
                gainPassiveIncome();
                break;
            default:
                break;
        }
    }

    private void triggerDialog(String text){
        BasicDialog basicDialog = new BasicDialog();
        basicDialog.showDialog(stage, text);
    }

    private void gainPassiveIncome() {
        game.getScoreService().addPassiveIncome();
        triggerDialog("Yeaah! You gained passive income.");
    }

    private void gainMoneyEvent(){
        game.getScoreService().addPoints(123);
        triggerDialog("Yeaah! You gained passive income.");
    }

    private void loseMoneyEvent(){
        game.getScoreService().addPoints(-123);
        triggerDialog("Pay taxes, owl!");
    }

}
