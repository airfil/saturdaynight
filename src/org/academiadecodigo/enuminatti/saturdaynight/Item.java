package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 09/10/17.
 */
public class Item implements Collidable {

    // CONSTANT the typeof this Gameobject will alwasys be a Item
    public static final TypeOfGameobjects myType = TypeOfGameobjects.ITEM;

    private GridPosition itemPosition;
    private Rectangle itemRectangle;


    public Item(GridPosition itemPosition) {


        this.itemPosition = itemPosition;

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());

        this.itemRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);
        itemRectangle.setColor(Color.BLACK);
        itemRectangle.fill();

    }


    public void itemrespawn() {

        itemRectangle.delete();


        itemPosition.setCol((int) Math.floor(Math.random() * itemPosition.getGameGrid().getCols() - 2));
        itemPosition.setRow((int) Math.floor(Math.random() * itemPosition.getGameGrid().getRows() - 2));

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());

        this.itemRectangle = new Rectangle(x, y, Grid.CELLSIZE, Grid.CELLSIZE);


        itemRectangle.fill();

    }


    @Override
    public TypeOfGameobjects getType() {
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
