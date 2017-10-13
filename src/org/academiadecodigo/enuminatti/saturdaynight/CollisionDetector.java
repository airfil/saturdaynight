package org.academiadecodigo.enuminatti.saturdaynight;


/**
 * Created by codecadet on 12/10/17.
 */
public class CollisionDetector {

    private Collidable[] collidebels;

    public CollisionDetector(Collidable[] collidables) {
        this.collidebels = collidables;
    }

    public void checkObjectColliding(Collidable objChecking) {

        switch (objChecking.getType()) {


            case CHICK:
                Chick chick = (Chick) objChecking;
                checkChickCollision(chick);
                break;
            case PLAYER:
                Player player = (Player) objChecking;
                checkPlayerCollison(player);
                break;
            default:
                return;

        }


    }


    public void checkPlayerCollison(Player player) {
        for (Collidable c : collidebels) {

            if (player == c) {
                continue;
            }

            int col = player.getPosition().getCol();
            int row = player.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {


                switch (c.getType()) {
                    case CHICK:
                        Chick chick = (Chick) c;
                        if (player.getItems() == 3) {
                            chick.whenCollisionHappens();
                        }
                        player.resetItems();
                        break;
                    case ITEM:
                        Item item = (Item) c;
                        item.itemrespawn();
                        player.addItemToPlayer();
                        break;

                }



            }
        }
    }


    public void checkChickCollision(Chick chick) {

        for (Collidable c : collidebels) {

            int col = chick.getPosition().getCol();
            int row = chick.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {

                if (c instanceof Player) {
                    Player myplayer = (Player) c;
                    if (myplayer.getItems() == 3) {
                        chick.whenCollisionHappens();
                    }
                    myplayer.resetItems();

                }

            }
        }
    }


}
