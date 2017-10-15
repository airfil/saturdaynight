package org.academiadecodigo.enuminatti.saturdaynight;


import java.util.LinkedList;

/**
 * Created by codecadet on 12/10/17.
 */
public class CollisionDetector {

    private LinkedList<Collidable> collidebels;
    private LinkedList<Item> myitems;


    public CollisionDetector(LinkedList<Collidable> collidables, LinkedList<Item> myitems) {
        this.collidebels = collidables;
        this.myitems = myitems;
    }

    public void checkObjectColliding(Collidable objChecking) {

        CheckItemCollision(objChecking);

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
                        if (player.getItems() == 5) {
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
                    int chanceToWin3 = (int) (Math.random() * 100 + (player.getItems() * 5) + player.getConfidence() + chick.getBeer() * 3);
                    System.out.println(chanceToWin3);

                    if (player.getItems() == 3) {
                        if (chanceToWin3 > 90) {

                            System.out.println(player.getItems() + chanceToWin3 + " " + player.getConfidence() + " vamos tentar");
                            chick.whenCollisionHappens();
                            continue;
                        }
                        System.out.println("nao tas suficiente bebado");
                        continue;

                    }
                    if (player.getItems() == 5) {
                        chick.whenCollisionHappens();
                        continue;
                    }

                    System.out.println("reset aos items");
                    player.resetItems();
                    player.resetConfidence();
                    break;

                }
                if (c.getType() == TypeOfGameObjects.ITEM) {
                    Item item = (Item) c;

                    if (item.isItemStatus() == false) {

                        item.itemRespawn();
                        chick.addItemtoChick();
                        break;
                    }
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


    public void CheckItemCollision(Collidable myCollideble) {

        int col = myCollideble.getPosition().getCol();
        int row = myCollideble.getPosition().getRow();


        for (Item item : myitems) {

            if (col == item.getPosition().getCol() && row == item.getPosition().getRow()) {

                if (myCollideble.getType() == TypeOfGameObjects.PLAYER) {
                    if (item.isItemStatus() == true) {
                        System.out.println("item");
                        Player myplayer = (Player) myCollideble;
                        myplayer.addItemToPlayer();
                        item.itemRespawn();
                        continue;
                    }
                    System.out.println("Boa cerveja");
                    Player myplayer = (Player) myCollideble;
                    myplayer.addConfidenceToPlayer();
                    item.itemRespawn();

                }
                if (myCollideble.getType() == TypeOfGameObjects.CHICK) {

                    if (item.isItemStatus() == false) {

                        Chick myChick = (Chick) myCollideble;
                        myChick.addItemtoChick();
                        System.out.println("Alerta Gaja bebada" + myChick.getBeer());
                        item.itemRespawn();
                    }
                }


            }


        }
    }
}
