package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 12/10/2017.
 */
public class Dancer implements Collidable {

    public final static TypeOfGameObjects myType = TypeOfGameObjects.DANCER;

    private int moves = 4;
    private int square = 1;
    private TypeOfGameObjects mytype;
    private boolean squaredancing;
    private Grid dancerGrid;
    private GridPosition dancerPosition;
    private Picture dancerPicture;

    public Dancer(GridPosition dancerPosition) {

        mytype = myType;

        this.dancerPosition = dancerPosition;


        int x = dancerPosition.getGameGrid().colToX(dancerPosition.getCol());
        int y = dancerPosition.getGameGrid().rowToY(dancerPosition.getRow());

        dancerPicture = new Picture(x,y, "/dancer.png");
        dancerPicture.draw();
        dancerPosition.setCurrentDirection(Direction.UP);
        squaredancing = true;

    }


    public void move() {

        Direction dancerdirection = dancerPosition.getCurrentDirection();

        if (squaredancing && moves == 0) {
            dancerPosition.setCurrentDirection(Direction.angleDirection(dancerdirection));
            moves = 3;
            square++;
            squaredancing = true;
        }

        if (square == 4) {
            squaredancing = false;
        }

        if (!squaredancing && moves == 0) {

            int random = (int) Math.ceil(Math.random() * 100);

            if (random <= 60) {
                moves = 4;
                squaredancing = true;
                square = 0;
            }
            dancerPosition.createRandomDirection();
            moves = 3;

        }

        moves--;
        accelarete();

    }


    public void setDancerGrid(Grid dancerGrid) {
        this.dancerGrid = dancerGrid;
    }

    public void accelarete() {


        switch (dancerPosition.getCurrentDirection()) {

            case UP:
                dancerPosition.moveUp();
                break;
            case DOWN:
                dancerPosition.moveDown();
                break;
            case RIGTH:
                dancerPosition.moveRigth();
                break;
            case LEFT:
                dancerPosition.moveLeft();

        }

        int colDirectionMov = dancerPosition.getCurrentDirection().col * Grid.CELLSIZE;
        int rowDirectionMov = dancerPosition.getCurrentDirection().row * Grid.CELLSIZE;

        dancerPicture.translate(colDirectionMov, rowDirectionMov);

    }


    @Override
    public GridPosition getPosition() {
        return dancerPosition;
    }

    @Override
    public TypeOfGameObjects getType() {
        return myType;
    }


    public GridPosition getDancerPosition() {
        return dancerPosition;
    }

}


