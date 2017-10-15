package org.academiadecodigo.enuminatti.saturdaynight;

import java.io.InvalidObjectException;

/**
 * Created by codecadet on 14/10/17.
 */
public class GameObjectFactory {

    public static Player myPlayer = null;


    public static Collidable createObjects(TypeOfGameObjects type, Grid gameGrid) {

        Collidable gameobject = null;

        switch (type) {
            case DANCER:
                return new Dancer(gameGrid.newGridPosition(gameGrid));

            case PLAYER:
                if (myPlayer == null) {
                    myPlayer = new Player(gameGrid.newGridPosition(25, 25), 1);
                    return myPlayer;
                }
                myPlayer = new Player(gameGrid.newGridPosition(22, 3), 2);
                return myPlayer;

            case CHICK:return new Chick(gameGrid.newGridPosition(25, 25));

            default: return  null;


            }
        }


    }


