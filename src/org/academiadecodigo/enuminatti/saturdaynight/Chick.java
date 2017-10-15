package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 09/10/17.
 */
public class Chick implements Collidable {

    public static final TypeOfGameObjects myType = TypeOfGameObjects.CHICK;

    private GridPosition chickPosition;
    private Picture chickPicture;
    private TypeOfGameObjects mytype;
    private Grid chickGrid;
    private int moves = 0;
    private int beer = 0;
    private boolean firsTime=true;


    public Chick(GridPosition chickPosition) {

        // Initializing this GameObject type as Chick
        mytype = TypeOfGameObjects.CHICK;

        //Getting position in rows
        this.chickPosition = chickPosition;

        // Creating the position of the Chick in Pixels
        int x = chickPosition.getGameGrid().colToX(chickPosition.getCol());
        int y = chickPosition.getGameGrid().rowToY(chickPosition.getRow());

        //Initializing the Chick rectangle
        chickPicture = new Picture(x, y, "/chickPick.png");
        chickPicture.draw();
        chickPosition.setCurrentDirection(Direction.UP);

    }


    public void move() {
        if(firsTime){
            accelerate();
            firsTime = false;
            return;
        }
        int random = (int) Math.ceil(Math.random() * 100);

        //if the random is bigger then 95 the chick will stop moving for three iterations of the game
        if (random > 95 && moves == 0) {
            chickPosition.setCurrentDirection(Direction.NODIRECTION);
            moves = 3;
            return;
        }

        // if she ended moving in a direction she choses a new direction to move
        if (moves == 0) {
            getChickPosition().createRandomDirection();
            moves = 8;
            accelerate();
            return;
        }

        // move the chick
        moves--;
        accelerate();

    }


    public void accelerate() {

        // Checking the limits , to move safely without leaving the gamegrid

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

        //Getting the value to translate
        int colDirectionMov = chickPosition.getCurrentDirection().col * Grid.CELLSIZE;
        int rowDirectionMov = chickPosition.getCurrentDirection().row * Grid.CELLSIZE;


        // Actualy moving the chick
        chickPicture.translate(colDirectionMov, rowDirectionMov);


    }

    //When Collision happens defines what happens
    public void whenCollisionHappens() {

        chickPicture.delete();
        Picture end = new Picture(Grid.PADDING,Grid.PADDING, "/endScreen.png");
        end.draw();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.exit(0);


    }

    public void addItemtoChick(){
        beer++;
    }

    public GridPosition getChickPosition() {
        return chickPosition;
    }

    public int getBeer() {
        return beer;
    }

    @Override
    public TypeOfGameObjects getType() {
        return mytype;
    }

    @Override
    public GridPosition getPosition() {
        return chickPosition;
    }

    public void setChickGrid(Grid chickGrid) {
        this.chickGrid = chickGrid;
    }
}
