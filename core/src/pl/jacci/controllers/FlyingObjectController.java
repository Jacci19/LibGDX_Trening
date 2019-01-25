package pl.jacci.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import pl.jacci.TutorialClickerGame;
import pl.jacci.entities.FlyingObject;

public class FlyingObjectController {
    private int spawnTime;

    public FlyingObjectController(TutorialClickerGame game, Stage stage){
        init(game, stage);
    }

    private void init(final TutorialClickerGame game, final Stage stage) {
        randomizeSpawnTime();

        Timer.schedule(new Timer.Task() {

            @Override
            public void run() {                             //będzie to powtarzane co czas spawnTime

                FlyingObject flyingObject = null;

                if(MathUtils.randomBoolean()){
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.MONEY, game);
                } else{
                    flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
                }

                stage.addActor(flyingObject);
                flyingObject.fly();

                randomizeSpawnTime();
            }
        }, spawnTime, spawnTime);       //jak jest jeden spawnTime to run wykona się tylko raz po upływie tego czasu.
                                        //drugi spawnTime zapewnia nam, że run będzie się wykonywał w petli po każdym upływie tego czasu
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5, 10);        //przypadkowa liczba z zakresu (5, 10)
    }
}

































