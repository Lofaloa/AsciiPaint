package g47923.asciipaint.view;

import g47923.asciipaint.model.AsciiPaint;
import java.util.Scanner;

/**
 * Represents the view of this game.
 *
 * @author Logan
 */
public class View {

    private final Scanner in;

    /**
     * Initializes this view with the given instance of AsciiPaint.
     *
     * @param asciiPaint is the AsciiPaint of this view.
     */
    public View(AsciiPaint asciiPaint) {
        this.in = new Scanner(System.in, "utf-8");
    }

    /**
     * Prints the title of AsciiPaint.
     */
    public void printTitle() {
        System.out.println("ATL3 - exercice: Ascii Paint, Logan Farci (47923), 2018.");
    }

    /**
     * Prints a prompt for the user.
     */
    public void printPrompt() {
        System.out.print("> ");
    }

    /**
     * Reads the current line.
     *
     * @return the current line.
     */
    public String readLine() {
        String line = in.nextLine();
        while (line.length() == 0) {
            printPrompt();
            line =  in.nextLine();
        }
        return line;     
    }

}