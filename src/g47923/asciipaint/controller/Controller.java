package g47923.asciipaint.controller;

import g47923.asciipaint.model.AsciiPaint;
import g47923.asciipaint.view.View;

/**
 * Manages the logic of the game.
 *
 * @author g47923
 */
public class Controller {

    private final AsciiPaint asciiPaint;
    private final View view;

    /**
     * Initializes this controller with an instance of this game.
     *
     * @param asciiPaint is this game.
     */
    public Controller(AsciiPaint asciiPaint) {
        this.asciiPaint = asciiPaint;
        this.view = new View(asciiPaint);
    }

    /**
     * Starts this game.
     */
    public void start() {
        while (true) {
            view.printPrompt();
            String[] line = splitLine(view.readLine());
            try {
                runCommand(line);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Splits the given line after spaces.
     *
     * @param line is the line to split.
     * @return an array of the split strings.
     */
    public String[] splitLine(String line) {
        return line.split(" ");
    }

    /**
     * Makes sure that the given string is a command name. Two commands are
     * known: add and show.
     *
     * @param str is the string to parse.
     * @return the given command name.
     * @throws IllegalArgumentException if the given string is not a command.
     */
    String requireCommandName(String str) {
        if (!str.equals("show") && !str.equals("add")) {
            throw new IllegalArgumentException("\"" + str + "\" is not "
                    + "a valid command.");
        }
        return str;
    }

    /**
     * Makes sure that the given string is a shape name. Three shape names are
     * known: circle, rectangle and square.
     *
     * @param str is the string to parse.
     * @return the given shape name.
     * @throws IllegalArgumentException if the given string is not a command.
     */
    String requireShapeName(String str) {
        if (!str.equals("circle") && !str.equals("rectangle")
                && !str.equals("square")) {
            throw new IllegalArgumentException("\"" + str + "\" is not "
                    + "a valid shape name.");
        }
        return str;
    }

    /**
     * Adds a new rectangle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added rectangle.
     */
    void addNewRectangle(String... args) {
        asciiPaint.newRectangle(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3]), args[4].charAt(0));
    }

    /**
     * Adds a new square corresponding to the given arguments.
     *
     * @param args are the characteristics of the added square.
     */
    void addNewSquare(String... args) {
        asciiPaint.newSquare(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]), args[3].charAt(0));
    }

    /**
     * Adds a new circle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added circle.
     */
    void addnewCircle(String... args) {
        asciiPaint.newCircle(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]), args[3].charAt(0));
    }

    /**
     * Run the command entered by the user.
     *
     * @param tokens are the tokens forming the command to run.
     */
    void runCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("No tokens to parse.");
        }
        if (requireCommandName(tokens[0]).equals("add")) {
            switch (requireShapeName(tokens[1])) {
                case "circle":
                    addnewCircle(tokens[2], tokens[3], tokens[4], tokens[5]);
                    break;
                case "square":
                    addNewSquare(tokens[2], tokens[3], tokens[4], tokens[5]);
                    break;
                case "rectangle":
                    addNewRectangle(tokens[2], tokens[3], tokens[4], tokens[5],
                            tokens[6]);
            }
        } else {
            System.out.println(asciiPaint.asAscii());
        }
    }

}
