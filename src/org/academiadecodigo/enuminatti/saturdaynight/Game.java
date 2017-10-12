package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {


    static public final int COLS = 80;
    static public final int ROWS = 60;
    private Grid gameGrid;
    private Collidable[] mycollidebelObjects;
    private CollisionDetector myCollisionDetector;

    private long delay = 200;

    public Game() {

        init();
    }


    public void init() {

        gameGrid = new Grid(COLS, ROWS);

        Chick mychick = new Chick(gameGrid.newGridPostion(25, 25));
        mychick.setChickGrid(gameGrid);

        Player player1 = new Player(gameGrid.newGridPostion(25, 25), 1);
        Player player2 = new Player(gameGrid.newGridPostion(20, 20), 2);

        Item item = new Item(gameGrid.newGridPostion(20, 25));

        mycollidebelObjects = new Collidable[]{mychick, player1, player2, item};
        myCollisionDetector = new CollisionDetector(mycollidebelObjects);


    }


    public void gamestart() throws InterruptedException {
        while (true) {

            for (int i = 0; i < mycollidebelObjects.length; i++) {

                if (mycollidebelObjects[i] instanceof Player) {
                    Player myplayer = (Player) mycollidebelObjects[i];
                    myplayer.accelarete();
                    myCollisionDetector.checkObjectColliding(myplayer);
                    continue;
                }

                if (mycollidebelObjects[i] instanceof Chick) {
                    Chick myChick = (Chick) mycollidebelObjects[i];
                    myChick.move();
                    myCollisionDetector.checkObjectColliding(myChick);
                    continue;
                }
            }



            Thread.sleep(delay);


        }
    }




}
