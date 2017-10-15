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
    private boolean instructionsRead;
    public static final int[] menuKeys = {KeyboardEvent.KEY_SPACE};
    private Picture instructions;

    public TitleScreen() {

        createKeyboard();
        menuSlide();
    }

    public void menuSlide() {
        menuPictureOne = new Picture(Grid.PADDING, Grid.PADDING, "/resources/titleScreen1.png");
        menuPictureTwo = new Picture(Grid.PADDING, Grid.PADDING, "/resources/titleScreen2.png");
        instructions = new Picture(Grid.PADDING, Grid.PADDING, "/resources/instructionsScreen.png");
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
        pressed = false;
        menuPictureOne.delete();
        menuPictureTwo.delete();

        instructions.draw();
        while (!pressed) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        instructions.delete();
        instructionsRead = true;



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

        if (!instructionsRead) {
            pressed = true;
            return;
        }

        pressed = true;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isInstructionsRead() {
        return instructionsRead;
    }
}
