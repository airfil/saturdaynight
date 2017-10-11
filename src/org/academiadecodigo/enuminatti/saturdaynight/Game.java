package org.academiadecodigo.enuminatti.saturdaynight;

/**
 * Created by codecadet on 09/10/17.
 */
public class Game {


    static public final int COLS = 80;
    static public final int ROWS = 60;
    private Grid gameGrid;
    private Chick mychick;
    private Player player1;
    private Player player2;
    private Item item;
    private long delay = 200;

    public Game() {


        init();
    }


    public void init() {

        gameGrid = new Grid(COLS, ROWS);

        mychick = new Chick(gameGrid.newGridPostion(25, 25));

        player1 = new Player(gameGrid.newGridPostion(25, 25), 1);
        player2 = new Player(gameGrid.newGridPostion(20, 20), 2);

        //item = new Item(gameGrid.newGridPostion());

        item = new Item(gameGrid.newGridPostion(20, 25));

        mychick.setChickGrid(gameGrid);
    }


    public void gamestart() throws InterruptedException {
        while (true) {

            mychick.move();
            player1.accelarete();
            collision(player1, item);
            player2.accelarete();
            collision(player2, item);
            Thread.sleep(delay);

        }
    }


    public void collision(Player players, Item items) {

        GridPosition item = items.getItemPosition();
        GridPosition player = players.getPos();

        if (player.getCol() == item.getCol() && player.getRow() == item.getRow()) {
            players.whencolide();
            System.out.println(players.items);

            item = null;
            this.item.getItemRectangle().delete();
            this.item = new Item(gameGrid.newGridPosition(gameGrid));
        }


    }

}
