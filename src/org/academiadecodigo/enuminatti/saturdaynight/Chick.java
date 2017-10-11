package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 09/10/17.
 */
public class Chick implements Collidable {

    private GridPosition chickPosition;
    private Rectangle chickRectangle;
    private Grid chickGrid;
    private int moves = 0;

    public Chick(GridPosition chickPosition) {

        this.chickPosition = chickPosition;
        System.out.println("Chick initial row:" + chickPosition.getCol());
        System.out.println("Chick initial col:" + chickPosition.getRow());
        int x = chickPosition.getGameGrid().colToX(chickPosition.getCol());
        int y = chickPosition.getGameGrid().rowToY(chickPosition.getRow());
        chickRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
        chickRectangle.setColor(Color.PINK);
        chickRectangle.fill();
        chickPosition.setCurrentDirection(Direction.RIGTH);

    }


    public GridPosition getChickPosition() {
        return chickPosition;
    }


    public void move() {

         int random = (int)Math.ceil(Math.random()*100);

         if(random > 95){
             chickPosition.setCurrentDirection(Direction.NODIRECTION);
             moves = 3;
             return;
         }

        if(moves == 0) {
            getChickPosition().createRandomDirection();
            moves = 8;
            accelarete();
            return;
        }

        moves--;
        accelarete();

    }


    public void setChickGrid(Grid chickGrid) {
        this.chickGrid = chickGrid;
    }

    public void accelarete() {




        switch (chickPosition.getCurrentDirection()) {

            case UP:
                chickPosition.moveUp();
                break;
            case DOWN:
                chickPosition.moveDown();
                break;
            case RIGTH:
                chickPosition.moveRigth();
                break;
            case LEFT:
                chickPosition.moveLeft();

        }

        int colDirectionMov = chickPosition.getCurrentDirection().col * Grid.CELLSIZE;
        int rowDirectionMov = chickPosition.getCurrentDirection().row * Grid.CELLSIZE;

        chickRectangle.translate(colDirectionMov, rowDirectionMov);


    }


}
