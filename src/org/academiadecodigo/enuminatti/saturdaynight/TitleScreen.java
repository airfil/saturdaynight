package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 14/10/2017.
 */
public class TitleScreen implements KeyboardHandler {

    private boolean pressed;
    private Picture menuPicture;
    private Keyboard menuKeyboard;
    private KeyboardEvent menuKeyboardEvent;
    public static final int[] menuKeys = {KeyboardEvent.KEY_SPACE};

    public TitleScreen() {
        menuPicture = new Picture (Grid.PADDING,Grid.PADDING, "/floor.png");
        menuPicture.draw();
        createKeyboard();
    }

    public void createKeyboard() {
        menuKeyboard = new Keyboard(this);
        menuKeyboardEvent = new KeyboardEvent();
        menuKeyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        menuKeyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        menuKeyboard.addEventListener(menuKeyboardEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        System.out.println("AIRES!");
        menuPicture.delete();
        pressed = true;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        System.out.println("RODAS!");
        menuPicture.delete();
    }

    public boolean isPressed() {
        return pressed;
    }
}
