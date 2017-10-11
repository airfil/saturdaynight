package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 09/10/17.
 */
public class Item {

    private Grid itemGrid;
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


    public void setItemGrid(Grid itemGrid) {
        this.itemGrid = itemGrid;
    }

    public GridPosition getItemPosition() {
        return itemPosition;
    }

    public Rectangle getItemRectangle() {
        return itemRectangle;
    }
}
