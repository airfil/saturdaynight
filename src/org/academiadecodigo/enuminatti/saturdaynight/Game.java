
package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */

public class Game {

    static public final long delay = 200;
    static public final int COLS = 80;
    static public final int ROWS = 60;
    private Grid gameGrid;

    private Collidable[] myCollidablelObjects;
    private CollisionDetector myCollisionDetector;


    private Chick mychick;
    private Player player1;
    private Player player2;
    private Item item;
    private Dancer dancer;
    private Item[] beers;



    public Game() {

        init();
    }


    public void init() {

        gameGrid = new Grid(COLS, ROWS);

        Chick myChick = new Chick(gameGrid.newGridPostion(25, 25));
        myChick.setChickGrid(gameGrid);

        Player player1 = new Player(gameGrid.newGridPostion(25, 25), 1);
        Player player2 = new Player(gameGrid.newGridPostion(20, 20), 0);

        Item item = new Item(gameGrid.newGridPostion(20, 25),true);
        Item beer = new Item(gameGrid.newGridPostion(26,28),false);


        Dancer dancer = new Dancer(gameGrid.newGridPostion(10, 10));


        myCollidablelObjects = new Collidable[]{myChick, player1, player2, item, dancer,};
        myCollisionDetector = new CollisionDetector(myCollidablelObjects);




    }


    public void gameStart() throws InterruptedException {
        while (true) {


            for (int i = 0; i < myCollidablelObjects.length; i++) {
                System.out.println(myCollidablelObjects[i].getType());
                System.out.println(i);
                switch (myCollidablelObjects[i].getType()) {

                    case CHICK:
                        Chick myChick = (Chick) myCollidablelObjects[i];
                        myChick.move();
                        myCollisionDetector.checkObjectColliding(myChick);
                        continue;

                    case PLAYER:
                        Player myplayer = (Player) myCollidablelObjects[i];
                        myplayer.accelarete();
                        myCollisionDetector.checkObjectColliding(myplayer);
                        continue;

                    case DANCER:
                        Dancer dancer = (Dancer) myCollidablelObjects[i];
                        dancer.move();
                        myCollisionDetector.checkObjectColliding(dancer);
                        continue;



                }


                Thread.sleep(delay);


            }
        }


    }
}




