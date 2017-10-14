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
            case DANCER:
                Dancer dancer = (Dancer) objChecking;
                checkDancerCollision(dancer);
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
                        if (item.isItemStatus() == true) {
                            item.itemRespawn();
                            player.addItemToPlayer();
                            break;
                        }

                        player.addConfidenceToPlayer();
                        break;

                case DANCER:
                    Dancer dancer = (Dancer) c;
                    player.beingPushed(dancer.getPosition().getCurrentDirection());
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

                if (c.getType() == TypeOfGameObjects.PLAYER) {

                    Player player = (Player) c;
                    if (player.getItems() == 3) {
                        chick.whenCollisionHappens();
                    }
                    player.resetItems();
                    break;

                }

            }
        }
    }


    public void checkDancerCollision(Dancer dancer) {

        for (Collidable c : collidebels) {

            int col = dancer.getPosition().getCol();
            int row = dancer.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {

                if (c.getType() == TypeOfGameObjects.PLAYER) {

                    Player player = (Player) c;
                    player.beingPushed(dancer.getPosition().getCurrentDirection());

                }
            }


        }


    }
}

