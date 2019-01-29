package pl.jacci.controllers;

/** co 5 sekund losujemy czy ma wystąpic event, jeśli tak to losujemy jeden z trzech eventów */

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import pl.jacci.TutorialClickerGame;

public class RandomEventController {

    private static final int RANDOM_TICK_INTERVAL = 5; // TODO: change after initial implementation to bigger number

    private TutorialClickerGame game;

    public RandomEventController(TutorialClickerGame game){
        this.game = game;
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

    private void gainPassiveIncome() {
        game.getScoreService().addPassiveIncome();
    }

    private void gainMoneyEvent(){
        game.getScoreService().addPoints(123);
    }

    private void loseMoneyEvent(){
        game.getScoreService().addPoints(-123);
    }

}
