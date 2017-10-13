package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {


    static public final int COLS = 80;
    static public final int ROWS = 60;
    private Grid gameGrid;
    private Chick mychick;
    private Player player1;
    private Player player2;
    private Item item;
    private long delay = 200;
    private Dancer dancer;

    public Game() {

        init();
    }


    public void init() {

        gameGrid = new Grid(COLS, ROWS);

        mychick = new Chick(gameGrid.newGridPostion(25, 25));

        player1 = new Player(gameGrid.newGridPostion(25, 25), 1);
        player2 = new Player(gameGrid.newGridPostion(20, 20), 2);

        dancer = new Dancer(gameGrid.newGridPostion(10, 10));

        item = new Item(gameGrid.newGridPostion(20, 25));

        mychick.setChickGrid(gameGrid);
    }


   
}
