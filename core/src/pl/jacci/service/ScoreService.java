package pl.jacci.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.concurrent.TimeUnit;

public class ScoreService {
    public final static String GAME_PREFS = "pl.jacci.tutorialClicker.prefs";			//Scieżka do zapisu nazwy, konwencja nazwy: package + nazwa projektu + prefs
    public final static String GAME_SCORE = "pl.jacci.tutorialClicker.prefs.score";		//'plik' w ścieżce do zapisu określonej wartości
    public final static String GAME_PASSIVE_INCOME = "pl.jacci.tutorialClicker.prefs.passiveincome";
    public final static String GAME_SAVED_TIMESTAMP = "pl.jacci.tutorialClicker.prefs.savedtimestamp";   //zawiera dochód zdobyty podczas wyłączonej aplikacji

    private Preferences prefs;                                  //umożliwa zapisanie danych które nie giną po zamknięciu programu (tu wykorzystamy to do zapisywania punktów)
    private int points;
    private int passiveIncome;

    public ScoreService(){
        init();
    }

    private void init() {
        prefs =  Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
        loadPassiveIncome();
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);			//odczyt stanu punktów z prefa
    }

    private void loadPassiveIncome() {
        passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOME);
    }

    public void addPoints(int pointsToAdd){
        points += pointsToAdd;
    }

    public void addPoint(){
        points++;
    }

    public void resetGameScore() {
        points = 0;
        passiveIncome = 0;
    }

    public void addPassiveIncome() {
        passiveIncome++;
    }

    public long getSavedTimestamp(){
        return prefs.getLong(GAME_SAVED_TIMESTAMP);
    }

    public void saveCurrentGameState() {
        prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());        //zapisuje do prefsa ilość milisekund od 1.01.1970 do teraz
        prefs.putInteger(GAME_SCORE, points);			                //zapis stanu punktów do prefa
        prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);			//zapis stanu pasywnego dochodu do prefa
        prefs.flush();									                //aktualizacja danych prefa na lokalny dysk twardy (aby nie zginęły po zamknięciu programu)
    }




    //GETTERY_______________________________________

    public int getPoints() {
        return points;
    }

    public int getPassiveIncome() {
        return passiveIncome;
    }

}
















