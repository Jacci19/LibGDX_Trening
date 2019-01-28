package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {
    public final static String GAME_PREFS = "pl.jacci.tutorialClicker.prefs";			//Scieżka do zapisu nazwy, konwencja nazwy: package + nazwa projektu + prefs
    public final static String GAME_SCORE = "pl.jacci.tutorialClicker.prefs.score";		//'plik' w ścieżce do zapisu określonej wartości

    private Preferences prefs;                                  //umożliwa zapisanie danych które nie giną po zamknięciu programu (tu wykorzystamy to do zapisywania punktów)
    private int points;

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

    public void addPoints(int pointsToAdd){
        points += pointsToAdd;
        updateSavedScoreInPrefs();
    }

    public void addPoint(){
        points++;
        updateSavedScoreInPrefs();
    }

    public void resetGameScore() {
        points = 0;
        updateSavedScoreInPrefs();
    }

    private void updateSavedScoreInPrefs() {
        prefs.putInteger(GAME_SCORE, points);			//zapis stanu punktów do prefa
        prefs.flush();									//aktualizacja danych prefa na lokalny dysk twardy (aby nie zginęły po zamknięciu programu)
    }

    public void addPassiveIncome() {
        // TODO implement
        System.out.println("passive income click");
    }

    public int getPoints() {
        return points;
    }
}
