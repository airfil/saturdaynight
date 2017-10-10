package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {


    static public final int COLS = 80;
    static  public final int ROWS= 50;
    private Grid gameGrid ;

    public Game(){


        init();
    }


    public void init(){

        gameGrid = new Grid(COLS,ROWS);

    }

}
