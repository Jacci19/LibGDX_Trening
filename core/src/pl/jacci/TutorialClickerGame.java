package pl.jacci;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import pl.jacci.screens.SplashScreen;
import pl.jacci.service.SoundService;

public class TutorialClickerGame extends Game {

	public final static String GAME_PREFS = "pl.jacci.tutorialClicker.prefs";			//Scieżka do zapisu nazwy, konwencja nazwy: package + nazwa projektu + prefs
	public final static String GAME_SCORE = "pl.jacci.tutorialClicker.prefs.score";		//'plik' w ścieżce do zapisu określonej wartości
	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private SoundService soundService;


	private boolean paused;
	private int points;
	private Preferences prefs;			//umożliwa zapisanie danych które nie giną po zamknięciu programu (tu wykorzystamy to do zapisywania punktów)

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init(){
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		initSoundService();
	}

	private void initSoundService() {
		soundService = new SoundService();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);			//odczyt stanu punktów z prefa
	}

	public void addPoint(){
		points++;
		updateScoreInPref();
	}

	public void addPoints(int pointsToAdd){
		points += pointsToAdd;
		updateScoreInPref();
	}


	public void resetGameScore() {
		points = 0;
		updateScoreInPref();
	}

	private void updateScoreInPref() {
		prefs.putInteger(GAME_SCORE, points);			//zapis stanu punktów do prefa
		prefs.flush();									//aktualizacja danych prefa na lokalny dysk twardy (aby nie zginęły po zamknięciu programu)
	}

	public void addPassiveIncome() {
		//TODO add passive
		System.out.println("passive income click");
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

	public SoundService getSoundService() {
		return soundService;
	}


}
