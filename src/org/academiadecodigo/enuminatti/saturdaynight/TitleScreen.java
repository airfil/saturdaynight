package org.academiadecodigo.enuminatti.saturdaynight;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 14/10/2017.
 */
public class TitleScreen implements KeyboardHandler {

    private boolean pressed;
    private Picture menuPictureOne;
    private Picture menuPictureTwo;
    private Keyboard menuKeyboard;
    private KeyboardEvent menuKeyboardEvent;
    public static final int[] menuKeys = {KeyboardEvent.KEY_SPACE};

    public TitleScreen() {

        createKeyboard();
        menuSlide();
        menuPictureOne.draw();
    }

    public void menuSlide() {
        menuPictureOne = new Picture (Grid.PADDING,Grid.PADDING, "/titleScreen1.png");
        menuPictureTwo = new Picture(Grid.PADDING,Grid.PADDING, "/titleScreen2.png");
        menuPictureTwo.draw();
        menuPictureOne.draw();
        while (!pressed) {
            try {
                menuPictureOne.delete();
                Thread.sleep(300);
                menuPictureOne.draw();
                Thread.sleep(300);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void createKeyboard() {
        menuKeyboard = new Keyboard(this);
        menuKeyboardEvent = new KeyboardEvent();
        menuKeyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        menuKeyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        menuKeyboard.addEventListener(menuKeyboardEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        System.out.println("AIRES!");
        menuPictureOne.delete();
        pressed = true;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        menuPictureOne.delete();
        menuPictureTwo.delete();
    }

    public boolean isPressed() {
        return pressed;
    }
}
