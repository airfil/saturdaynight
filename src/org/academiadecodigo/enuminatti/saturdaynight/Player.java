package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 09/10/17.
 */
public class Player implements KeyboardHandler, Collidable {

    // CONSTANT the typeof this Gameobject will alwasys be a Player
    public static final TypeOfGameObjects myType = TypeOfGameObjects.PLAYER;

    //Key binds for PlayerOne and PlayerTwo
    public static final int[] keyPlayer1 = {KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_UP};

    public static final int[] keyPlayer2 = {KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_D, KeyboardEvent.KEY_S, KeyboardEvent.KEY_W};


    // Keyboard Related Proprety's
    private Keyboard playerKeyboard;
    KeyboardEvent[] pOneKeyboardEvents;


    //Player Positon and Rectangle
    private GridPosition pos;
    private Picture playerPicture;
    private Picture[] berrs ;
    private Picture[] myitems ;


    //Player support proprities
    private int items = 0;
    private int moves = 0;
    private int confidence = 0;


    public Player(GridPosition pos, int mycontroler) {

        //Initializng the pos of the player
        this.pos = pos;
        int x = pos.getGameGrid().colToX(pos.getCol());
        int y = pos.getGameGrid().rowToY(pos.getRow());

        //Giving initial direction to the player
        this.pos.setCurrentDirection(Direction.NODIRECTION);


        if (mycontroler == 1) {

            createKeyboards(keyPlayer1);
            this.playerPicture = new Picture(x, y, "/playerOne.png");
            this.playerPicture.draw();
            playerOneInitializingPictures();
            return;

        }

        createKeyboards(keyPlayer2);
        this.playerPicture = new Picture(x, y, "/playerTwo.png");
        this.playerPicture.draw();
        playerTwoInitializingPictures();
        return;


    }

    private void createKeyboards(int[] keys) {

        playerKeyboard = new Keyboard(this);

        pOneKeyboardEvents = new KeyboardEvent[keyPlayer1.length];

        for (int i = 0; i < pOneKeyboardEvents.length; i++) {

            pOneKeyboardEvents[i] = new KeyboardEvent();
            pOneKeyboardEvents[i].setKey(keys[i]);
            pOneKeyboardEvents[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            playerKeyboard.addEventListener(pOneKeyboardEvents[i]);

        }


    }

    public void beingPushed(Direction newDirection) {


        pos.setCurrentDirection(newDirection);

        moves = 3;
        accelarete();

    }

    public void accelarete() {


        checkInLimmits();

        int colDirectionMov = pos.getCurrentDirection().col * Grid.CELLSIZE;

        int rowDirectionMov = pos.getCurrentDirection().row * Grid.CELLSIZE;

        playerPicture.translate(colDirectionMov, rowDirectionMov);

        if (moves <= 0) {
            pos.setCurrentDirection(Direction.NODIRECTION);
        }

        moves--;


    }

    public void checkInLimmits() {

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
    }

    public void addItemToPlayer() {

        if(items < 5){
            items++;
            myitems[items-1].draw();
        }


    }
    public void addConfidenceToPlayer(){

        if(confidence < 9){
            confidence +=3;
            berrs[(confidence/3)-1].draw();
        }



    }

    public void playerTwoInitializingPictures(){

       myitems = new Picture[5];
       berrs = new Picture[3];

        for (int i = 0; i < myitems.length; i++) {
            myitems[i] = new Picture((4+i)*Grid.CELLSIZE ,20* Grid.CELLSIZE ,"/item.png");

        }

        for (int j = 0; j < berrs.length ; j++) {
            berrs[j] = new Picture((4+j)*Grid.CELLSIZE ,22* Grid.CELLSIZE ,"/cerveja2.png");

        }
    }

    public void playerOneInitializingPictures(){

        myitems = new Picture[5];
        berrs = new Picture[3];

        for (int i = 4; i >= 0; i--) {
            myitems[i] = new Picture((27-i)*Grid.CELLSIZE ,20* Grid.CELLSIZE ,"/item.png");

        }

        for (int j = 2; j >= 0 ; j--) {
            berrs[j] = new Picture((27-j)*Grid.CELLSIZE ,22* Grid.CELLSIZE ,"/cerveja2.png");

        }
    }





    @Override
    public GridPosition getPosition() {
        return pos;
    }

    public int getConfidence() {
        return confidence;
    }
    public void resetConfidence(){
        confidence = 0;
        for (int i = 0; i < berrs.length ; i++) {

            berrs[i].delete();
        }
    }

    public int getItems() {
        return items;
    }


    public void resetItems() {
        items = 0;
        for (int i = 0; i < myitems.length ; i++) {

            myitems[i].delete();
        }
    }

    @Override
    public TypeOfGameObjects getType() {
        return myType;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (moves != 0) {

           // System.out.println("Player: " + items);

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {

                pos.setCurrentDirection(Direction.UP);

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {

                pos.setCurrentDirection(Direction.DOWN);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {

                pos.setCurrentDirection(Direction.RIGTH);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {

                pos.setCurrentDirection(Direction.LEFT);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
                pos.setCurrentDirection(Direction.UP);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {

                pos.setCurrentDirection(Direction.DOWN);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {

                pos.setCurrentDirection(Direction.LEFT);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {

                pos.setCurrentDirection(Direction.RIGTH);
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
