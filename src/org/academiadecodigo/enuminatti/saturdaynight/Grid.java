package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 09/10/17.
 */
public class Grid {

    public static final int PADDING = 10;
    public static final int PADDINGEXTRA = 20;
    public static final int CELLSIZE = 30;
    public static int HEIGHT; //rows * celsize
    public static int WIDTH; //cols * celsize


    private int cols ;
    private int rows;
    private Picture gameGrid ;

    public Grid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;
        this.gameGrid = new Picture(PADDING,PADDING,"resources/dancefloor.png");
        gameGrid.draw();
        HEIGHT = cols*CELLSIZE+PADDING;
        WIDTH = rows*CELLSIZE+PADDING;

    }


    public int getRows() {
        return rows;
    }

    public int getCols() {

        return cols;
    }

    public int rowToY(int row){
        return  row * CELLSIZE + PADDING;
    }


    public int colToX( int col){
        return  col * CELLSIZE + PADDING;
    }

    public GridPosition newGridPosition(int row , int col){
        return  new GridPosition(col,row,this);
    }


    // Grid position used for item randomize first time it appears in the screen
    public GridPosition newGridPosition(){
        return  new GridPosition(this,0,25);
    }

    public void rectangleMove(int i){

        gameGrid.translate(0,i);

    }

    public GridPosition newGridPosition(Grid gameGrid){
        return  new GridPosition(this);
    }


}
