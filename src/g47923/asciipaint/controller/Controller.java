package g47923.asciipaint.controller;

import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.view.CommandManager;
import g47923.asciipaint.view.View;

/**
 * Manages the logic of the game.
 *
 * @author g47923
 */
public class Controller {

    private final CommandManager commandMangager;
    private final View view;

    /**
     * Initializes this controller with an instance of this game.
     *
     * @param asciiPaint is this game.
     */
    public Controller(AsciiPaint asciiPaint) {
        this.view = new View(asciiPaint);
        this.commandMangager = new CommandManager(asciiPaint);
    }

    /**
     * Starts this game.
     */
    public void start() {
        boolean isOver = false;
        while (!isOver) {
            view.printPrompt();
            String[] line = commandMangager.splitLine(view.readLine());
            try {
                isOver = commandMangager.runCommand(line);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
