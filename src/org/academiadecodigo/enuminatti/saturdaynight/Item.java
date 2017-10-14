package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 09/10/17.
 */
public class Item implements Collidable {

    // CONSTANT the typeof this Gameobject will alwasys be a Item
    public static final TypeOfGameObjects myType = TypeOfGameObjects.ITEM;

    private GridPosition itemPosition;
    private Rectangle itemRectangle;
    private boolean itemStatus;


    public Item(GridPosition itemPosition,boolean itemType) {

        this.itemPosition = itemPosition;
        this.itemStatus = itemType;

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());
        if (itemType == false) {

            this.itemRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
            itemRectangle.setColor(Color.ORANGE);
            itemRectangle.fill();
            return;
        }
            this.itemRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
            itemRectangle.setColor(Color.BLACK);
            itemRectangle.fill();

        }

    public void itemRespawn() {

        itemRectangle.delete();


        itemPosition.setCol((int) Math.floor(Math.random() * itemPosition.getGameGrid().getCols() ));
        itemPosition.setRow((int) Math.floor(Math.random() * itemPosition.getGameGrid().getRows() ));

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());

        this.itemRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
        if(this.itemStatus == false){
            this.itemRectangle.setColor(Color.ORANGE);
        }

        itemRectangle.fill();

    }

    public boolean isItemStatus() {
        return itemStatus;
    }

    @Override
    public TypeOfGameObjects getType() {
        return myType;
    }

    public GridPosition getItemPosition() {
        return itemPosition;
    }

    @Override
    public GridPosition getPosition() {
        return itemPosition;
    }


}
