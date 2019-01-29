package pl.jacci.desktop;

/**     Wykorzystanie LibGDX  do stworzenie dry : tutorialClicker
 * https://www.youtube.com/watch?v=1fT1-e377Ws&index=1&list=PLFq6ri1W22hwmA0FzkR5zPPOnsimwUc9P
 * https://github.com/JavaDevMatt/tutorialclicker/tree/tut8
 * https://github.com/libgdx/libgdx/wiki
 */

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.jacci.TutorialClickerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TutorialClickerGame.GAME_NAME;
		config.width = TutorialClickerGame.WIDTH;
		config.height = TutorialClickerGame.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new TutorialClickerGame(), config);
	}
}
