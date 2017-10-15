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
                    myPlayer = new Player(gameGrid.newGridPosition(18,17), 1);
                    return myPlayer;
                }
                myPlayer = new Player(gameGrid.newGridPosition(18, 18), 2);
                return myPlayer;

            case CHICK:return new Chick(gameGrid.newGridPosition(18, 13));

            default: return  null;


            }
        }


    }


