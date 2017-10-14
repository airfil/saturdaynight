package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 14/10/2017.
 */
public class SplashScreen implements KeyboardHandler {

    private Picture menuPicture;
    private Keyboard menuKeyboard;
    private KeyboardEvent[] menuKeyboardEvent;
    public static final int[] menuKeys = {KeyboardEvent.KEY_SPACE};


    public SplashScreen() {

        menuPicture = new Picture(0, 0, "/entry.png");
        createMenuKeyboard();
    }

    public void init() {
        menuPicture.draw();
    }

    public void createMenuKeyboard() {

        menuKeyboard = new Keyboard(this);

        menuKeyboardEvent = new KeyboardEvent[menuKeys.length];

        for (int i = 0; i < menuKeys.length; i++) {
            menuKeyboardEvent[i] = new KeyboardEvent();
            menuKeyboardEvent[i].setKey(menuKeys[i]);
            menuKeyboardEvent[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            menuKeyboard.addEventListener(menuKeyboardEvent[i]);
        }

    }

    public void gameInitialization() {

        Game newGame = new Game();
        try {
            newGame.gamestart();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            menuPicture.delete();
            gameInitialization();

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
