
package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */

public class Game {

    static public final long delay = 200;
    static public final int COLS = 30;
    static public final int ROWS = 25;
    private Grid gameGrid;

    private Collidable[] mycollidabelObjects;
    private CollisionDetector myCollisionDetector;


    private Chick mychick;
    private Player player1;
    private Player player2;
    private Item item;
    private Dancer dancer;


    public Game() {

        init();
    }


    public void init() {

        gameGrid = new Grid(COLS, ROWS);

        Chick mychick = new Chick(gameGrid.newGridPostion(25, 25));
        mychick.setChickGrid(gameGrid);

        Player player1 = new Player(gameGrid.newGridPostion(25, 25), 1);
        Player player2 = new Player(gameGrid.newGridPostion(20, 20), 0);

        Item item = new Item(gameGrid.newGridPostion(20, 25));

        Dancer dancer = new Dancer(gameGrid.newGridPostion(10, 10));


        mycollidabelObjects = new Collidable[]{mychick, player1, player2, item,dancer};
        myCollisionDetector = new CollisionDetector(mycollidabelObjects);



    }


    public void gamestart() throws InterruptedException {
        while (true) {


            for (int i = 0; i < mycollidabelObjects.length; i++) {
                System.out.println(mycollidabelObjects[i].getType());
                System.out.println(i);
                switch (mycollidabelObjects[i].getType()) {

                    case CHICK:
                        Chick myChick = (Chick) mycollidabelObjects[i];
                        myChick.move();
                        myCollisionDetector.checkObjectColliding(myChick);
                        continue;

                    case PLAYER:
                        Player myplayer = (Player) mycollidabelObjects[i];
                        myplayer.accelarete();
                        myCollisionDetector.checkObjectColliding(myplayer);
                        continue;

                    case DANCER:
                        Dancer dancer = (Dancer) mycollidabelObjects[i];
                        dancer.move();
                        myCollisionDetector.checkObjectColliding(dancer);
                        continue;


                }


                Thread.sleep(delay);


            }
        }


    }
}




