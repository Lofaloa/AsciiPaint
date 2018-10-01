package g47923.asciipaint.view;

import g47923.asciipaint.model.AsciiPaint;
import java.util.Scanner;

/**
 * Represents the view of this game.
 *
 * @author Logan
 */
public class View {

    private AsciiPaint asciiPaint;
    private Scanner in;

    //users enters cmd shape x y color
    //              +----> add or show
    //                     +      +--> System.out.println(AsciiPaint.asAscii());
    //                     +---------> circle rectangle or square?
    /**
     * Initializes this view with the given instance of AsciiPaint.
     *
     * @param asciiPaint is the AsciiPaint of this view.
     */
    public View(AsciiPaint asciiPaint) {
        this.asciiPaint = asciiPaint;
        this.in = new Scanner(System.in);
    }

    /**
     * Reads the current line.
     *
     * @return the current line.
     */
    public String readLine() {
        return in.nextLine();
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

    public String[] parseCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("No tokens to parse.");
        }
        if (requireCommandName(tokens[0]).equals("add")) {
            switch (requireShapeName(tokens[1])) {
                case "circle":
                    asciiPaint.newCircle(Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), tokens[5].charAt(0));
                    break;
                case "square":
                    asciiPaint.newSquare(Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), tokens[5].charAt(0));
                    break;
                case "rectangle":
                    asciiPaint.newRectangle(Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]), tokens[6].charAt(0));
            }
        } else {
            System.out.println(asciiPaint.asAscii());
        }
        return tokens;
    }

}