package g47923.asciipaint.model;

/**
 * Represents a square.
 *
 * @author Logan
 */
public class Square extends Rectangle {

    /**
     * Initializes this square to the given upper left corner, side and color.
     *
     * @param upperLeft is upper left point of this square.
     * @param side is the side length of this square.
     * @param color is the color of this square.
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

}
