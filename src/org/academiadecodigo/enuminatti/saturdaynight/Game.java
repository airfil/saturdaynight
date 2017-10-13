package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {

    static public final long delay = 200;
    static public final int COLS = 80;
    static public final int ROWS = 60;
    private Grid gameGrid;
    private Collidable[] mycollidabelObjects;
    private CollisionDetector myCollisionDetector;


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

        mycollidabelObjects = new Collidable[]{mychick, player1, player2, item};
    //    myCollisionDetector = new CollisionDetector(mycollidabelObjects);


    }


    public void gamestart() throws InterruptedException {
        while (true) {

            for (int i = 0; i < mycollidabelObjects.length; i++) {

                if (mycollidabelObjects[i] instanceof Player) {
                    Player myplayer = (Player) mycollidabelObjects[i];
                    myplayer.accelarete();
                    myCollisionDetector.checkObjectColliding(myplayer);
                    continue;
                }

                if (mycollidabelObjects[i] instanceof Chick) {
                    Chick myChick = (Chick) mycollidabelObjects[i];
                    myChick.move();
                    myCollisionDetector.checkObjectColliding(myChick);
                    continue;
                }
            }


            Thread.sleep(delay);


        }
    }


}
