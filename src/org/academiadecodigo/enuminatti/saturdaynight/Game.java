package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {


    static public final int COLS = 80;
    static  public final int ROWS= 60;
    private Grid gameGrid ;
    private Chick mychick ;
    private Item item ;
    private long delay = 200;

    public Game(){


        init();
    }


    public void init(){

        gameGrid = new Grid(COLS,ROWS);

        mychick = new Chick(gameGrid.newGridPostion(25,25));

        item = new Item(gameGrid.newGridPostion());

        mychick.setChickGrid(gameGrid);
    }


    public void gamestart() throws  InterruptedException{
        while (true){

            mychick.move();


            Thread.sleep(delay);

        }
    }

}
