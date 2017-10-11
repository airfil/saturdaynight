package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public enum Direction {

    RIGTH(1,0),
    LEFT(-1,0),
    UP(0,-1),
    DOWN(0,1),
    NODIRECTION(0,0);

    int col;
    int row;

    Direction(int col , int row){

        this.col=col;
        this.row = row;
    }

    static public Direction oppositeDirection(Direction myDirection ){


        switch (myDirection){

            case RIGTH:return Direction.LEFT;

            case UP: return Direction.DOWN;

            case DOWN:return Direction.UP;

            case LEFT:return Direction.RIGTH;

            default:return  Direction.NODIRECTION;

        }


    }



}
