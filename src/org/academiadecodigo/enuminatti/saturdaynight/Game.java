
package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

/**
 * Created by codecadet on 09/10/17.
 */

public class Game {


    public static  final  TypeOfGameObjects[] objectsToCreate = {TypeOfGameObjects.PLAYER,TypeOfGameObjects.PLAYER ,
    TypeOfGameObjects.CHICK , TypeOfGameObjects.DANCER, TypeOfGameObjects.DANCER , TypeOfGameObjects.DANCER};

    static public final long delay = 25;
    static public final int COLS = 32;
    static public final int ROWS = 20;
    private Grid gameGrid;

    private LinkedList<Collidable> mycollidabelObjects;
    private CollisionDetector myCollisionDetector;

    private TitleScreen menu;


    public Game() {

        titleScreenController();
    }


    public void init() {

        mycollidabelObjects = new LinkedList<Collidable>();

        gameGrid = new Grid(COLS, ROWS);


        LinkedList<Item> myItems = new LinkedList<Item>();
        Item item = new Item(gameGrid.newGridPosition(7,13),true);
        Item beer = new Item(gameGrid.newGridPosition(10,12),false);
        Item beer1 = new Item((gameGrid.newGridPosition(9,15)),false);


        myItems.add(item);
        myItems.add(beer);
        myItems.add(beer1);


        for (int i = 0 ; i < objectsToCreate.length ; i++){
           Collidable mygameobject =  GameObjectFactory.createObjects(objectsToCreate[i],gameGrid);
            mycollidabelObjects.add(mygameobject);
        }

        myCollisionDetector = new CollisionDetector(mycollidabelObjects,myItems);

        try {
            gamestart();
        } catch (InterruptedException ex) {
            System.out.println("RODAS");
        }

    }

    public void titleScreenController() {
        menu = new TitleScreen();
        while (!menu.isPressed()){
            System.out.println("R");
        }
        init();

    }


    public void gamestart() throws InterruptedException {
        while (true) {


            for (int i = 0; i < mycollidabelObjects.size(); i++) {
                switch (mycollidabelObjects.get(i).getType()) {

                    case CHICK:
                        Chick myChick = (Chick) mycollidabelObjects.get(i);
                        myChick.move();
                        myCollisionDetector.checkObjectColliding(myChick);
                        break;

                    case PLAYER:
                        Player myplayer = (Player)mycollidabelObjects.get(i);
                        myplayer.accelarete();
                        myCollisionDetector.checkObjectColliding(myplayer);
                        break;

                    case DANCER:
                        Dancer dancer = (Dancer) mycollidabelObjects.get(i);
                        dancer.move();
                        myCollisionDetector.checkObjectColliding(dancer);
                        break;



                }


                Thread.sleep(delay);


            }
        }


    }
}




