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

        if (objChecking instanceof Player) {
            Player player = (Player) objChecking;
            checkPlayerCollison(player);
        }

        if (objChecking instanceof Chick) {
            Chick mychick = (Chick) objChecking;
            checkChickCollision(mychick);
        }


    }


    public void checkPlayerCollison(Player player) {
        for (Collidable c : collidebels) {

            if(player == c){
                continue;
            }

            int col = player.getPosition().getCol();
            int row = player.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {

                if (c instanceof Chick) {
                    Chick chick = (Chick) c;
                    if (player.getItems()== 3) {
                        chick.whenCollisionHappens();
                    }
                    player.resetItems();
                }

                if (c instanceof Item) {
                    Item item = (Item) c;
                    item.itemrespawn();
                    player.addItemToPlayer();

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
