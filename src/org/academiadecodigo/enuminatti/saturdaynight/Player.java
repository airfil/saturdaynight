package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 09/10/17.
 */
public class Player implements KeyboardHandler {

    Keyboard playerKeyboard;
    KeyboardEvent[] events;
    GridPosition pos;




    public Player(GridPosition pos,int number) {

        if(number == 1){
            playerOneEvents();
        }
        if(number == 2){
            playerTwoEvents();
        }

    }



    //Player One
    public KeyboardEvent[] playerOneEvents () {
        int[] keys = {KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_UP};

        KeyboardEvent[] pOneKeyboardEvents = new KeyboardEvent[keys.length];
        keyboardEvents(playerOneEvents(), keys);


        return pOneKeyboardEvents;
    }

    //Player Two
    public KeyboardEvent[] playerTwoEvents () {
        int[] keys ={KeyboardEvent.KEY_A, KeyboardEvent.KEY_D, KeyboardEvent.KEY_S, KeyboardEvent.KEY_W};

        KeyboardEvent[] pTwoKeyboardsEvents = new KeyboardEvent[keys.length];
        keyboardEvents(playerTwoEvents(), keys);


        return pTwoKeyboardsEvents;
    }


    private  void keyboardEvents(KeyboardEvent[] keyboard,int keys[]){
        for (int i = 0; i < keyboard.length; i++) {

            keyboard[i] = new KeyboardEvent();
            keyboard[i].setKey(keys[i]);
            keyboard[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            playerKeyboard.addEventListener(keyboard[i]);

        }
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
