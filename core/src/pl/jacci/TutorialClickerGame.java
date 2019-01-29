package pl.jacci;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import pl.jacci.screens.SplashScreen;
import pl.jacci.service.*;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private SoundService soundService;
	private ScoreService scoreService;
	private FeatureFlagService featureFlagService;							//serwis w necie z którego będziemy pobierać potrzebne w grze dane
	private BalanceService balanceService;							    //serwis w necie z którego będziemy pobierać dane do balansu gry
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
		initBalanceService();
		initShopService();
	}

    private void initBalanceService() {
	    balanceService = new BalanceService();
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

    public BalanceService getBalanceService() {
        return balanceService;
    }

    public ShopService getShopService() {
		return shopService;
	}
}
