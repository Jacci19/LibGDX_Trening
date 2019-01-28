package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {
    public final static String GAME_PREFS = "pl.jacci.tutorialClicker.prefs";			//Scieżka do zapisu nazwy, konwencja nazwy: package + nazwa projektu + prefs
    public final static String GAME_SCORE = "pl.jacci.tutorialClicker.prefs.score";		//'plik' w ścieżce do zapisu określonej wartości
    public final static String GAME_PASSIVE_INCOME = "pl.jacci.tutorialClicker.prefs.passiveincome";

    private Preferences prefs;                                  //umożliwa zapisanie danych które nie giną po zamknięciu programu (tu wykorzystamy to do zapisywania punktów)
    private int points;
    private int passiveIncome;

    public ScoreService(){
        init();
    }

    private void init() {
        prefs =  Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);			//odczyt stanu punktów z prefa
    }

    private void loadPassiveIncome() {
        passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOME);
    }

    public void addPoints(int pointsToAdd){
        points += pointsToAdd;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    public void addPoint(){
        points++;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
        updateSavedScoreAndPassiveIncomeInPrefs();
    }

    private void updateSavedScoreAndPassiveIncomeInPrefs() {
        prefs.putInteger(GAME_SCORE, points);			                //zapis stanu punktów do prefa
        prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);			//zapis stanu pasywnego dochodu do prefa
        prefs.flush();									                //aktualizacja danych prefa na lokalny dysk twardy (aby nie zginęły po zamknięciu programu)
    }

    public void addPassiveIncome() {
        passiveIncome++;
        updateSavedScoreAndPassiveIncomeInPrefs();
        System.out.println("passive income click");
    }

    public int getPoints() {
        return points;
    }
}
