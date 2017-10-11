package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 09/10/17.
 */
public class Player implements KeyboardHandler {

    private KeyboardEvent eventUp;
    private KeyboardEvent eventDown;
    private KeyboardEvent eventLeft;
    private KeyboardEvent eventRight;

    public Player(int number) {

        //Player 1
        if (number == 1) {
            Keyboard player = new Keyboard(this);

            eventUp = new KeyboardEvent();
            eventUp.setKey(KeyboardEvent.KEY_UP);
            eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventUp);

            eventDown = new KeyboardEvent();
            eventDown.setKey(KeyboardEvent.KEY_DOWN);
            eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventDown);

            eventLeft = new KeyboardEvent();
            eventLeft.setKey(KeyboardEvent.KEY_LEFT);
            eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventLeft);

            eventRight = new KeyboardEvent();
            eventRight.setKey(KeyboardEvent.KEY_RIGHT);
            eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventRight);
        }

        //Player 2
        if (number == 2) {

            Keyboard player = new Keyboard(this);

            eventUp = new KeyboardEvent();
            eventUp.setKey(KeyboardEvent.KEY_W);
            eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventUp);

            eventDown = new KeyboardEvent();
            eventDown.setKey(KeyboardEvent.KEY_S);
            eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventDown);

            eventLeft = new KeyboardEvent();
            eventLeft.setKey(KeyboardEvent.KEY_A);
            eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventLeft);

            eventRight = new KeyboardEvent();
            eventRight.setKey(KeyboardEvent.KEY_D);
            eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            player.addEventListener(eventRight);
        }


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
