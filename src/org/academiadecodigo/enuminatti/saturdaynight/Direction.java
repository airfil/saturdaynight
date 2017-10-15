package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public enum Direction {

    RIGTH(1, 0),
    LEFT(-1, 0),
    UP(0, -1),
    DOWN(0, 1),
    NODIRECTION(0, 0);

    int col;
    int row;

    Direction(int col, int row) {

        this.col = col;
        this.row = row;
    }

    static public Direction randomDirection() {

        int random = (int) (Math.random() * 4);
        Direction myDirection = values()[random];

        switch (myDirection) {

            case RIGTH:
                return Direction.RIGTH;

            case UP:
                return Direction.UP;

            case DOWN:
                return Direction.DOWN;

            case LEFT:
                return Direction.LEFT;

            default:
                return Direction.NODIRECTION;

        }


    }

    static public Direction angleDirection(Direction myDirection) {


        switch (myDirection) {

            case RIGTH:
                return Direction.DOWN;

            case UP:
                return Direction.RIGTH;

            case DOWN:
                return Direction.LEFT;

            case LEFT:
                return Direction.UP;

            default:
                return Direction.NODIRECTION;

        }


    }


}
