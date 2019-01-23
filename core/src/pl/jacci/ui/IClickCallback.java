package pl.jacci.ui;

/**
 * interfejs stworzony po to aby do klasy PlayerButton można było przenieść clickListenera z GamePlayScreen.
 * Dzięki temu kod w gamePlayScreen wygląda bardziej przejrzyście
 */

public interface IClickCallback {
    void onClick();
}
