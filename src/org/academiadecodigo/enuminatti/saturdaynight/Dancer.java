package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Created by codecadet on 12/10/2017.
 */
public class Dancer {

    private GridPosition dancerPosition;
    private Rectangle dancerRectangle;
    private Grid dancerGrid;
    private int moves = 0;

    public Dancer(GridPosition dancerPosition) {

        this.dancerPosition = dancerPosition;


        int x = dancerPosition.getGameGrid().colToX(dancerPosition.getCol());
        int y = dancerPosition.getGameGrid().rowToY(dancerPosition.getRow());

        dancerRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
        dancerRectangle.setColor(Color.GREEN);
        dancerRectangle.fill();
        dancerPosition.setCurrentDirection(Direction.UP);

    }


    public GridPosition getDancerPosition() {
        return dancerPosition;
    }


    public void move() {

        int random = (int) Math.ceil(Math.random() * 100);

        if (random >= 60) {
            dancerPosition.setCurrentDirection(Direction.angleDirection(dancerPosition.getCurrentDirection()));
            moves = 4;
            accelarete();
            return;
        }

        if (moves == 0 ) {
            getDancerPosition().createRandomDirection();
            moves = 5;
            accelarete();
            return;
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

        dancerRectangle.translate(colDirectionMov, rowDirectionMov);

    }


}

