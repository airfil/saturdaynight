package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 09/10/17.
 */
public class Item implements Collidable {

    // CONSTANT the typeof this Gameobject will alwasys be a Item
    public static final TypeOfGameObjects myType = TypeOfGameObjects.ITEM;

    private GridPosition itemPosition;
    private Picture itemPicture;
    private boolean itemStatus;


    public Item(GridPosition itemPosition, boolean itemType) {

        this.itemPosition = itemPosition;
        this.itemStatus = itemType;

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());
        if (itemType == false) {

            itemPicture = new Picture(x, y, "/cerveja2.png");
            itemPicture.draw();
            return;
        }
        itemPicture = new Picture(x, y, "/item.png");
        itemPicture.draw();

    }

    public void itemRespawn() {

        itemPicture.delete();


        itemPosition.setCol((int) Math.floor(Math.random() * itemPosition.getGameGrid().getCols() ));
        itemPosition.setRow((int) Math.floor(Math.random() * itemPosition.getGameGrid().getRows() ));

        int x = itemPosition.getGameGrid().colToX(itemPosition.getCol());
        int y = itemPosition.getGameGrid().rowToY(itemPosition.getRow());

        if (this.itemStatus == false) {
            itemPicture = new Picture(x, y, "/cerveja2.png");
            this.itemPicture.draw();
            return;
        }
        itemPicture = new Picture(x, y, "/item.png");
        itemPicture.draw();

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
