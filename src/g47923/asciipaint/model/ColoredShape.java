package g47923.asciipaint.model;

/**
 * Represents a colored shape.
 *
 * @author g47923
 */
abstract class ColoredShape implements Shape{

    private char color;

    /**
     * Initializes this colored shape with the given color.
     *
     * @param color is color of this colored shape.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Gets this colored shape color.
     *
     * @return this colored shape color.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * Sets this colored shape color to the given one.
     *
     * @param color is the color of this colored shape.
     */
    public void setColor(char color) {
        this.color = color;
    }

}
