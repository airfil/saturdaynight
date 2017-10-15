package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 09/10/17.
 */
public class Player implements KeyboardHandler, Collidable {

    // CONSTANT the typeof this GameObject will always be a Player
    public static final TypeOfGameObjects myType = TypeOfGameObjects.PLAYER;

    //Key binds for PlayerOne and PlayerTwo
    public static final int[] keyPlayer1 = {KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_UP};

    public static final int[] keyPlayer2 = {KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_D, KeyboardEvent.KEY_S, KeyboardEvent.KEY_W};


    // Keyboard related properties
    private Keyboard playerKeyboard;
    private KeyboardEvent[] pOneKeyboardEvents;


    //Player Position and Rectangle
    private GridPosition gridPosition;
    private Picture playerPicture;
    private Picture[] beers;
    private Picture[] myItems;


    //Player support properties
    private int items = 0;
    private int moves = 0;
    private int confidence = 0;


    public Player(GridPosition gridPosition, int myController) {

        //Initializng the gridPosition of the player
        this.gridPosition = gridPosition;
        int x = gridPosition.getGameGrid().colToX(gridPosition.getCol());
        int y = gridPosition.getGameGrid().rowToY(gridPosition.getRow());

        //Giving initial direction to the player
        this.gridPosition.setCurrentDirection(Direction.NODIRECTION);


        if (myController == 1) {

            createKeyboards(keyPlayer1);
            this.playerPicture = new Picture(x, y, "resources/playerOne.png");
            this.playerPicture.draw();
            playerOneInitializingPictures();
            return;

        }

        createKeyboards(keyPlayer2);
        this.playerPicture = new Picture(x, y, "resources/playerTwo.png");
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


        gridPosition.setCurrentDirection(newDirection);

        moves = 3;
        accelarete();

    }

    public void accelarete() {


        checkInLimmits();

        int colDirectionMov = gridPosition.getCurrentDirection().col * Grid.CELLSIZE;

        int rowDirectionMov = gridPosition.getCurrentDirection().row * Grid.CELLSIZE;

        playerPicture.translate(colDirectionMov, rowDirectionMov);

        if (moves <= 0) {
            gridPosition.setCurrentDirection(Direction.NODIRECTION);
        }

        moves--;


    }

    public void checkInLimmits() {

        switch (gridPosition.getCurrentDirection()) {

            case UP:
                gridPosition.moveUp();
                break;
            case DOWN:
                gridPosition.moveDown();
                break;
            case RIGTH:
                gridPosition.moveRigth();
                break;
            case LEFT:
                gridPosition.moveLeft();
                break;


        }
    }

    public void addItemToPlayer() {

        if (items < 5) {
            items++;
            myItems[items - 1].draw();
        }


    }

    public void addConfidenceToPlayer() {

        if (confidence < 9) {
            confidence += 3;
            beers[(confidence / 3) - 1].draw();
        }


    }

    public void playerTwoInitializingPictures() {

        myItems = new Picture[5];
        beers = new Picture[3];

        for (int i = 0; i < myItems.length; i++) {
            myItems[i] = new Picture((4 + i) * Grid.CELLSIZE, 20 * Grid.CELLSIZE, "resources/item.png");

        }

        for (int j = 0; j < beers.length; j++) {
            beers[j] = new Picture((4 + j) * Grid.CELLSIZE, 22 * Grid.CELLSIZE, "resources/cerveja2.png");

        }
    }

    public void playerOneInitializingPictures() {

        myItems = new Picture[5];
        beers = new Picture[3];

        for (int i = 4; i >= 0; i--) {
            myItems[i] = new Picture((27 - i) * Grid.CELLSIZE, 20 * Grid.CELLSIZE, "resources/item.png");

        }

        for (int j = 2; j >= 0; j--) {
            beers[j] = new Picture((27 - j) * Grid.CELLSIZE, 22 * Grid.CELLSIZE, "resources/cerveja2.png");

        }
    }


    @Override
    public GridPosition getPosition() {
        return gridPosition;
    }

    public int getConfidence() {
        return confidence;
    }

    public void resetConfidence() {
        confidence = 0;
        for (int i = 0; i < beers.length; i++) {

            beers[i].delete();
        }
    }

    public int getItems() {
        return items;
    }


    public void resetItems() {
        items = 0;
        for (int i = 0; i < myItems.length; i++) {

            myItems[i].delete();
        }
    }

    @Override
    public TypeOfGameObjects getType() {
        return myType;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (moves != 0) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {

                gridPosition.setCurrentDirection(Direction.UP);

            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {

                gridPosition.setCurrentDirection(Direction.DOWN);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {

                gridPosition.setCurrentDirection(Direction.RIGTH);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {

                gridPosition.setCurrentDirection(Direction.LEFT);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
                gridPosition.setCurrentDirection(Direction.UP);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {

                gridPosition.setCurrentDirection(Direction.DOWN);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {

                gridPosition.setCurrentDirection(Direction.LEFT);
            }

            if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {

                gridPosition.setCurrentDirection(Direction.RIGTH);
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
