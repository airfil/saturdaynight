
package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.enuminatti.saturdaynight.utils.Sound;

import java.util.LinkedList;

/**
 * Created by codecadet on 09/10/17.
 */

public class Game {


    public static final TypeOfGameObjects[] objectsToCreate = {TypeOfGameObjects.PLAYER, TypeOfGameObjects.PLAYER,
            TypeOfGameObjects.CHICK, TypeOfGameObjects.DANCER, TypeOfGameObjects.DANCER, TypeOfGameObjects.DANCER,
            TypeOfGameObjects.DANCER, TypeOfGameObjects.DANCER, TypeOfGameObjects.DANCER};

    static public final long delay = 25;
    static public final int COLS = 32;
    static public final int ROWS = 18;
    private Grid gameGrid;

    private LinkedList<Collidable> myCollidabelObjects;
    private CollisionDetector myCollisionDetector;

    private TitleScreen menu;

    Sound bailando = new Sound("/resources/bailando2.wav");

    public Game() {

        titleScreenController();
    }


    public void init() {

        myCollidabelObjects = new LinkedList<Collidable>();

        gameGrid = new Grid(COLS, ROWS);


        LinkedList<Item> myItems = new LinkedList<Item>();
        Item item = new Item(gameGrid.newGridPosition(7, 13), true);
        Item beer = new Item(gameGrid.newGridPosition(10, 12), false);
        Item beer1 = new Item((gameGrid.newGridPosition(9, 15)), false);


        myItems.add(item);
        myItems.add(beer);
        myItems.add(beer1);


        for (int i = 0; i < objectsToCreate.length; i++) {
            Collidable myGameObjects = GameObjectFactory.createObjects(objectsToCreate[i], gameGrid);
            myCollidabelObjects.add(myGameObjects);
        }

        myCollisionDetector = new CollisionDetector(myCollidabelObjects, myItems);

        try {
            gameStart();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void titleScreenController() {

        bailando.play(true);
        menu = new TitleScreen();
        while (!menu.isInstructionsRead()) {
        }
        init();

    }


    public void gameStart() throws InterruptedException {
        while (true) {

            for (int i = 0; i < myCollidabelObjects.size(); i++) {

                switch (myCollidabelObjects.get(i).getType()) {

                    case CHICK:
                        Chick myChick = (Chick) myCollidabelObjects.get(i);
                        myChick.move();
                        myCollisionDetector.checkObjectColliding(myChick);
                        break;

                    case PLAYER:
                        Player myPlayer = (Player) myCollidabelObjects.get(i);
                        myPlayer.accelarete();
                        myCollisionDetector.checkObjectColliding(myPlayer);
                        break;

                    case DANCER:
                        Dancer dancer = (Dancer) myCollidabelObjects.get(i);
                        dancer.move();
                        myCollisionDetector.checkObjectColliding(dancer);
                        break;
                }

                Thread.sleep(delay);

            }
        }
    }
}




