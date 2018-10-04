package g47923.asciipaint;

import g47923.asciipaint.controller.Controller;
import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.model.Drawing;

/**
 * Entry point of the game.
 *
 * @author g47923
 */
public class Application {

    public static void main(String[] args) {
        int width = 50;
        int height = 50;
        try {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.err.println("usage: invalid arguments, it should be the width"
                    + " and height od the drawing.");
        }
        AsciiPaint asciiPaint = new AsciiPaint(new Drawing(width, height));
        Controller c = new Controller(asciiPaint);
        c.start();
    }

}
