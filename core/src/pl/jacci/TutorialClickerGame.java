package pl.jacci;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import pl.jacci.screens.SplashScreen;
import pl.jacci.service.FeatureFlagService;
import pl.jacci.service.ScoreService;
import pl.jacci.service.ShopService;
import pl.jacci.service.SoundService;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private SoundService soundService;
	private ScoreService scoreService;
	private FeatureFlagService featureFlagService;							//serwis w necie z którego będziemy pobierać potrzebne w grze dane
	private ShopService shopService;
	private boolean paused;

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init(){
		initSoundService();
		initScoreService();
		initFeatureFlagService();
		initShopService();
	}

	private void initShopService() {
		ShopService shopService = new ShopService();
	}

	private void initFeatureFlagService() {
		featureFlagService = new FeatureFlagService();
	}

	private void initScoreService() {
		scoreService = new ScoreService();
	}

	private void initSoundService() {
		soundService = new SoundService();
	}


	//Gettery i settery

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public SoundService getSoundService() {
		return soundService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public FeatureFlagService getFeatureFlagService() {
		return featureFlagService;
	}

	public ShopService getShopService() {
		return shopService;
	}
}
