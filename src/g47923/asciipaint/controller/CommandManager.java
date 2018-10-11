package g47923.asciipaint.controller;

import g47923.asciipaint.model.AsciiPaint;
import java.util.Arrays;
import g47923.asciipaint.view.View;
import static java.lang.Integer.parseInt;
import java.util.Locale;

/**
 * Manages the commands.
 *
 * @author g47923
 */
class CommandManager {

    private final AsciiPaint asciiPaint;
    private final String[] commandNames;
    private final String[] shapeNames;

    /**
     * Initializes this command manager with the given game.
     *
     * @param asciipaint is the game to control.
     */
    public CommandManager(AsciiPaint asciipaint) {
        this.asciiPaint = asciipaint;
        this.commandNames = new String[]{"add", "show", "remove", "move", "exit",
            "help"};
        this.shapeNames = new String[]{"circle", "rectangle", "triangle", "square"};
    }

    /**
     * Tells if the given string is a command name.
     *
     * @param str is the string to analyze.
     * @return true if the given string is a command name.
     */
    boolean isCommandName(String str) {
        return Arrays.asList(commandNames).contains(str);
    }

    /**
     * Tells if the given string is a shape name.
     *
     * @param str is the string to analyze.
     * @return true if the given string is a shape name.
     */
    boolean isShapeName(String str) {
        return Arrays.asList(shapeNames).contains(str);
    }

    /**
     * Splits the given line after a white space.
     *
     * @param line is the line to split.
     * @return an array of the split strings.
     */
    public String[] splitLine(String line) {
        return line.split("\\s+");
    }

    /**
     * Makes sure that the given string is a command name. Three commands are
     * known: add, show and exit.
     *
     * @param str is the string to parse.
     * @return the given command name.
     * @throws IllegalArgumentException if the given string is not a command.
     */
    String requireCommandName(String str) {
        if (!isCommandName(str.toLowerCase(Locale.getDefault()))) {
            throw new IllegalArgumentException("\"" + str + "\" is not "
                    + "a command.");
        }
        return str;
    }

    /**
     * Makes sure that the given string is a shape name. Four shape names are
     * known: circle, rectangle, triangle and square.
     *
     * @param str is the string to parse.
     * @return the given shape name.
     * @throws IllegalArgumentException if the given string is not a shape name.
     */
    String requireShapeName(String str) {
        if (!isShapeName(str.toLowerCase(Locale.getDefault()))) {
            throw new IllegalArgumentException("\"" + str + "\" is not "
                    + "a valid shape name.");
        }
        return str;
    }

    /**
     * Adds a new rectangle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added rectangle.
     * @throws IllegalArgumentException if args lacks required argument.
     */
    void addNewRectangle(String[] args) {
        if (args.length < 5) {
            throw new IllegalArgumentException("Arguments undefined, a "
                    + "rectangle requires: x, y, width, length and a color.");
        }
        asciiPaint.newRectangle(parseInt(args[0]), parseInt(args[1]),
                parseInt(args[2]), parseInt(args[3]), args[4].charAt(0));
    }

    /**
     * Adds a new square corresponding to the given arguments.
     *
     * @param args are the characteristics of the added square.
     * @throws IllegalArgumentException if args lacks required argument.
     *
     */
    void addNewSquare(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Arguments undefined, a "
                    + "square requires: x, y, side and a color.");
        }
        asciiPaint.newSquare(parseInt(args[0]), parseInt(args[1]),
                parseInt(args[2]), args[3].charAt(0));
    }

    /**
     * Adds a new circle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added circle.
     * @throws IllegalArgumentException if args lacks required argument.
     *
     */
    void addNewCircle(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Arguments undefined, a "
                    + "circle requires: x, y, radius and a color.");
        }
        asciiPaint.newCircle(parseInt(args[0]), parseInt(args[1]),
                parseInt(args[2]), args[3].charAt(0));
    }

    /**
     * Adds a new triangle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added triangle.
     * @throws IllegalArgumentException if args lacks required argument.
     */
    void addNewTriangle(String... args) {
        if (args.length < 7) {
            throw new IllegalArgumentException("Arguments undefined, a "
                    + "triangle requires: x1, y1, x2, y2, x3, y3 and a color.");
        }
        asciiPaint.newTriangle(parseInt(args[0]), parseInt(args[1]),
                parseInt(args[2]), parseInt(args[3]), parseInt(args[4]),
                parseInt(args[5]), args[6].charAt(0));
    }

    /**
     * Adds a new shape to the game drawing.
     *
     * @param shape is the name of the shape.
     * @param args are the argument of the shape.
     * @throws IllegalArgumentException is the given shape name does not exist.
     */
    void addNewShape(String shape, String... args) {
        switch (shape) {
            case "circle":
                addNewCircle(args);
                break;
            case "square":
                addNewSquare(args);
                break;
            case "rectangle":
                addNewRectangle(args);
                break;
            case "triangle":
                addNewTriangle(args);
                break;
            default:
                throw new IllegalArgumentException("\"" + shape + "\" is not a "
                        + "shape.");
        }
    }

    /**
     * Moves the shape containing the given point.
     *
     * @param x is the x position of the point.
     * @param y is the y position of the point.
     * @param dx is the difference added to the x position of the shape to move.
     * @param dy is the difference added to the y position of the shape to move.
     * @throws IllegalArgumentException if there is no shape to move.
     */
    void moveShapeAt(String x, String y, String dx, String dy) {
        asciiPaint.moveShapeAt(parseInt(x), parseInt(y), parseInt(dx),
                parseInt(dy));
    }

    /**
     * Removes the shape containing the given point.
     *
     * @param x is the x position of the point.
     * @param y is the y position of the point.
     * @throws IllegalArgumentException if there is no shape to remove.
     */
    void removeShapeAt(String x, String y) {
        asciiPaint.removeShapeAt(parseInt(x), parseInt(y));
    }

    /**
     * Executes the command entered by the user.
     *
     * @param tokens are the tokens forming the command to run.
     * @return true if the user ask for exiting the program.
     */
    public boolean executeCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("No tokens to parse.");
        }
        switch (requireCommandName(tokens[0])) {
            case "add":
                if (tokens.length == 1) {
                    throw new IllegalArgumentException("add requires arguments.");
                }
                addNewShape(requireShapeName(tokens[1]),
                        Arrays.copyOfRange(tokens, 2, tokens.length));
                break;
            case "remove":
                if (tokens.length < 3) {
                    throw new IllegalArgumentException("Not enough arguments,"
                            + " remove requires: x and y.");
                }
                removeShapeAt(tokens[1], tokens[2]);
                break;
            case "move":
                if (tokens.length < 5) {
                    throw new IllegalArgumentException("Not enough arguments, "
                            + "move requires: x, y, dx, dy.");
                }
                moveShapeAt(tokens[1], tokens[2], tokens[3], tokens[4]);
                break;
            case "help":
                new View(asciiPaint).printHelp();
                break;
            case "show":
                System.out.println(asciiPaint.asAscii());
                break;
            default:
                return true;
        }
        return false;
    }

}
