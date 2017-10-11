package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.security.Key;

/**
 * Created by codecadet on 09/10/17.
 */
public class Player implements KeyboardHandler {

    Keyboard playerKeyboard;
    Keyboard playerKeyboard2;
    KeyboardEvent[] events;
    KeyboardEvent[] events2;
    GridPosition pos;
    Rectangle playerRectangle;
    int items=0 ;




    public Player(GridPosition pos,int number) {



        this.pos=pos;

        this.pos.setCurrentDirection(Direction.NODIRECTION);

        int x = pos.getGameGrid().colToX(pos.getCol());
        int y = pos.getGameGrid().rowToY(pos.getRow());

        playerKeyboard = new Keyboard(this);
        playerKeyboard2 = new Keyboard(this);

        playerRectangle = new Rectangle(x,y,15,15);
        playerRectangle.setColor(Color.BLUE);
        playerRectangle.fill();

        if(number == 1){
            playerOneEvents();
        }
        if(number == 2){
            playerTwoEvents();

        }

    }

    public GridPosition getPos() {
        return pos;
    }


    public void whencolide(){

        items ++;

    }

    //Player One
    public KeyboardEvent[] playerOneEvents () {
        int[] keys = {KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_UP};

        KeyboardEvent[] pOneKeyboardEvents = new KeyboardEvent[keys.length];

        keyboardEvents(pOneKeyboardEvents , keys, playerKeyboard);


        return pOneKeyboardEvents;
    }

    //Player Two
    public KeyboardEvent[] playerTwoEvents () {
        int[] keys ={KeyboardEvent.KEY_A, KeyboardEvent.KEY_D, KeyboardEvent.KEY_S, KeyboardEvent.KEY_W};

        KeyboardEvent[] pTwoKeyboardsEvents = new KeyboardEvent[keys.length];
        keyboardEvents(pTwoKeyboardsEvents, keys, playerKeyboard2);


        return pTwoKeyboardsEvents;
    }


    private  void keyboardEvents(KeyboardEvent[] keyboard,int keys[],Keyboard pickKeyboard){



        for (int i = 0; i < keyboard.length; i++) {

            keyboard[i] = new KeyboardEvent();
            keyboard[i].setKey(keys[i]);
            keyboard[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            pickKeyboard.addEventListener(keyboard[i]);

        }


    }

    public void accelarete() {



        switch (pos.getCurrentDirection()) {

            case UP:
                pos.moveUp();
                break;
            case DOWN:
               pos.moveDown();
                break;
            case RIGTH:
                pos.moveRigth();
                break;
            case LEFT:
                pos.moveLeft();
                break;


        }



       // System.out.println(pos.getCurrentDirection().row );

        int colDirectionMov = pos.getCurrentDirection().col * Grid.CELLSIZE;

        int rowDirectionMov = pos.getCurrentDirection().row * Grid.CELLSIZE;

        playerRectangle.translate(colDirectionMov, rowDirectionMov);

        pos.setCurrentDirection(Direction.NODIRECTION);


    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){

            pos.setCurrentDirection(Direction.UP);
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){

            pos.setCurrentDirection(Direction.DOWN);
        }

        if(keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT){

            pos.setCurrentDirection(Direction.RIGTH);
        }

        if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT){

            pos.setCurrentDirection(Direction.LEFT);
        }

        if (keyboardEvent.getKey() == keyboardEvent.KEY_W){
            System.out.println("W");
            pos.setCurrentDirection(Direction.UP);
        }

        if (keyboardEvent.getKey() == keyboardEvent.KEY_S){

            pos.setCurrentDirection(Direction.DOWN);
        }

        if (keyboardEvent.getKey() == keyboardEvent.KEY_A){

            pos.setCurrentDirection(Direction.LEFT);
        }

        if (keyboardEvent.getKey() == keyboardEvent.KEY_D){

            pos.setCurrentDirection(Direction.RIGTH);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
