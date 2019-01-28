package pl.jacci.service;

import com.badlogic.gdx.utils.Timer;

public class PassiveIncomeService {

    private ScoreService scoreService;
    private final static int INFINITE = 100000000;

    public PassiveIncomeService(ScoreService scoreService){
        this.scoreService = scoreService;
    }

    public void start(){
        Timer.schedule(new Timer.Task() {

            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPassiveIncome());            //dodawaj punkty co sekundę
            }
        }, 1, 1, INFINITE);
    }
}
