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
            public void run() {                                     //https://youtu.be/hAn4k0kut8U?list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P&t=1482
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {                             //będzie to powtarzane co czas spawnTime
                        addRandomFlyingObjectToSage(game, stage);
                        randomizeSpawnTime();
                    }
                }, spawnTime);
            }
        }, 1,5);                                      //jak jest jeden spawnTime to run wykona się tylko raz po upływie tego czasu.
                                                                                //drugi spawnTime zapewnia nam, że run będzie się wykonywał w petli po każdym upływie tego czasu
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(5, 10);        //przypadkowa liczba z zakresu (5, 10)
    }

    private void addRandomFlyingObjectToSage(TutorialClickerGame game, Stage stage){
        FlyingObject flyingObject = null;

        if(MathUtils.randomBoolean()){
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.MONEY, game);
        } else{
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
        }

        stage.addActor(flyingObject);
        flyingObject.fly();

    }
}

































