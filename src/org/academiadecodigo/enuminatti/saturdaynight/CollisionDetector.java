package org.academiadecodigo.enuminatti.saturdaynight;


import org.academiadecodigo.enuminatti.saturdaynight.utils.Sound;

import java.util.LinkedList;

/**
 * Created by codecadet on 12/10/17.
 */
public class CollisionDetector {

    private LinkedList<Collidable> collidables;
    private LinkedList<Item> myItems;
    private Sound beerSound = new Sound("/resources/gluglu3.wav");
    private Sound chickFail = new Sound("/resources/chickFail.wav");
    private Sound chickWin = new Sound("/resources/jafaturaste.wav");
    private Sound dancerCollide = new Sound("/resources/saidaf.wav");
    private Sound itemSound = new Sound("/resources/catchinga.wav");



    public CollisionDetector(LinkedList<Collidable> collidables, LinkedList<Item> myItems) {
        this.collidables = collidables;
        this.myItems = myItems;
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
                checkPlayerCollision(player);
                break;
            case DANCER:
                Dancer dancer = (Dancer) objChecking;
                checkDancerCollision(dancer);
                break;
            default:
                return;

        }


    }


    public void checkPlayerCollision(Player player) {
        for (Collidable c : collidables) {

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

        for (Collidable c : collidables) {

            int col = chick.getPosition().getCol();
            int row = chick.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {

                if (c.getType() == TypeOfGameObjects.PLAYER) {

                    Player player = (Player) c;
                    int chanceToWin3 = (int) (Math.random() * 100 + (player.getItems() * 5) + player.getConfidence());

                    if (player.getItems() == 5) {
                        chickWin.play(true);
                        chick.whenCollisionHappens();
                        continue;
                    }

                    if (player.getItems() >= 3 && player.getItems() < 5) {
                        if (chanceToWin3 > 90) {

                            chickWin.play(true);
                            chick.whenCollisionHappens();
                            continue;
                        }

                    }

                    player.resetItems();
                    player.resetConfidence();
                    chickFail.play(true);
                    break;

                }

            }
        }
    }


    public void checkDancerCollision(Dancer dancer) {

        for (Collidable c : collidables) {

            int col = dancer.getPosition().getCol();
            int row = dancer.getPosition().getRow();

            if (col == c.getPosition().getCol() && row == c.getPosition().getRow()) {

                if (c.getType() == TypeOfGameObjects.PLAYER) {

                    Player player = (Player) c;
                    player.beingPushed(dancer.getPosition().getCurrentDirection());
                    dancerCollide.play(true);

                }
            }


        }


    }


    public void CheckItemCollision(Collidable myCollidable) {

        int col = myCollidable.getPosition().getCol();
        int row = myCollidable.getPosition().getRow();


        for (Item item : myItems) {

            if (col == item.getPosition().getCol() && row == item.getPosition().getRow()) {

                if (myCollidable.getType() == TypeOfGameObjects.PLAYER) {
                    if (item.isItemStatus() == true) {
                        itemSound.play(true);
                        Player myPlayer = (Player) myCollidable;
                        myPlayer.addItemToPlayer();
                        item.itemRespawn();
                        continue;
                    }
                    beerSound.play(true);
                    Player myPlayer = (Player) myCollidable;
                    myPlayer.addConfidenceToPlayer();
                    item.itemRespawn();

                }


            }


        }
    }
}
