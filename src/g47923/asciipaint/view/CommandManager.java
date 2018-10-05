package g47923.asciipaint.view;

import g47923.asciipaint.model.AsciiPaint;
import java.util.Arrays;

/**
 *  Manages the commands.
 *
 * @author g47923
 */
public class CommandManager {

    private final AsciiPaint asciiPaint;

    /**
     * Initializes this command manager with the given game.
     *
     * @param asciipaint is the game to control.
     */
    public CommandManager(AsciiPaint asciipaint) {
        this.asciiPaint = asciipaint;
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
        if (!str.equals("show") && !str.equals("add") && !str.equals("exit")) {
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
        if (!str.equals("circle") && !str.equals("rectangle")
                && !str.equals("square") && !str.equals("triangle")) {
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
    void addNewCircle(String... args) {
        asciiPaint.newCircle(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]), args[3].charAt(0));
    }

    /**
     * Adds a new triangle corresponding to the given arguments.
     *
     * @param args are the characteristics of the added triangle.
     */
    void addNewTriangle(String... args) {
        asciiPaint.newTriangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5]),
                args[6].charAt(0));
    }

    /**
     * Adds a new shape to the game drawing.
     *
     * @param shape is the name of the shape.
     * @param args are the argument of the shape.
     */
    void addNewShape(String shape, String... args) {
        switch (shape) {
            case "circle":
                if (args.length < 4) {
                    throw new IllegalArgumentException("Arguments undefined, a "
                            + "circle requires: x, y, radius and a color.");
                }
                addNewCircle(args[0], args[1], args[2], args[3]);
                break;
            case "square":
                if (args.length < 4) {
                    throw new IllegalArgumentException("Arguments undefined, a "
                            + "square requires: x, y, side and a color.");
                }

                addNewSquare(args[0], args[1], args[2], args[3]);
                break;
            case "rectangle":
                if (args.length < 5) {
                    throw new IllegalArgumentException("Arguments undefined, a "
                            + "rectangle requires: x, y, width, length and a color.");
                }
                addNewRectangle(args[0], args[1], args[2], args[3], args[4]);
                break;
            case "triangle":
                if (args.length < 7) {
                    throw new IllegalArgumentException("Arguments undefined, a "
                            + "triangle requires: x1, y1, x2, y2, x3, y3 and a color.");
                }
                addNewTriangle(args[0], args[1], args[2], args[3], args[4],
                        args[5], args[6]);
                break;
            default:
                System.out.println("Unknown shape");
        }
    }

    /**
     * Runs the command entered by the user.
     *
     * @param tokens are the tokens forming the command to run.
     * @return true if the user ask for exiting the program.
     */
    public boolean runCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("No tokens to parse.");
        }
        switch (requireCommandName(tokens[0])) {
            case "add":
                addNewShape(requireShapeName(tokens[1]),
                        Arrays.copyOfRange(tokens, 2, tokens.length));
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
