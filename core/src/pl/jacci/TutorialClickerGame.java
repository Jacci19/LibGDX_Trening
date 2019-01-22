package pl.jacci;

import com.badlogic.gdx.Game;
import pl.jacci.screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused;
	private int points;

	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	public void addPoint(){
		points++;
	}



	//Gettery i settery

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
}
