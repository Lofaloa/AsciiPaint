package g47923.asciipaint.controller;

import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.view.View;

/**
 * Manages the logic of the game.
 *
 * @author g47923
 */
public class Controller {

    private AsciiPaint asciiPaint;
    private View view;

    public Controller(AsciiPaint asciiPaint) {
        this.asciiPaint = asciiPaint;
        this.view = new View(asciiPaint);
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String[] line = view.splitLine(view.readLine());
            view.parseCommand(line);
        }
    }

}
