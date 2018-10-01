package g47923.asciipaint;

import g47923.asciipaint.controller.Controller;
import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.model.Drawing;

/**
 * Entry point of the game.
 *
 * @author Logan
 */
public class Application {

    public static void main(String[] args) {
        AsciiPaint asciiPaint = new AsciiPaint(new Drawing(30, 30));
        Controller c = new Controller(asciiPaint);
        c.start();
    }

}
