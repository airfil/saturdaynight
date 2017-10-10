package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class GridPosition {

    private Direction currentDirection;
    private int col;
    private int row;
    private Grid gameGrid;

    //Creating a GridPosition  to use if we want a previous defined position
    public GridPosition(int col, int row, Grid gameGrid) {

        //The gameGrid of this position
        this.gameGrid = gameGrid;

        //Turning Col and Row into  pixeis (x,y)
        this.col = gameGrid.colToX(col);
        this.row = gameGrid.rowToY(row);

        //Initializing the current Direction to NODIRECTION
        currentDirection = Direction.NODIRECTION;

    }

    // Creating constructor for generating a random position for the various Objects
    public GridPosition(Grid gameGrid) {

        //Generating random col and row
        this.col = (int) Math.random() * gameGrid.getCols();
        this.row = (int) Math.random() * gameGrid.getRows();

        //The gameGrid of this position
        this.gameGrid = gameGrid;

        //Turning Col and Row into  pixeis (x,y)
        this.col = gameGrid.colToX(col);
        this.row = gameGrid.rowToY(row);

        //Initializing the current Direction to NODIRECTION
        currentDirection = Direction.NODIRECTION;

    }


    public int getRow() {
        return row;
    }

    public int getCol() {

        return col;
    }

    public void moveDown() {
        if (Grid.WIDTH >= gameGrid.rowToY(getRow())) {
            currentDirection = Direction.UP;
            return;
        }
        currentDirection = Direction.DOWN;

    }

    public void moveUp() {
        if (Grid.WIDTH < gameGrid.rowToY(getRow())) {
            currentDirection = Direction.DOWN;
            return;
        }
        currentDirection = Direction.UP;
    }

    public void moveLeft() {
        if (Grid.HEIGHT < gameGrid.colToX(getCol())) {
            currentDirection = Direction.RIGTH;
            return;
        }
        currentDirection = Direction.LEFT;
    }

    public void moveRight() {
        if (Grid.HEIGHT >= gameGrid.colToX(getCol())) {
            currentDirection = Direction.LEFT;
            return;
        }
        currentDirection = Direction.RIGTH;
    }

    //Method to get a random direction in witch the NPC will move
    public void createRandomDirection() {

        //Creating a random number to generate a new direction
        int random = (int) Math.random() * Direction.values().length;

        Direction newDirection = Direction.values()[random];

        //Using the newDirection to find and give the value of the new direction to this position
        switch (newDirection) {
            case LEFT:
                currentDirection = Direction.LEFT;
                break;
            case DOWN:
                currentDirection = Direction.DOWN;
                break;
            case UP:
                currentDirection = Direction.UP;
                break;
            case RIGTH:
                currentDirection = Direction.RIGTH;
                break;
            case NODIRECTION:
                currentDirection = Direction.NODIRECTION;
        }


    }


}
